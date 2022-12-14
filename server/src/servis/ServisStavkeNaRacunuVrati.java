package servis;

import Domen.TransferObject;
import broker.Broker;

public class ServisStavkeNaRacunuVrati extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperacija(TransferObject transferObject) {
		int idRacun = (int) transferObject.getRequest();
		Broker b = new Broker();
		transferObject.setResponse(b.VratiStavkeNaRacunu(idRacun));
		

	}

}
