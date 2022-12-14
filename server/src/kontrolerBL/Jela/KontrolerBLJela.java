package kontrolerBL.Jela;

import Domen.KonstanteBL;
import Domen.TransferObject;
import kontrolerBL.CommandBase;
import servis.OpstaSistemskaOperacija;
import servis.ServisJeloObrisi;
import servis.ServisJeloUnesi;
import servis.ServisJeloUpdate;
import servis.ServisJeloVratiSve;

public class KontrolerBLJela implements CommandBase{

	@Override
	public void execute(TransferObject transferObject) {
		OpstaSistemskaOperacija op = null;
		if(transferObject.getKonstanteBl() == KonstanteBL.POST) {
			op = new ServisJeloUnesi();
		}else if(transferObject.getKonstanteBl() == KonstanteBL.GET) {
			op = new ServisJeloVratiSve();
		}else if(transferObject.getKonstanteBl() == KonstanteBL.DELETE) {
			op = new ServisJeloObrisi()	;
		}else if(transferObject.getKonstanteBl() == KonstanteBL.PUT) {
			op = new ServisJeloUpdate()	;
		}
			
		op.izvrsiSistemskuOperaciju(transferObject);
		
	}

}
