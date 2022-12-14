package servis;

import Domen.Prilog;
import Domen.Sqlexception;
import Domen.TransferObject;
import broker.Broker;

public class ServisPrilogPOST extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperacija(TransferObject transferObject) {
		Prilog p = (Prilog) transferObject.getRequest();
		Broker broker = new Broker();
		try {
			broker.insert(p);
		} catch (Sqlexception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
