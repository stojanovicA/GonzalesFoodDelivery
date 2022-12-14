package servis;


import Domen.Jelo;
import Domen.TransferObject;
import broker.Broker;

public class ServisJeloObrisi extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuSistemskuOperacija(TransferObject transferObject) {
		int idJela = (int) transferObject.getRequest();
		Broker broker = new Broker();
		broker.deleteJelo(idJela);
		

	}

}
