package servis;

import Domen.Racun;
import Domen.TransferObject;
import Domen.User;
import broker.Broker;

public class ServisRacunGETforUser extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperacija(TransferObject transferObject) {
		User u = (User) transferObject.getRequest();
	    String ime = u.getUsername()	;
		Broker b = new Broker();
		transferObject.setResponse(b.selectAllIDuser(ime,new Racun()));

	}

}
