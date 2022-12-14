package servis;

import javax.swing.JOptionPane;

import Domen.Racun;
import Domen.Sqlexception;
import Domen.TransferObject;
import broker.Broker;

public class ServisRacunPOST extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperacija(TransferObject transferObject) {
		// TODO Auto-generated method stub
		Racun racun = (Racun) transferObject.getRequest();
		Broker broker = new Broker()	;
		try {
			broker.insert(racun);
		} catch (Sqlexception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Molimo Vas proverite da li ste uneli sva polja");
		}

	}

}
