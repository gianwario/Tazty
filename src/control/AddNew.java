package control;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import model.NewBean;
import model.NewDAO;

/**
 * Servlet implementation class AddNew
 */
@WebServlet("/AddNew")
@MultipartConfig(maxFileSize = 16177215) 
public class AddNew extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNew() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NewBean news = new NewBean();
		NewDAO dao = new NewDAO(); 
		InputStream inputStream = null;
		Part filePart = request.getPart("foto");
		if(filePart != null) 
			inputStream = filePart.getInputStream();
		else System.out.println("FILEPART vuoto");
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
		
		news.setImage(base64Image);
		} catch (IOException e) { e.printStackTrace(); }
		
		news.setTitolo(request.getParameter("titolo"));
		news.setCorpo(request.getParameter("corpo"));
		news.setUsername(request.getParameter("username"));
		
		try {
			dao.doSave(news);
			RequestDispatcher rd = request.getRequestDispatcher(response.encodeURL("admin.jsp"));
			rd.forward(request, response);
		} catch (SQLException e) { e.printStackTrace(); }
	}

}
