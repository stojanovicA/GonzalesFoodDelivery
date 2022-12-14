package servis;


import Domen.Racun;
import Domen.TransferObject;
import Domen.User;
import broker.Broker;

public class ServisRacunGETALL extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperacija(TransferObject transferObject) {
		User u = (User) transferObject.getRequest();
	    int idUser = u.getStatus()	;
		Broker b = new Broker();
		transferObject.setResponse(b.selectAllID(idUser,new Racun()));
	}

}
