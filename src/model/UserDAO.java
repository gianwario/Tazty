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

}
