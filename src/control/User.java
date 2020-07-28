package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OrdineBean;
import model.OrdineDAO;
import model.ProductBean;
import model.RelativoADAO;


/**
 * Servlet implementation class Menu
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrdineDAO pd = new OrdineDAO();
		RelativoADAO rdao = new RelativoADAO();
		ArrayList<ProductBean> list = new ArrayList<ProductBean>();
		
		RequestDispatcher requestDispatcher = null;
		String username = request.getParameter("username");
		try {
			ArrayList<OrdineBean> pb = pd.getOrdineList(username);
			
			for(OrdineBean o : pb) {				
				list = rdao.getProdottibyCodOrdine(o.getCod_ordine());
				o.setProductList(list);
			}
			
			request.setAttribute("ordini", pb);
			requestDispatcher = request.getRequestDispatcher(response.encodeURL("user.jsp"));
			requestDispatcher.forward(request, response);	
		} 
		catch (SQLException e) { e.printStackTrace(); }
		
			

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
