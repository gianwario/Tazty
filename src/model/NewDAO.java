package model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.sql.rowset.serial.SerialBlob;

public class NewDAO {
	
	public ArrayList<NewBean> getLatestNews(){
		ArrayList<NewBean> news = new ArrayList<NewBean>();
		
		try {
			ConnectionPool cp = new ConnectionPool();
			java.sql.Connection con = cp.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from notizia order by data_ora desc;");
			ResultSet rs = ps.executeQuery();
			
			int cont = 0;
			while(rs.next() && cont < 4) {
				NewBean tmp = new NewBean();
				tmp.setId(Integer.parseInt(rs.getString("cod_notizia")));
				tmp.setTitolo(rs.getString("titolo"));
				tmp.setCorpo(rs.getString("corpo"));
				tmp.setDataora(rs.getString("data_ora"));
				tmp.setUsername(rs.getString("username"));
				Blob blob = rs.getBlob("foto");
				
				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;
				 
				try {
					while ((bytesRead = inputStream.read(buffer)) != -1) {
					    outputStream.write(buffer, 0, bytesRead);
					}
					
				byte[] imageBytes = outputStream.toByteArray();				 
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);
				 
				inputStream.close();
				outputStream.close();
				
				tmp.setImage(base64Image);
				} catch (IOException e) { e.printStackTrace(); }
				
				news.add(tmp);
				cont++;
			}			
			return news;

		} catch (SQLException e) { e.printStackTrace(); }		
		return null;		
	}
	
	public void doSave(NewBean news) throws SQLException {
		ConnectionPool cp = new ConnectionPool();
		java.sql.Connection con=null;
		try {
			con = cp.getConnection();
		} catch (SQLException e) { e.printStackTrace(); }
		
		PreparedStatement ps = con.prepareStatement("INSERT INTO notizia(titolo, corpo, data_ora, username, foto) VALUES (?, ?, ?, ?, ?)");
		
		java.util.Date date = new Date();
		Object param = new java.sql.Timestamp(date.getTime());
		// The JDBC driver knows what to do with a java.sql type:
		ps.setObject(3,param); 	
		
		ps.setString(1, news.getTitolo());
		ps.setString(2, news.getCorpo());		
		ps.setString(4, news.getUsername());
		String str = news.getImage();
		byte[] decodedByte = Base64.getDecoder().decode(str);
		Blob b = new SerialBlob(decodedByte);
		ps.setBlob(5, b);
		ps.execute();
	}
}
