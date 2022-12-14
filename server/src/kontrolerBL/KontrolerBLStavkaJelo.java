package kontrolerBL;

import Domen.KonstanteBL;
import Domen.TransferObject;
import servis.OpstaSistemskaOperacija;
import servis.ServisStavkaJeloPOST;


public class KontrolerBLStavkaJelo implements CommandBase {

	@Override
	public void execute(TransferObject transferObject) {
		OpstaSistemskaOperacija op = null;
		if(transferObject.getKonstanteBl() == KonstanteBL.POST) {
			op = new ServisStavkaJeloPOST();
		}
		op.izvrsiSistemskuOperaciju(transferObject);

	}

}
