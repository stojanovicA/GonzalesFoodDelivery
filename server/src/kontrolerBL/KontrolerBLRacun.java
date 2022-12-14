package kontrolerBL;

import Domen.KonstanteBL;
import Domen.TransferObject;
import servis.OpstaSistemskaOperacija;
import servis.ServisRacunGET;
import servis.ServisRacunGETALL;
import servis.ServisRacunGETLAST;
import servis.ServisRacunGETforUser;
import servis.ServisRacunPOST;
import servis.ServisRacunUPDATE;
import servis.ServisRacunUPDATEreject;


public class KontrolerBLRacun implements CommandBase {

	@Override
	public void execute(TransferObject transferObject) {
		OpstaSistemskaOperacija op = null;
		if(transferObject.getKonstanteBl() == KonstanteBL.GET) {
			op = new ServisRacunGETALL();
		}else if(transferObject.getKonstanteBl()== KonstanteBL.PUT) {
			op = new ServisRacunUPDATE();
		}else if(transferObject.getKonstanteBl()==KonstanteBL.PUT_REJECT) {
			op = new ServisRacunUPDATEreject();
		}else if (transferObject.getKonstanteBl()== KonstanteBL.POST) {
			op = new ServisRacunPOST();
		}else if(transferObject.getKonstanteBl()== KonstanteBL.GET_LAST) {
			op = new ServisRacunGETLAST();
		}else if(transferObject.getKonstanteBl() == KonstanteBL.GET_RACUN) {
			op = new ServisRacunGET();
		}else if(transferObject.getKonstanteBl() == KonstanteBL.GET_FOR_USER) {
			op = new ServisRacunGETforUser();
		}
		op.izvrsiSistemskuOperaciju(transferObject);
	}
}
