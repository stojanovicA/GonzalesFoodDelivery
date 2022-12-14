package servis;

import Domen.OpstiDomen;
import Domen.TransferObject;
import Domen.User;
import broker.Broker;

public class ServisUserUPDATE extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperacija(TransferObject transferObject) {
		// TODO Auto-generated method stub
			User u = (User) transferObject.getRequest()	;
			Broker b = new Broker()	;
			b.updateUser(u);
	}

}
