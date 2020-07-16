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

import model.BirraBean;
import model.BirraDAO;
import model.IngredientBean;
import model.IngredientDAO;
import model.PaninoBean;
import model.PaninoDAO;
import model.StuzzicheriaBean;
import model.StuzzicheriaDAO;

/**
 * Servlet implementation class Menu
 */
@WebServlet("/Menu")
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Menu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PaninoDAO pd = new PaninoDAO();
		StuzzicheriaDAO sd = new StuzzicheriaDAO();
		BirraDAO bd = new BirraDAO();
		RequestDispatcher requestDispatcher = null;

		try {
			ArrayList<PaninoBean> pb = pd.getPaniniList();
			ArrayList<StuzzicheriaBean> sb = sd.getStuzzicherieList();
			ArrayList<BirraBean> bb = bd.getBirreList();
			
			request.setAttribute("panini", pb);
			request.setAttribute("stuzzicherie", sb);
			request.setAttribute("birre", bb);
			
			requestDispatcher = request.getRequestDispatcher("menu.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		requestDispatcher.forward(request, response);		

	}

}
