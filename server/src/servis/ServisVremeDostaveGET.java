package servis;

import Domen.Racun;
import Domen.TransferObject;
import broker.Broker;

public class ServisVremeDostaveGET extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperacija(TransferObject transferObject) {
		// TODO Auto-generated method stub
		Racun r = (Racun) transferObject.getRequest()	;
		Broker b = new Broker();
		transferObject.setResponse(b.GetVreme(r));
	}

}
