package Domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class StavkeNaRacunu implements OpstiDomen {
	
	private String nazivJela;
	private String prilozi;
	private int cena;
	public String getNazivJela() {
		return nazivJela;
	}
	public void setNazivJela(String nazivJela) {
		this.nazivJela = nazivJela;
	}
	public String getPrilozi() {
		return prilozi;
	}
	public void setPrilozi(String prilozi) {
		this.prilozi = prilozi;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	public StavkeNaRacunu(String nazivJela, String prilozi, int cena) {
		super();
		this.nazivJela = nazivJela;
		this.prilozi = prilozi;
		this.cena = cena;
	}
	public StavkeNaRacunu() {
		super();
	}
	@Override
	public String getNazivTabele() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getNazivKolona() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getVrednosti() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setujVrednostiInsert(PreparedStatement ps) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<OpstiDomen> selectAll(ResultSet resultSet) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUpdate() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setujId(PreparedStatement ps) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setujVrednostiUpdate(PreparedStatement ps) {
		// TODO Auto-generated method stub
		
	}
	
	

}
