package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NewDAO {
	
	public ArrayList<NewBean> getLatestNews(){
		ArrayList<NewBean> news = new ArrayList<NewBean>();
		
		try {
			ConnectionPool cp = new ConnectionPool();
			java.sql.Connection con = cp.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from notizia order by data_ora;");
			ResultSet rs = ps.executeQuery();
			int cont = 0;
			while(rs.next() && cont < 4) {
				NewBean tmp = new NewBean();
				tmp.setId(Integer.parseInt(rs.getString("cod_notizia")));
				tmp.setTitolo(rs.getString("titolo"));
				tmp.setCorpo(rs.getString("corpo"));
				tmp.setDataora(rs.getString("data_ora"));
				tmp.setUsername(rs.getString("username"));
				news.add(tmp);
				cont++;
			}
			
			return news;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

}
