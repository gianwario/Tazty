package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RelativoADAO {
	
	public void doSave(RelativoABean bean) throws SQLException{
		
		ConnectionPool cp = new ConnectionPool();
		java.sql.Connection con=null;
		try {
			con = cp.getConnection();
		} catch (SQLException e) { e.printStackTrace(); }
		
		String query = "INSERT INTO relativoa(cod_prodotto, cod_ordine, quantita) \r\n" + 
				"VALUES (\r\n" + "?, ?, 1\r\n" + ");";
		PreparedStatement ps = con.prepareStatement(query);
		
		ps.setInt(1, bean.getCod_prodotto());
		ps.setInt(2, bean.getCod_ordine());
		
		ps.execute();		
	}
	
	public ArrayList<ProductBean> getProdottibyCodOrdine(int cod_ordine) throws SQLException{
		
		ArrayList<ProductBean> list = new ArrayList<ProductBean>();
		ConnectionPool cp = new ConnectionPool();
		java.sql.Connection con=null;
		try {
			con = cp.getConnection();
		} catch (SQLException e) { e.printStackTrace(); }
		
		String query = "SELECT prodotto.nome, prodotto.prezzo\r\n" + 
				"FROM relativoa, prodotto, ordine\r\n" + 
				"WHERE relativoa.cod_prodotto = prodotto.cod_prodotto AND ordine.cod_ordine=relativoa.cod_ordine AND relativoa.cod_ordine = ?;";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, cod_ordine);	
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			ProductBean b = new ProductBean();
			b.setNome(rs.getString("prodotto.nome"));
			b.setPrezzo(rs.getDouble("prodotto.prezzo"));
			list.add(b);
		}

		return list;
	}
}
