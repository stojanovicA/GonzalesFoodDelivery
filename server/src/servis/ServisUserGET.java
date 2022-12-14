package servis;

import Domen.TransferObject;
import Domen.User;
import broker.Broker;

public class ServisUserGET extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperacija(TransferObject transferObject) {
		// TODO Auto-generated method stub
			User u = (User) transferObject.getRequest();
			Broker b = new Broker();
			transferObject.setResponse(b.vratiUsera(u));
	}

}
