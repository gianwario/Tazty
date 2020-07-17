package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BirraBean;
import model.BirraDAO;


/**
 * Servlet implementation class AddBirra
 */
@WebServlet("/AddBirra")
public class AddBirra extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddBirra() {
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
		BirraBean birra = new BirraBean();
		birra.setNome(request.getParameter("nome"));
		birra.setDescrizione(request.getParameter("descrizione"));
		birra.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
		birra.setGradi(Integer.parseInt(request.getParameter("gradi")));
		birra.setColore(request.getParameter("colore"));
		if (request.getParameter("nome").length() == 0)
			System.out.println("Il nome non può essere vuoto");
		if (request.getParameter("descrizione").length() == 0)
			System.out.println("La descrizione non può essere vuota");
		if (request.getParameter("prezzo").length() < 0)
			System.out.println("Il cognome non può essere vuoto");

		RequestDispatcher requestDispatcher = null;
		BirraDAO uDao = new BirraDAO();

		try {
			if (uDao.check(birra.getNome())) {
				System.out.println("Il panino esiste gia.");
				requestDispatcher = request.getRequestDispatcher("admin.jsp");
				requestDispatcher.forward(request, response);
			}

			else {
				uDao.doSave(birra);
				request.getSession().setAttribute("birra", birra);
				request.getSession().setMaxInactiveInterval(60);
				requestDispatcher = request.getRequestDispatcher("admin.jsp");
				requestDispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(birra);
		
	}

}
