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

import model.PaninoBean;
import model.PaninoDAO;
import model.ProductBean;
import model.ProductDAO;

/**
 * Servlet implementation class Ricerca
 */
@WebServlet("/Ricerca")
public class Ricerca extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ricerca() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nomeprodotto = request.getParameter("cerca");
		ProductDAO pd = new ProductDAO();
		if(nomeprodotto!=null) {
			ArrayList<ProductBean> prodotti;
			try {
				prodotti = pd.getProductListByName(nomeprodotto);
				if(prodotti!=null) {
					request.setAttribute("prodotti", prodotti);
					request.setAttribute("cercato", true);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(response.encodeURL("menu.jsp"));
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
