package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import model.PaninoBean;
import model.PaninoDAO;
import model.ProductBean;
import model.ProductDAO;

/**
 * Servlet implementation class RicercaAJAX
 */
@WebServlet("/RicercaAJAX")
public class RicercaAJAX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RicercaAJAX() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONArray prodJson = new JSONArray();
		String query = request.getParameter("q");

		if (query != null) {
			ArrayList<ProductBean> prodotti;
			try {
				prodotti = new ProductDAO().getProductListByName(query);
				for (ProductBean prodotto : prodotti) {
					prodJson.put(prodotto.getNome());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		response.setContentType("application/json");
		response.getWriter().append(prodJson.toString());
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
