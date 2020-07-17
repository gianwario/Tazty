package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PaninoBean;
import model.PaninoDAO;

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
		PaninoDAO pd = new PaninoDAO();
		if(nomeprodotto!=null) {
			ArrayList<PaninoBean> prodotti = pd.getPaniniByName(nomeprodotto);
			if(prodotti!=null) {
				request.setAttribute("prodotti", prodotti);
				request.setAttribute("cercato", true);
			}
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("menu.jsp");
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
