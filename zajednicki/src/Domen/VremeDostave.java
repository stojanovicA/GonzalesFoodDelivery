package Domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class VremeDostave implements OpstiDomen{
	private String poruka;
	private int id_racun;
	public VremeDostave(String poruka, int id_racun) {
		super();
		this.poruka = poruka;
		this.id_racun = id_racun;
	}
	public VremeDostave() {
		super();
	}
	public String getPoruka() {
		return poruka;
	}
	public void setPoruka(String poruka) {
		this.poruka = poruka;
	}
	public int getId_racun() {
		return id_racun;
	}
	public void setId_racun(int id_racun) {
		this.id_racun = id_racun;
	}
	@Override
	public String getNazivTabele() {
		// TODO Auto-generated method stub
		return " vremedostave ";
	}
	@Override
	public String getNazivKolona() {
		// TODO Auto-generated method stub
		return "(`poruka`, `id_racun`)";
	}
	@Override
	public String getVrednosti() {
		// TODO Auto-generated method stub
		return " (?,?) " ;
	}
	@Override
	public void setujVrednostiInsert(PreparedStatement ps) {
		try {
			ps.setString(1, poruka);
			ps.setInt(2, id_racun);
			
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
	
	

}
