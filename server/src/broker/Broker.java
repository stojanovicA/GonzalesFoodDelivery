package broker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domen.Jelo;
import Domen.OpstiDomen;
import Domen.Racun;
import Domen.Restoran;
import Domen.Sqlexception;
import Domen.StavkeNaRacunu;
import Domen.User;
import Domen.VremeDostave;
import Domen.VrsteJela;
import konekcija.Konekcija;

public class Broker {
	
	public void insert(OpstiDomen opstiDomen) throws Sqlexception {
		String sql = "insert into " + opstiDomen.getNazivTabele() + " " +opstiDomen.getNazivKolona()+ " values "+opstiDomen.getVrednosti();
		try {
			PreparedStatement ps = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			opstiDomen.setujVrednostiInsert(ps);
			ps.execute();
		} catch (SQLException e) {
			throw new Sqlexception("greska prilikom unosa" + e);
		}
	}

	public User vratiUsera(User user) {
		String sqlUser = "select * from users where username = " + "'"+user.getUsername()+"'" + "and password = "+"'" +user.getPassword()+"'";
			User u = null ;
			try {
				PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sqlUser);
				
				
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					u = new User(resultSet.getString("email"),resultSet.getString("username"), resultSet.getString("password"), resultSet.getInt("status"));
					
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return u;
			
	}

	public List<OpstiDomen> selectAll(OpstiDomen opstiDomen) {
		String sql = "select * from " +opstiDomen.getNazivTabele();
		ResultSet resultSet = null;
		try {
			PreparedStatement ps = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			resultSet = ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return opstiDomen.selectAll(resultSet);
	}

	

	public void deleteJelo(int idJela) {
		String sql = "DELETE FROM `jela` WHERE id_jela = ' " +idJela + "'";
		try {
			PreparedStatement ps = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			ps.execute()	;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void update(OpstiDomen opstiDomen) {
		// TODO Auto-generated method stub
		String sql = "update "+opstiDomen.getNazivTabele()+ " SET " + opstiDomen.getUpdate()+ " where " + opstiDomen.getId() + " = ?";
		try {
			PreparedStatement ps = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			opstiDomen.setujVrednostiInsert(ps);
			opstiDomen.setujId(ps);
			ps.execute()	;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deletePrilog(int idPrilog) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM `prilozi` WHERE id_prilozi = ' " +idPrilog + "'";
		try {
			PreparedStatement ps = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			ps.execute()	;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public List<OpstiDomen> selectAllID(int idUser,OpstiDomen opstiDomen) {
		String sql = "select * from " +opstiDomen.getNazivTabele()+ "  where id_restoran = ' " +idUser + "'";
		ResultSet resultSet = null;
		try {
			PreparedStatement ps = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			resultSet = ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return opstiDomen.selectAll(resultSet);
	}
	
	public List<OpstiDomen> selectAllIDuser(String ime,OpstiDomen opstiDomen) {
		String sql = "select * from " +opstiDomen.getNazivTabele()+ "  where username = '"+ime+"'";
		ResultSet resultSet = null;
		try {
			PreparedStatement ps = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			resultSet = ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return opstiDomen.selectAll(resultSet);
	}

	public List<StavkeNaRacunu> VratiStavkeNaRacunu(int idRacun) {
		String sql = "SELECT * from jela INNER JOIN stavkajelo on jela.id_jela=stavkajelo.id_jela INNER JOIN racun ON stavkajelo.id_racun=racun.id_racun where racun.id_racun = "+idRacun ;
		ResultSet resultSet = null;
		List<StavkeNaRacunu>stavke = new ArrayList<StavkeNaRacunu>();
		try {
			PreparedStatement ps = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			resultSet = ps.executeQuery();
			while(resultSet.next()) {
				StavkeNaRacunu stavka = new StavkeNaRacunu(resultSet.getString("naziv"),resultSet.getString("Prilozi"), resultSet.getInt("cena"));
				stavke.add(stavka);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stavke;
		
	}

	public void UpdateRacunPrihvati(int idRacun) {
		String sql = "UPDATE `racun` SET `status_porudzbine`= 1 WHERE id_racun = "+idRacun;
		try {
			PreparedStatement ps =Konekcija.getInstanca().getConnection().prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void UpdateRacunReject(int idRacun) {
		String sql = "UPDATE `racun` SET `status_porudzbine`= 2 WHERE id_racun = "+idRacun;
		try {
			PreparedStatement ps = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Restoran getRestoran(User u) {
		String sql = "SELECT * FROM `restoran`  WHERE id_restoran = "+u.getStatus();   //
		Restoran r = null;
		
		try {
			PreparedStatement ps = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				r = new Restoran(resultSet.getString("ime_restorana"), resultSet.getString("adresa"), resultSet.getString("telefon"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return r;
	}
	/* String sqlUser = "select * from users where username = " + "'"+user.getUsername()+"'" + "and password = "+"'" +user.getPassword()+"'";
			User u = null ;
			try {
				PreparedStatement preparedStatement = Konekcija.getInstanca().getConnection().prepareStatement(sqlUser);
				
				
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					u = new User(resultSet.getString("username"), resultSet.getString("password"), resultSet.getInt("status"));
					
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return u; */

	public void updateUser(OpstiDomen opstiDomen) {
		String sql = "update "+opstiDomen.getNazivTabele()+ " SET " + opstiDomen.getUpdate()+ " where " + opstiDomen.getId() + " = ?";
		try {
			PreparedStatement ps = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			opstiDomen.setujVrednostiUpdate(ps);
			opstiDomen.setujId(ps);
			ps.execute()	;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//SELECT * FROM racun WHERE username = '"+u.getUsername()+"'" ORDER BY racun.id_racun DESC LIMIT 1
	public Racun getLast(User u) {
		String sql = "SELECT * FROM racun WHERE username = '"+u.getUsername()+"' ORDER BY racun.id_racun DESC LIMIT 1";
		PreparedStatement ps;
		
		Racun r = null;
		try {
			ps = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			
			while (resultSet.next()) {
				r = new Racun();
				r.setId_racun(resultSet.getInt("id_racun"));
				break;
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return  r;
	}

	public Racun getRacun(Racun r) {
		// TODO Auto-generated method stub
		Racun racun = null;
		String sql = "SELECT * FROM `racun`  WHERE id_racun = "+r.getId_racun(); 
		try {
			PreparedStatement ps = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				racun = new Racun(rs.getInt("id_racun"), rs.getInt("iznos"), rs.getString("username"), rs.getDate("datum").toLocalDate(), rs.getInt("id_restoran"), rs.getInt("status_porudzbine"), rs.getString("adresa_isporuka"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return racun;
	}

	public VremeDostave GetVreme(Racun r) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM `vremedostave` WHERE id_racun = "+r.getId_racun();
		VremeDostave vremeDostave = null;
		try {
			PreparedStatement ps = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				
				vremeDostave = new VremeDostave(resultSet.getString("poruka"), resultSet.getInt("id_racun"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vremeDostave;
	}

	public String getSlika(int idres) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM `restoran`  WHERE id_restoran = "+idres;   //
		String slika = null;
		
		try {
			PreparedStatement ps = Konekcija.getInstanca().getConnection().prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				slika = resultSet.getString("slika");
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return slika;
	}

	
	}
		

