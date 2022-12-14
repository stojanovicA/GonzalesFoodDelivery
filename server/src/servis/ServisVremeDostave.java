package servis;

import Domen.Sqlexception;
import Domen.TransferObject;
import Domen.VremeDostave;
import broker.Broker;

public class ServisVremeDostave extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperacija(TransferObject transferObject) {
		VremeDostave vd = (VremeDostave) transferObject.getRequest();
		Broker b = new Broker();
		try {
			b.insert(vd);
		} catch (Sqlexception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
