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
import model.IngredientDAO;
import model.IngredientBean;

/**
 * Servlet implementation class Composition
 */
@WebServlet("/Composition")
public class Composition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Composition() {
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
		IngredientDAO id = new IngredientDAO();
		RequestDispatcher requestDispatcher = null;
		try {
			ArrayList<IngredientBean> listpane = id.getIngredientsByType("pane");
			ArrayList<IngredientBean> listcarne = id.getIngredientsByType("carne");
			ArrayList<IngredientBean> listcondimento = id.getIngredientsByType("condimento");
			ArrayList<IngredientBean> listsalsa = id.getIngredientsByType("salsa");
			
			System.out.println(listpane + "\n" + listcarne + "\n" + listcondimento + "\n" + listsalsa + "\n");
			request.setAttribute("pane", listpane);
			request.setAttribute("carne", listcarne);
			request.setAttribute("condimento", listcondimento);
			request.setAttribute("salsa", listsalsa);
			requestDispatcher = request.getRequestDispatcher(response.encodeURL("composition.jsp"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		requestDispatcher.forward(request, response);		
		
	}

}
