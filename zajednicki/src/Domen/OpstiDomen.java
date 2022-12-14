package Domen;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public interface OpstiDomen extends Serializable{

	String getNazivTabele();

	String getNazivKolona();

	String getVrednosti();

	void setujVrednostiInsert(PreparedStatement ps);

	public List<OpstiDomen> selectAll(ResultSet resultSet);

	String getUpdate();

	String getId();

	void setujId(PreparedStatement ps);
	
	void setujVrednostiUpdate(PreparedStatement ps);

	

}
