package servis;

import Domen.TransferObject;
import Domen.VrsteJela;
import broker.Broker;

public class ServisJeloVrste extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperacija(TransferObject transferObject) {
		// TODO Auto-generated method stub

		Broker b = new Broker();
		transferObject.setResponse(b.selectAll(new VrsteJela()));
	}

}
