package niti;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Domen.TransferObject;
import kontrolerBL.CommandBase;
import kontrolerBL.KontrolerBLPrilozi;
import kontrolerBL.KontrolerBLRacun;
import kontrolerBL.KontrolerBLRestoran;
import kontrolerBL.KontrolerBLStavkaJelo;
import kontrolerBL.KontrolerBLStavkeNaRacunu;
import kontrolerBL.KontrolerBLVremeDostave;
import kontrolerBL.KontrolerBLVrsteJela;
import kontrolerBL.Jela.KontrolerBLJela;
import kontrolerBLUser.KontrolerBLUser;

public class KlijentTread extends Thread{
	
	private Socket socket;

	public KlijentTread(Socket socket) {
		super();
		this.socket = socket;
	}
	@Override
	public void run() {
		while(true) {
			try {
				ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
				TransferObject tr = (TransferObject) objectInputStream.readObject()	;
				obradiPodatak(tr);
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void obradiPodatak(TransferObject tr) {
		
		CommandBase commandBase = null;
		
		switch (tr.getKonstanteFk()) {
			case JELO:
		    commandBase = new KontrolerBLJela()	;
			break;
			
		
			case USER:
				commandBase = new KontrolerBLUser();
				break;
				
			case VRSTE_JELA:
				commandBase = new KontrolerBLVrsteJela();
				break;
				
			case PRILOG:
				commandBase = new KontrolerBLPrilozi();
				break;
				
			case RACUN:
				commandBase = new KontrolerBLRacun();
				break;
				
			case STAVKE_NA_RACUNU:
				commandBase = new KontrolerBLStavkeNaRacunu();
				break;
				
			case VREMEDOSTAVE:
				commandBase = new KontrolerBLVremeDostave();
				break;
			
			case RESTORAN:
				commandBase = new KontrolerBLRestoran();
				break;
				
			case STAVKA_JELO:
				commandBase = new KontrolerBLStavkaJelo();
				break;

		default:
			break;
	}
		commandBase.execute(tr);
		send(tr);
		
	}
	private void send(TransferObject tr) {
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.writeObject(tr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


