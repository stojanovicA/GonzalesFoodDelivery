package servis;

import Domen.Jelo;
import Domen.Sqlexception;
import Domen.TransferObject;
import broker.Broker;

public class ServisJeloUnesi extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperacija(TransferObject transferObject) {
		Jelo j = (Jelo) transferObject.getRequest();
		Broker broker = new Broker();
		try {
			broker.insert(j);
			transferObject.setMessage("Uspesan unos");
		} catch (Sqlexception e) {
			// TODO Auto-generated catch block
			transferObject.setMessage("Proverite da li su sva polja tacno ispunjena");
		}

	}

}
