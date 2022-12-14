package Domen;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Jelo implements OpstiDomen {
	private int idJelo;
	private String naziv;
	private int cena;
	private String vrstaJela;
	private int idRestorana;
	
	
	public Jelo(int idJelo, String naziv, int cena, String vrstaJela) {
		super();
		this.idJelo = idJelo;
		this.naziv = naziv;
		this.cena = cena;
		this.vrstaJela = vrstaJela;
		
	}

	public int getIdJelo() {
		return idJelo;
	}
	public void setIdJelo(int idJelo) {
		this.idJelo = idJelo;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	public String getVrstaJela() {
		return vrstaJela;
	}
	public void setVrstaJela(String vrstaJela) {
		this.vrstaJela = vrstaJela;
	}
	public int getIdRestorana() {
		return idRestorana;
	}
	public void setIdRestorana(int idRestorana) {
		this.idRestorana = idRestorana;
	}
	public Jelo(int idJelo, String naziv, int cena, String vrstaJela, int idRestorana) {
		super();
		this.idJelo = idJelo;
		this.naziv = naziv;
		this.cena = cena;
		this.vrstaJela = vrstaJela;
		this.idRestorana = idRestorana;
	}
	@Override
	public String getNazivTabele() {
		// TODO Auto-generated method stub
		return " jela ";
	}
	@Override
	public String getNazivKolona() {
		// TODO Auto-generated method stub
		return "( `naziv`, `cena`, `Vrsta`, `id_restoran`)";
	}
	@Override
	public String getVrednosti() {
		// TODO Auto-generated method stub
		return " (?,?,?,?) " ;
	}
	@Override
	public void setujVrednostiInsert(PreparedStatement ps) {
		try {
			ps.setString(1, naziv);
			ps.setInt(2, cena);
			ps.setString(3, vrstaJela);
			ps.setInt(4, idRestorana);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Jelo() {
	
	}
	@Override
	public List<OpstiDomen> selectAll(ResultSet resultSet) {
		// TODO Auto-generated method stub
		
				List<OpstiDomen>jela = new ArrayList<OpstiDomen>();
				try {
					while(resultSet.next()) {
						Jelo jelo = new Jelo(resultSet.getInt("id_jela"), resultSet.getString("naziv"),resultSet.getInt("cena"),resultSet.getString("Vrsta"));
						jela.add(jelo);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return jela;
			}

	@Override                                    
	public String getUpdate() {
		// TODO Auto-generated method stub
		return " `naziv`= ? ,`cena`= ? ,`Vrsta`= ?,`id_restoran`= ?";
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return " id_jela ";
	}

	@Override
	public void setujId(PreparedStatement ps) {
			try {
				ps.setInt(5, idJelo);
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
