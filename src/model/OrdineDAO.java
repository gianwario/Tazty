package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class OrdineDAO {

	public ArrayList<OrdineBean> getOrdineList(String username) throws SQLException {
		try {
			ConnectionPool cp = new ConnectionPool();
			java.sql.Connection con = cp.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from ordine where ordine.username = ?;");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			ArrayList<OrdineBean> list = new ArrayList<OrdineBean>();
			ProductBean pb = new ProductBean();
			while (rs.next()) {
				OrdineBean ob = new OrdineBean();
				ob.setCod_ordine(Integer.parseInt(rs.getString("cod_ordine")));
				ob.setTotale(Double.parseDouble(rs.getString("totale")));
				ob.setData_ora(rs.getString("data_ora"));
				ob.setPagamento(rs.getString("pagamento"));

				list.add(ob);
			}
			for (OrdineBean o : list) {
				PreparedStatement ps2 = con.prepareStatement(
						"select * from prodotto,relativoa where prodotto.cod_prodotto=relativoa.cod_prodotto AND relativoa.cod_ordine = ?");
				ps2.setInt(1, o.getCod_ordine());
				ResultSet rs2 = ps2.executeQuery();
				while (rs2.next()) {
					pb.setCod_prodotto(Integer.parseInt(rs2.getString("cod_prodotto")));
					pb.setNome(rs2.getString("nome"));
					pb.setPrezzo(Double.parseDouble(rs2.getString("prezzo")));
					o.addProduct(pb);
				}
			}
			return list;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public void doSave(OrdineBean ordine) throws SQLException{
		
		ConnectionPool cp = new ConnectionPool();
		java.sql.Connection con=null;
		try {
			con = cp.getConnection();
		} catch (SQLException e) { e.printStackTrace(); }
		
		PreparedStatement ps = con.prepareStatement("INSERT INTO ordine(totale, data_ora, pagamento, username) \r\n" + 
				"VALUES (\r\n" + "	?, ?, ?, ?\r\n" + ");");
		java.util.Date date = new Date();
		Object param = new java.sql.Timestamp(date.getTime());		
		
		ps.setDouble(1, ordine.getTotale());
		ps.setObject(2, param);
		ps.setString(3, ordine.getPagamento());
		ps.setString(4, ordine.getUsername());
		
		ps.execute();
		
	}
	
	public int getLastOrder() throws SQLException {
		int count = 0;
		ConnectionPool cp = new ConnectionPool();
		java.sql.Connection con=null;
		try {
			con = cp.getConnection();
		} catch (SQLException e) { e.printStackTrace(); }
		
		String query = "SELECT cod_ordine FROM ordine\r\n" + "ORDER BY cod_ordine DESC;";
		Statement stmt3 = con.createStatement();
		ResultSet rs3 = stmt3.executeQuery(query);
		if(rs3.next()){
		    count = rs3.getInt(1);
		    }
		return count;
		
	}

}
