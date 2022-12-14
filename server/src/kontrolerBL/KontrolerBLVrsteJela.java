package kontrolerBL;

import Domen.KonstanteBL;
import Domen.TransferObject;
import servis.OpstaSistemskaOperacija;
import servis.ServisJeloVrste;


public class KontrolerBLVrsteJela implements CommandBase {

	@Override
	public void execute(TransferObject transferObject) {
		OpstaSistemskaOperacija op = null;
		if(transferObject.getKonstanteBl() == KonstanteBL.GET) {
			op = new ServisJeloVrste();
		}
		op.izvrsiSistemskuOperaciju(transferObject);
		
	}

}


