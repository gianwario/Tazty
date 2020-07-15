package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BirraDAO {
	
	/*public UserBean getPaninoByName (String u, String p) throws SQLException{
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
	*/
	public void doSave(BirraBean u) throws SQLException {
		ConnectionPool cp = new ConnectionPool();
		java.sql.Connection con=null;
		try {
			con = cp.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement ps = con.prepareStatement("insert into prodotto(nome,descrizione,prezzo) values (?,?,?);");
		PreparedStatement select = con.prepareStatement("select cod_prodotto from prodotto where nome=?;");
		PreparedStatement ps2 = con.prepareStatement("insert into birra(cod_prodotto,gradi,colore) values (?,?,?);");
		
		ps.setString(1, u.getNome());
		ps.setString(2, u.getDescrizione());
		ps.setDouble(3, u.getPrezzo());
		ps.execute();
		
		select.setString(1, u.getNome());
		ResultSet rs = select.executeQuery();
		if(rs.next())
			ps2.setInt(1,rs.getInt("cod_prodotto"));
		ps2.setInt(2, u.getGradi());
		ps2.setString(3, u.getColore());
		ps2.execute();
	}

	public boolean check(String nome) throws SQLException {
		ConnectionPool cp = new ConnectionPool();
		java.sql.Connection con=null;
		try {
			con = cp.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement ps = con.prepareStatement("select nome from prodotto where nome = ?; ");
		ps.setString(1, nome);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) return true;
		return false;
	}
	

}
