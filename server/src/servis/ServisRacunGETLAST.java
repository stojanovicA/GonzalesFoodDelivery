package servis;


import Domen.TransferObject;
import Domen.User;
import broker.Broker;

public class ServisRacunGETLAST extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperacija(TransferObject transferObject) {
		User u = (User) transferObject.getRequest();
	   
		Broker b = new Broker();
		transferObject.setResponse(b.getLast(u));

	}

}
