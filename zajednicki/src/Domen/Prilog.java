package Domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Prilog implements OpstiDomen {
	 private int idPrilog;
	 private String ime;
	 private int idRestoran;
	
	

	public Prilog(String ime, int idRestoran) {
		super();
		this.ime = ime;
		this.idRestoran = idRestoran;
	}
	
	
	
	
	
	

	public Prilog(int idPrilog, String ime) {
		super();
		this.idPrilog = idPrilog;
		this.ime = ime;
	}







	public Prilog() {
		// TODO Auto-generated constructor stub
	}







	public int getIdPrilog() {
		return idPrilog;
	}







	public void setIdPrilog(int idPrilog) {
		this.idPrilog = idPrilog;
	}







	public String getIme() {
		return ime;
	}



	public void setIme(String ime) {
		this.ime = ime;
	}



	public int getIdRestoran() {
		return idRestoran;
	}



	public void setIdRestoran(int idRestoran) {
		this.idRestoran = idRestoran;
	}



	@Override
	public String getNazivTabele() {
		// TODO Auto-generated method stub
		return " `prilozi` ";
	}

	@Override
	public String getNazivKolona() {
		// TODO Auto-generated method stub
		return "(`ime`, `id_restoran`)" ;
	}

	@Override
	public String getVrednosti() {
		// TODO Auto-generated method stub
		return "(?,?)" ;
	}

	@Override
	public void setujVrednostiInsert(PreparedStatement ps) {
		try {
			ps.setString(1, ime);
			ps.setInt(2, idRestoran);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<OpstiDomen> selectAll(ResultSet resultSet) {
	
		
		List<OpstiDomen>prilozi = new ArrayList<OpstiDomen>();
		
		
			try {
				while(resultSet.next()) {
				Prilog prilog = new Prilog(resultSet.getInt("id_prilozi"), resultSet.getString("ime"));
				prilozi.add(prilog);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return prilozi;
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
