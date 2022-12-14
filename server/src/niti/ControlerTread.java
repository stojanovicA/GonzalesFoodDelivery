package niti;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ControlerTread {
	
	private volatile static ControlerTread instanca;
	private List<KlijentTread> listaKlijenata = new CopyOnWriteArrayList<>();
	private ControlerTread() {
		
	}
		
	public static ControlerTread getInstanca() {
		if( instanca == null) {
			synchronized (ControlerTread.class) {
				if(instanca == null) {
					instanca = new ControlerTread();
				}
				
			}
		}
		return instanca;
	}
	public void addClient(KlijentTread klijentTread) {
		listaKlijenata.add(klijentTread);
	}

	public List<KlijentTread> getListaKlijenata() {
		return listaKlijenata;
	}

	
	
}
