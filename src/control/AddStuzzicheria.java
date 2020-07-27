package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StuzzicheriaBean;
import model.StuzzicheriaDAO;


/**
 * Servlet implementation class AddBirra
 */
@WebServlet("/AddStuzzicheria")
public class AddStuzzicheria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStuzzicheria() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StuzzicheriaBean stuzzicheria = new StuzzicheriaBean();
		stuzzicheria.setNome(request.getParameter("nome"));
		stuzzicheria.setDescrizione(request.getParameter("descrizione"));
		stuzzicheria.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
		stuzzicheria.setTipo(request.getParameter("tipo"));
		if (request.getParameter("nome").length() == 0)
			System.out.println("Il nome non può essere vuoto");
		if (request.getParameter("descrizione").length() == 0)
			System.out.println("La descrizione non può essere vuota");
		if (request.getParameter("prezzo").length() < 0)
			System.out.println("Il cognome non può essere vuoto");

		RequestDispatcher requestDispatcher = null;
		StuzzicheriaDAO uDao = new StuzzicheriaDAO();

		try {
			if (uDao.check(stuzzicheria.getNome())) {
				System.out.println("La stuzzicheria esiste gia.");
				requestDispatcher = request.getRequestDispatcher(response.encodeURL("admin.jsp"));
				requestDispatcher.forward(request, response);
			}

			else {
				uDao.doSave(stuzzicheria);
				request.getSession().setAttribute("stuzzicheria", stuzzicheria);
				request.getSession().setMaxInactiveInterval(60);
				requestDispatcher = request.getRequestDispatcher(response.encodeURL("admin.jsp"));
				requestDispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
