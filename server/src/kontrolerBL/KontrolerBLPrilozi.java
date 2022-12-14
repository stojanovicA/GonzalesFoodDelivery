package kontrolerBL;

import Domen.KonstanteBL;
import Domen.TransferObject;
import servis.OpstaSistemskaOperacija;
import servis.ServisPrilogDELETE;
import servis.ServisPrilogGET;
import servis.ServisPrilogPOST;


public class KontrolerBLPrilozi implements CommandBase {

	@Override
	public void execute(TransferObject transferObject) {
		OpstaSistemskaOperacija op = null;
		if(transferObject.getKonstanteBl() == KonstanteBL.POST) {
			op = new ServisPrilogPOST();
	}else if(transferObject.getKonstanteBl() == KonstanteBL.GET) {
			op = new ServisPrilogGET();
	}else if(transferObject.getKonstanteBl() == KonstanteBL.DELETE) {
		    op = new ServisPrilogDELETE();
}
		op.izvrsiSistemskuOperaciju(transferObject);

}
}
