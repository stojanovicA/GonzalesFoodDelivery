package kontrolerBL;

import Domen.KonstanteBL;
import Domen.TransferObject;
import servis.OpstaSistemskaOperacija;

import servis.ServisRestoranGET;
import servis.ServisRestoranGETslika;
import servis.ServisRestoranUPDATEinfo;

public class KontrolerBLRestoran implements CommandBase {

	@Override
	public void execute(TransferObject transferObject) {
			OpstaSistemskaOperacija op = null;
			
			if(transferObject.getKonstanteBl() == KonstanteBL.GET) {
				op = new ServisRestoranGET();
			}else if(transferObject.getKonstanteBl() == KonstanteBL.PUT) {
				op = new ServisRestoranUPDATEinfo();
			}else if(transferObject.getKonstanteBl() == KonstanteBL.GET_SLIKA) {
				op = new ServisRestoranGETslika();
			}
			op.izvrsiSistemskuOperaciju(transferObject);
			

	

}
}



