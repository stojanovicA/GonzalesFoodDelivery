package Domen;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class User implements OpstiDomen {
	private String prezimeIme;
	private LocalDate datumRodjenja;
	private String email;
	private String username;
	private String password;
	private int status;
	private int id_app;
	
	
	
	
	
	public User(String username, String password, int status) {
		super();
		this.username = username;
		this.password = password;
		this.status = status;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User(String username, String password,String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	
	public User(String email, String username, String password, int status) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.status = status;
	}
	public String getPrezimeIme() {
		return prezimeIme;
	}
	public void setPrezimeIme(String prezimeIme) {
		this.prezimeIme = prezimeIme;
	}
	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(LocalDate datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getId_app() {
		return id_app;
	}
	public void setId_app(int id_app) {
		this.id_app = id_app;
	}
	public User(String prezimeIme, LocalDate datumRodjenja, String email, String username, String password, int status,
			int id_app) {
		super();
		this.prezimeIme = prezimeIme;
		this.datumRodjenja = datumRodjenja;
		this.email = email;
		this.username = username;
		this.password = password;
		this.status = status;
		this.id_app = id_app;
	}
	public User() {
		super();
	}
	@Override
	public String getNazivTabele() {
		// TODO Auto-generated method stub
		return " users ";
	}
	@Override
	public String getNazivKolona() {
		// TODO Auto-generated method stub
		return "(`username`, `password`, `prezime_ime`, `status`, `datum`, `email`, `id_app`)";
	}
	@Override
	public String getVrednosti() {
		// TODO Auto-generated method stub
		return " (?,?,?,?,?,?,?) ";
	}
	@Override
	public void setujVrednostiInsert(PreparedStatement ps) {
		try {
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, prezimeIme);
			ps.setInt(4, status);
			ps.setDate(5, Date.valueOf(datumRodjenja));
			ps.setString(6, email);
     		ps.setInt(7, id_app);
     		
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
		return " `password`= ? ,`email`= ?";
	}
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return " username ";
	}
	@Override
	public void setujId(PreparedStatement ps) {
		// TODO Auto-generated method stub
		try {
			ps.setString(3, username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void setujVrednostiUpdate(PreparedStatement ps) {
		// TODO Auto-generated method stub
		
		try {
			ps.setString(1, password);
			ps.setString(2, email);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	

}
