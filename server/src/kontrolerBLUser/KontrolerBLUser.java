package kontrolerBLUser;

import Domen.KonstanteBL;
import Domen.TransferObject;
import kontrolerBL.CommandBase;
import servis.OpstaSistemskaOperacija;
import servis.ServisUserSacuvaj;
import servis.ServisUserGET;
import servis.ServisUserUPDATE;

public class KontrolerBLUser implements CommandBase{

	@Override
	public void execute(TransferObject transferObject) {
		OpstaSistemskaOperacija op = null;
		if(transferObject.getKonstanteBl() == KonstanteBL.POST) {
			op = new ServisUserSacuvaj();
		}else if(transferObject.getKonstanteBl() == KonstanteBL.GET_USER) {
			op = new ServisUserGET();
		}else if(transferObject.getKonstanteBl() == KonstanteBL.PUT) {
			op = new ServisUserUPDATE();
		}
		op.izvrsiSistemskuOperaciju(transferObject);
		
	}

}
