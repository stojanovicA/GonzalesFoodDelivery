package servis;

import Domen.TransferObject;
import broker.Broker;

public class ServisPrilogDELETE extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperacija(TransferObject transferObject) {
		int idPrilog = (int) transferObject.getRequest();
		Broker broker = new Broker();
		broker.deletePrilog(idPrilog);
	}

}
