package Domen;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VrsteJela implements OpstiDomen {
	private String Vrsta;

	public VrsteJela(String vrsta) {
		super();
		Vrsta = vrsta;
	}

	public VrsteJela() {
		super();
	}

	public String getVrsta() {
		return Vrsta;
	}

	public void setVrsta(String vrsta) {
		Vrsta = vrsta;
	}

	@Override
	public String getNazivTabele() {
		// TODO Auto-generated method stub
		return " vrstajela ";
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
		
		List<OpstiDomen>vrste = new ArrayList<OpstiDomen>();
		try {
			while(resultSet.next()) {
				VrsteJela vrsteJela = new VrsteJela(resultSet.getString("Vrsta"));
				vrste.add(vrsteJela);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vrste;
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
