package kontrolerBL;

import Domen.KonstanteBL;
import Domen.TransferObject;
import servis.OpstaSistemskaOperacija;
import servis.ServisVremeDostave;
import servis.ServisVremeDostaveGET;


public class KontrolerBLVremeDostave implements CommandBase {

	@Override
	public void execute(TransferObject transferObject) {
		OpstaSistemskaOperacija op = null;
		if(transferObject.getKonstanteBl() == KonstanteBL.POST) {
			op = new ServisVremeDostave();
		}else if (transferObject.getKonstanteBl() == KonstanteBL.GET) {
			op = new ServisVremeDostaveGET();
		}
		op.izvrsiSistemskuOperaciju(transferObject);

	}

}
