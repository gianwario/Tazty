package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	
	public UserBean getUserByUsernameAndPassword (String u, String p) throws SQLException{
		try {
			ConnectionPool cp = new ConnectionPool();
			java.sql.Connection con = cp.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from utente where username=? and passw=?;");
			ps.setString(1, u);
			ps.setString(2, p);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				UserBean ub = new UserBean();
				ub.setUsername(rs.getString("username"));
				ub.setNome(rs.getString("nome"));
				ub.setCognome(rs.getString("cognome"));
				ub.setEmail(rs.getString("email"));
				ub.setIndirizzo(rs.getString("indirizzo"));
				ub.setCellulare(rs.getString("cellulare"));
				ub.setIsadmin(rs.getInt("isAdmin"));
				System.out.println(ub);
				return ub;
			}
			return null;
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;	
	}
	
	public void doSave(UserBean u) throws SQLException {
		ConnectionPool cp = new ConnectionPool();
		java.sql.Connection con=null;
		try {
			con = cp.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement ps = con.prepareStatement("insert into utente(username,nome,cognome,passw,email,indirizzo,cellulare,isAdmin) values (?,?,?,?,?,?,?,?);");
		ps.setString(1, u.getUsername());
		ps.setString(2, u.getNome());
		ps.setString(3, u.getCognome());
		ps.setString(4, u.getPassword());
		ps.setString(5, u.getEmail());
		ps.setString(6, u.getIndirizzo());
		ps.setString(7, u.getCellulare());
		ps.setInt(8,0);//ISADMIN
		ps.execute();
	}
	/*
	public boolean exists(UtenteBean u) throws SQLException {
		Connection con = null;
		con = ConPool.getConnection();
		PreparedStatement ps = con.prepareStatement("select email from utente where utente = ?;");
		ps.setString(1, u.getUsername());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) return true;
		return false;
	}*/
	
	public boolean check(String username) throws SQLException {
		ConnectionPool cp = new ConnectionPool();
		java.sql.Connection con=null;
		try {
			con = cp.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement ps = con.prepareStatement("select username from utente where username = ?; ");
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) return true;
		return false;
	}
	

}
