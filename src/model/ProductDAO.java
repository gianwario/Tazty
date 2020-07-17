package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {
	
	public ArrayList<ProductBean> getProductList() throws SQLException{
		try {
			ConnectionPool cp = new ConnectionPool();
			java.sql.Connection con = cp.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from prodotto;");
			ResultSet rs = ps.executeQuery();
			ArrayList<ProductBean> list = new ArrayList<ProductBean>();
			while(rs.next()) {
				ProductBean pb = new ProductBean();
				pb.setCod_prodotto(Integer.parseInt(rs.getString("cod_prodotto")));
				pb.setNome(rs.getString("nome"));
				pb.setDescrizione(rs.getString("descrizione"));
				pb.setPrezzo(Double.parseDouble(rs.getString("prezzo")));
				list.add(pb);
				
			}
			return list;
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;	
	}
	
	
	public ProductBean getByCodice(int codice){
		try {
			ConnectionPool cp = new ConnectionPool();
			java.sql.Connection con = cp.getConnection();
			PreparedStatement st = con.prepareStatement("select * from prodotto where cod_prodotto = ?;");
			st.setInt(1, codice);
			ResultSet rs = st.executeQuery();
			ProductBean prodotto = new ProductBean();
			if(rs.next()) {
				
				prodotto.setCod_prodotto(Integer.parseInt(rs.getString("cod_prodotto")));
				prodotto.setNome(rs.getString("nome"));
				prodotto.setDescrizione(rs.getString("descrizione"));
				prodotto.setPrezzo(Double.parseDouble(rs.getString("prezzo")));
				return prodotto;
			}
			else return null;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
