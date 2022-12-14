package servis;

import Domen.TransferObject;
import broker.Broker;

public class ServisRestoranGETslika extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperacija(TransferObject transferObject) {
		// TODO Auto-generated method stub
		Integer i = (Integer) transferObject.getRequest()	;
		int idres = i;
		Broker b = new Broker();
		transferObject.setResponse(b.getSlika(idres));
		

	}

}
