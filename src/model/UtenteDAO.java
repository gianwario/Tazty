package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtenteDAO {
	
	public UtenteBean doRetrieveByUsernamePassword(String u,String p) throws SQLException {
		Connection c = ConnectionPool.getConnection();
		PreparedStatement ps = c.prepareStatement("select idUtente,email,password,nome,amministratore from utente where email=? and password=?");
		ps.setString(1, u);
		ps.setString(2, p);
		ResultSet s = ps.executeQuery();
		if(s.next()) {
			UtenteBean utente = new UtenteBean();
			utente.setAmministratore(s.getInt("amministratore"));
			utente.setIdUtente(s.getInt("idUtente"));
			utente.setName(s.getString("nome"));
			utente.setUsername(s.getString("email"));
			utente.setPassword(s.getString("password"));
			
			return utente;
		}
		return null;
	}
	public void doSave(UtenteBean u) throws SQLException {
		Connection con = null;
		try {
			con = ConnectionPool.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement ps = con.prepareStatement("insert into utente(email,password,nome,amministratore) values (?,?,?,?);");
		ps.setString(1, u.getUsername());
		ps.setString(2, u.getPassword());
		ps.setString(3, u.getName());
		ps.setInt(4, 2);
		ps.execute();
	}
	
	public boolean exists(UtenteBean u) throws SQLException {
		Connection con = null;
		con = ConPool.getConnection();
		PreparedStatement ps = con.prepareStatement("select email from utente where utente = ?;");
		ps.setString(1, u.getUsername());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) return true;
		return false;
	}
	
	public boolean check(String username) throws SQLException {
		Connection con = null;
		try {
			con = ConPool.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement ps = con.prepareStatement("select idUtente from utente where email = ?; ");
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) return true;
		return false;
	}
}
