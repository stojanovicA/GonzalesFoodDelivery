package servis;

import Domen.Sqlexception;
import Domen.TransferObject;
import Domen.User;
import broker.Broker;

public class ServisUserSacuvaj extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperacija(TransferObject transferObject) {
		User u  = (User) transferObject.getRequest();
		Broker broker = new Broker();
		try {
			broker.insert(u);
			transferObject.setMessage("Uspesna registracija");
		} catch (Sqlexception e) {
			// TODO Auto-generated catch block
			transferObject.setMessage("Korisnicko ime je zauzeto");
		}

	}

}
