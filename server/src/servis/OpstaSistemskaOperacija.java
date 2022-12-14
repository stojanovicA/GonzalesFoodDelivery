package servis;

import Domen.TransferObject;
import konekcija.Konekcija;

public abstract class OpstaSistemskaOperacija {
	public void izvrsiSistemskuOperaciju(TransferObject transferObject) {
		try {
		pokreniTransakciju();
		izvrsiKonkretnuSistemskuOperacija(transferObject);
		potvrdiTransakciju();
		}catch (Exception e) {
			e.printStackTrace();
			ponistiTransakciju();
		}finally {
			zatvrotiKonekciju();
		}
		
	}

	public void zatvrotiKonekciju() {
		// TODO Auto-generated method stub
		Konekcija.getInstanca().zatvrotiKonekciju();
		
	}

	public void ponistiTransakciju() {
		// TODO Auto-generated method stub
		Konekcija.getInstanca().ponistiTransakciju();
		
	}

	public void potvrdiTransakciju() {
		// TODO Auto-generated method stub
		Konekcija.getInstanca().potvrdiTransakciju();
		
	}

	public abstract void izvrsiKonkretnuSistemskuOperacija(TransferObject transferObject);

	public void pokreniTransakciju() {
		// TODO Auto-generated method stub
		Konekcija.getInstanca().pokreniTransakciju();
		
	}

}
