package konekcija;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Konekcija {
	private Connection connection;
	private volatile static Konekcija konekcija;
	private Konekcija() {
		
	}
	public Connection getConnection() {
		return connection;
	}
	public static Konekcija getInstanca() { 
		if(konekcija == null) {
			synchronized (Konekcija.class) {
				if(konekcija == null) {
					konekcija = new Konekcija();
				}
				
			}
			
		}
		return konekcija;
	}
	public void zatvrotiKonekciju() {
		// TODO Auto-generated method stub
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void ponistiTransakciju() {
		// TODO Auto-generated method stub
		try {
			connection.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void potvrdiTransakciju() {
		// TODO Auto-generated method stub
		try {
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

	public void pokreniTransakciju() {
		// TODO Auto-generated method stub
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zavrsni", "root","");
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


}
