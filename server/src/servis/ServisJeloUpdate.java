package servis;

import Domen.Jelo;
import Domen.TransferObject;
import broker.Broker;

public class ServisJeloUpdate extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperacija(TransferObject transferObject) {
		// TODO Auto-generated method stub
		Jelo jelo = (Jelo) transferObject.getRequest();
		Broker b = new Broker();
		b.update(jelo);

	}

}
