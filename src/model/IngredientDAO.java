package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IngredientDAO {
	
	public ArrayList<IngredientBean> getIngredientsByType(String tipo) throws SQLException{
		
		String query = "SELECT * FROM ingrediente WHERE tipologia=?;";	
		ArrayList<IngredientBean> list = new ArrayList<IngredientBean>();
		try{			
			ConnectionPool cp = new ConnectionPool();
			java.sql.Connection con = cp.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, tipo);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				IngredientBean ing = new IngredientBean();
				ing.setCodice(rs.getInt("cod_ingrediente"));
				ing.setNome(rs.getString("nome"));
				ing.setTipo(rs.getString("tipologia"));
				ing.setPrezzo(rs.getDouble("prezzo"));
				System.out.println(ing);
				list.add(ing);
			}			
		}		
		catch(Exception e) {}
		return list;
	}
	
	public IngredientBean getIngredientByName(String nome) throws SQLException{
		
		String query = "SELECT * FROM ingrediente WHERE nome=?;";	
		try{			
			ConnectionPool cp = new ConnectionPool();
			java.sql.Connection con = cp.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				IngredientBean ing = new IngredientBean();
				ing.setCodice(rs.getInt("cod_ingrediente"));
				ing.setNome(rs.getString("nome"));
				ing.setTipo(rs.getString("tipologia"));
				ing.setPrezzo(rs.getDouble("prezzo"));
				System.out.println(ing);
				return ing;
			}			
		}		
		catch(Exception e) {}
		return null;
	}
	

}
