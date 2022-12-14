package kontrolerBL;

import Domen.KonstanteBL;
import Domen.TransferObject;
import servis.OpstaSistemskaOperacija;
import servis.ServisStavkeNaRacunuVrati;

public class KontrolerBLStavkeNaRacunu implements CommandBase {

	@Override
	public void execute(TransferObject transferObject) {
		OpstaSistemskaOperacija op = null;
		if(transferObject.getKonstanteBl() == KonstanteBL.GET) {
			op = new ServisStavkeNaRacunuVrati();
		}
		op.izvrsiSistemskuOperaciju(transferObject);
	}

}
