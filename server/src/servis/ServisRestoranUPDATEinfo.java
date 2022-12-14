package servis;


import Domen.Restoran;
import Domen.TransferObject;
import broker.Broker;

public class ServisRestoranUPDATEinfo extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperacija(TransferObject transferObject) {
		Restoran r = (Restoran) transferObject.getRequest();
		Broker b = new Broker();
		b.update(r);
	}

}
