package servis;

import Domen.Sqlexception;
import Domen.StavkaJelo;
import Domen.TransferObject;
import broker.Broker;

public class ServisStavkaJeloPOST extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperacija(TransferObject transferObject) {
		// TODO Auto-generated method stub
		StavkaJelo s = (StavkaJelo) transferObject.getRequest()	;
		Broker b  = new Broker();
		try {
			b.insert(s);
		} catch (Sqlexception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
