package servis;

import Domen.Racun;
import Domen.TransferObject;
import broker.Broker;

public class ServisRacunGET extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperacija(TransferObject transferObject) {
		Racun r = (Racun) transferObject.getRequest()	;
		Broker b = new Broker();
		transferObject.setResponse(b.getRacun(r));
	}

}
