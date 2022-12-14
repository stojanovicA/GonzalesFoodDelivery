package Domen;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Racun implements OpstiDomen {
	private int id_racun;
	private int iznos;
	private String username;
	private LocalDate datum;
	private int id_restoran;
	private int status_porudzbine;
	private String adresaIsporuka;
	
	
	
	

	public Racun(int id_racun, int iznos, String username, LocalDate datum, int id_restoran, int status_porudzbine,String adresaIsporuka) {
		super();
		this.id_racun = id_racun;
		this.iznos = iznos;
		this.username = username;
		this.datum = datum;
		this.id_restoran = id_restoran;
		this.status_porudzbine = status_porudzbine;
		this.adresaIsporuka = adresaIsporuka;
	}
	
	
	
	

	public Racun(int iznos, String username, LocalDate datum, int id_restoran, int status_porudzbine,String adresaIsporuka) {
		super();
		this.iznos = iznos;
		this.username = username;
		this.datum = datum;
		this.id_restoran = id_restoran;
		this.status_porudzbine = status_porudzbine;
		this.adresaIsporuka = adresaIsporuka;
	}
	





	public int getId_racun() {
		return id_racun;
	}





	public void setId_racun(int id_racun) {
		this.id_racun = id_racun;
	}





	public String getAdresaIsporuka() {
		return adresaIsporuka;
	}





	public void setAdresaIsporuka(String adresaIsporuka) {
		this.adresaIsporuka = adresaIsporuka;
	}





	public Racun() {
		super();
	}



	public int getBroj_racuna() {
		return id_racun;
	}



	public void setBroj_racuna(int broj_racuna) {
		this.id_racun = broj_racuna;
	}



	public int getIznos() {
		return iznos;
	}



	public void setIznos(int iznos) {
		this.iznos = iznos;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public LocalDate getDatum() {
		return datum;
	}



	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}



	public int getId_restoran() {
		return id_restoran;
	}



	public void setId_restoran(int id_restoran) {
		this.id_restoran = id_restoran;
	}



	public int getStatus_porudzbine() {
		return status_porudzbine;
	}



	public void setStatus_porudzbine(int status_porudzbine) {
		this.status_porudzbine = status_porudzbine;
	}



	@Override
	public String getNazivTabele() {
		// TODO Auto-generated method stub
		return " racun ";
	}

	@Override
	public String getNazivKolona() {
		// TODO Auto-generated method stub
		return "( `iznos`, `username`, `datum`, `id_restoran`, `status_porudzbine`, `adresa_isporuka`)";
	}

	@Override
	public String getVrednosti() {
		// TODO Auto-generated method stub
		return " (?,?,?,?,?,?) " ;
	}

	@Override
	public void setujVrednostiInsert(PreparedStatement ps) {
		try {
			
			ps.setInt(1, iznos);
			ps.setString(2, username);
			ps.setDate(3, Date.valueOf(datum));
			ps.setInt(4, id_restoran);
			ps.setInt(5, status_porudzbine);
			ps.setString(6, adresaIsporuka);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//Racun racun = new Racun(resultSet.getInt("broj_racuna"), resultSet.getInt("iznos"), resultSet.getString("username"), resultSet.getDate("datum").toLocalDate(), resultSet.getInt("id_restoran"), resultSet.getInt("status_porudzbine"));
	@Override
	public List<OpstiDomen> selectAll(ResultSet resultSet) {
		// TODO Auto-generated method stub
		
				List<OpstiDomen>racuni = new ArrayList<OpstiDomen>();
				try {
					while(resultSet.next()) {
						Racun racun = new Racun(resultSet.getInt("id_racun"), resultSet.getInt("iznos"), resultSet.getString("username"), resultSet.getDate("datum").toLocalDate(), resultSet.getInt("id_restoran"), resultSet.getInt("status_porudzbine"), resultSet.getString("adresa_isporuka"));
						racuni.add(racun);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return racuni;
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
