package servis;


import Domen.Jelo;

import Domen.TransferObject;
import Domen.User;
import broker.Broker;

public class ServisJeloVratiSve extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperacija(TransferObject transferObject) {
		// TODO Auto-generated method stub
		

		    User u = (User) transferObject.getRequest();
		    int idUser = u.getStatus()	;
			Broker b = new Broker();
			transferObject.setResponse(b.selectAllID(idUser,new Jelo()));
	}

}
