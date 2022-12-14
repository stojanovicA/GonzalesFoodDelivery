package Domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Restoran implements OpstiDomen {
      private String ime_restorana;
      private String adresa;
      private String telefon;
      private int idRestoran;
      
      
	
      public int getIdRestoran() {
		return idRestoran;
	}
	public void setIdRestoran(int idRestoran) {
		this.idRestoran = idRestoran;
	}
	public Restoran(String ime_restorana, String adresa, String telefon, int idRestoran) {
		super();
		this.ime_restorana = ime_restorana;
		this.adresa = adresa;
		this.telefon = telefon;
		this.idRestoran = idRestoran;
	}
	public Restoran(String ime_restorana, String adresa, String telefon) {
		super();
		this.ime_restorana = ime_restorana;
		this.adresa = adresa;
		this.telefon = telefon;
	}
	public Restoran() {
		
	}
	public String getIme_restorana() {
		return ime_restorana;
	}
	public void setIme_restorana(String ime_restorana) {
		this.ime_restorana = ime_restorana;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	@Override
	public String getNazivTabele() {
		// TODO Auto-generated method stub
		return " restoran ";
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
		try {
			ps.setString(1, ime_restorana);
			ps.setString(2, adresa);
			ps.setString(3, telefon);
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
		return " `ime_restorana`= ? ,`adresa`= ? ,`telefon`= ?";
	}
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return " id_restoran ";
	}
	@Override
	public void setujId(PreparedStatement ps) {
		// TODO Auto-generated method stub
		try {
			ps.setInt(4, idRestoran);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void setujVrednostiUpdate(PreparedStatement ps) {
		// TODO Auto-generated method stub
		
	}
      
      
}
