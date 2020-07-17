package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StuzzicheriaDAO {
	
	public ArrayList<StuzzicheriaBean> getStuzzicherieList() throws SQLException{
		try {
			ConnectionPool cp = new ConnectionPool();
			java.sql.Connection con = cp.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from prodotto,stuzzicheria where prodotto.cod_prodotto=stuzzicheria.cod_prodotto;");
			ResultSet rs = ps.executeQuery();
			ArrayList<StuzzicheriaBean> list = new ArrayList<StuzzicheriaBean>();
			while(rs.next()) {
				StuzzicheriaBean sb = new StuzzicheriaBean();
				sb.setCod_prodotto(Integer.parseInt(rs.getString("cod_prodotto")));

				sb.setNome(rs.getString("nome"));
				sb.setDescrizione(rs.getString("descrizione"));
				sb.setTipo(rs.getString("tipo"));
				sb.setPrezzo(Double.parseDouble(rs.getString("prezzo")));
				list.add(sb);
			}
			return list;
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;	
	}
	
	public void doSave(StuzzicheriaBean u) throws SQLException {
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
		PreparedStatement ps2 = con.prepareStatement("insert into stuzzicheria(cod_prodotto,tipo) values (?,?);");
		
		ps.setString(1, u.getNome());
		ps.setString(2, u.getDescrizione());
		ps.setDouble(3, u.getPrezzo());
		ps.execute();
		
		select.setString(1, u.getNome());
		ResultSet rs = select.executeQuery();
		if(rs.next())
			ps2.setInt(1,rs.getInt("cod_prodotto"));
		ps2.setString(2, u.getTipo());
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
