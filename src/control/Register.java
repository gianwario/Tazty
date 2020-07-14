package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmailValidator;
import model.UserBean;
import model.UserDAO;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
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
		UserBean utente = new UserBean();
		utente.setUsername(request.getParameter("username"));
		utente.setNome(request.getParameter("nome"));
		utente.setCognome(request.getParameter("cognome"));
		utente.setPassword(request.getParameter("password"));
		utente.setEmail(request.getParameter("email"));
		utente.setIndirizzo(request.getParameter("indirizzo"));
		utente.setCellulare(request.getParameter("phone"));
		if (request.getParameter("username").length() == 0)
			System.out.println("L'username non può essere vuoto");
		if (request.getParameter("nome").length() == 0)
			System.out.println("Il nome non può essere vuoto");
		if (request.getParameter("cognome").length() == 0)
			System.out.println("Il cognome non può essere vuoto");
		if (request.getParameter("password").length() < 6)
			System.out.println("La password deve contenere almeno 6 caratteri");

		RequestDispatcher requestDispatcher = null;
		UserDAO uDao = new UserDAO();

		try {
			if (uDao.check(utente.getUsername())) {
				System.out.println("L'utente esiste gia.");
				requestDispatcher = request.getRequestDispatcher("register.html");
			}

			else {
				uDao.doSave(utente);
				request.getSession().setAttribute("utente", utente);
				request.getSession().setMaxInactiveInterval(60);
				requestDispatcher = request.getRequestDispatcher("index.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(utente);
		requestDispatcher.forward(request, response);
	}

}
