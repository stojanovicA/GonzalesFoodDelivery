package servis;

import Domen.TransferObject;
import broker.Broker;

public class ServisRacunUPDATE extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperacija(TransferObject transferObject) {
		// TODO Auto-generated method stub
		int idRacun = (int) transferObject.getRequest();
		Broker b = new Broker();
		b.UpdateRacunPrihvati(idRacun);

	}

}
