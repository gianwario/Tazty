package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.PaninoBean;
import model.PaninoDAO;

/**
 * Servlet implementation class AddPanino
 */
@WebServlet("/AddPanino")
public class AddPanino extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPanino() {
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
		PaninoBean panino = new PaninoBean();
		panino.setNome(request.getParameter("nome"));
		panino.setDescrizione(request.getParameter("descrizione"));
		panino.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
		panino.setTipo(request.getParameter("tipo_pane"));
		if (request.getParameter("nome").length() == 0)
			System.out.println("Il nome non può essere vuoto");
		if (request.getParameter("descrizione").length() == 0)
			System.out.println("La descrizione non può essere vuota");
		if (request.getParameter("prezzo").length() < 0)
			System.out.println("Il cognome non può essere vuoto");

		RequestDispatcher requestDispatcher = null;
		PaninoDAO uDao = new PaninoDAO();

		try {
			if (uDao.check(panino.getNome())) {
				System.out.println("Il panino esiste gia.");
				requestDispatcher = request.getRequestDispatcher(response.encodeURL("admin.jsp"));
				requestDispatcher.forward(request, response);
			}

			else {
				uDao.doSave(panino);
				request.getSession().setAttribute("panino", panino);
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
