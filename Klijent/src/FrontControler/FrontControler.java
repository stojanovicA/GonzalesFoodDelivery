package FrontControler;

import java.io.IOException;
import java.net.Socket;

import Domen.TransferObject;
import Komunikacija.Komunikacija;

public class FrontControler {
	
	private static FrontControler instanca;
	private Socket socket;
	
	private FrontControler () {
	
		
	}
	public static FrontControler getInstaca() {
	if (instanca == null) {
		instanca = new FrontControler();
	}
	return instanca;
	}
	public TransferObject execute(TransferObject transferObject) throws ClassNotFoundException, IOException{
		Komunikacija.getInstanca().send(transferObject);
		return Komunikacija.getInstanca().read();
		
		
	}
}
