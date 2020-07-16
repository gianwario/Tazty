package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaninoDAO {
	
	public ArrayList<PaninoBean> getPaniniList() throws SQLException{
		try {
			ConnectionPool cp = new ConnectionPool();
			java.sql.Connection con = cp.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from prodotto,panino where prodotto.cod_prodotto=panino.cod_prodotto;");
			ResultSet rs = ps.executeQuery();
			ArrayList<PaninoBean> list = new ArrayList<PaninoBean>();
			while(rs.next()) {
				PaninoBean pb = new PaninoBean();
				pb.setNome(rs.getString("nome"));
				pb.setDescrizione(rs.getString("descrizione"));
				pb.setTipo(rs.getString("tipo_pane"));
				pb.setPrezzo(Double.parseDouble(rs.getString("prezzo")));
				list.add(pb);
				
			}
			return list;
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;	
	}

	public void doSave(PaninoBean u) throws SQLException {
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
		PreparedStatement ps2 = con.prepareStatement("insert into panino(cod_prodotto,tipo_pane) values (?,?);");
		
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
