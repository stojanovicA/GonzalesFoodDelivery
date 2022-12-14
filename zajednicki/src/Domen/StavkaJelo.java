package Domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StavkaJelo implements OpstiDomen{
	private int idJela;
	private String prilozi;
	private int idRacun;
	private String naziv;
	private int cena;
	
	public StavkaJelo(int idJela, String prilozi, int idRacun, String naziv,int cena) {
		super();
		this.idJela = idJela;
		this.prilozi = prilozi;
		this.idRacun = idRacun;
		this.naziv = naziv;
		this.cena = cena;
	}
	public StavkaJelo(int idJela, String prilozi, int idRacun) {
		super();
		this.idJela = idJela;
		this.prilozi = prilozi;
		this.idRacun = idRacun;
	}
	public StavkaJelo() {
		super();
	}
	public int getIdJela() {
		return idJela;
	}
	public void setIdJela(int idJela) {
		this.idJela = idJela;
	}
	public String getPrilozi() {
		return prilozi;
	}
	public void setPrilozi(String prilozi) {
		this.prilozi = prilozi;
	}
	public int getIdRacun() {
		return idRacun;
	}
	public void setIdRacun(int idRacun) {
		this.idRacun = idRacun;
	}
	
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	@Override
	public String getNazivTabele() {
		// TODO Auto-generated method stub
		return " stavkajelo ";
	}
	@Override
	public String getNazivKolona() {
		// TODO Auto-generated method stub
		return "( `id_jela`, `Prilozi`, `id_racun`)";
	}
	@Override
	public String getVrednosti() {
		// TODO Auto-generated method stub
		return " (?,?,?) ";
	}
	@Override
	public void setujVrednostiInsert(PreparedStatement ps) {
		// TODO Auto-generated method stub
		try {
			ps.setInt(1, idJela);
			ps.setString(2, prilozi);
			ps.setInt(3, idRacun);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	

}
