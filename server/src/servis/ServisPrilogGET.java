package servis;


import Domen.Prilog;
import Domen.TransferObject;
import Domen.User;
import broker.Broker;

public class ServisPrilogGET extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperacija(TransferObject transferObject) {
		 User u = (User) transferObject.getRequest();
		 int idUser = u.getStatus()	;
		Broker b = new Broker();
		transferObject.setResponse(b.selectAllID(idUser, new Prilog()));
	}

}
 