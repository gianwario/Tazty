package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmailValidator;
import model.UtenteBean;
import model.UtenteDAO;

/**
 * Servlet implementation class Registrazione
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("email");
		String password = request.getParameter("password");
		RequestDispatcher requestDispatcher = null;
		if(username==null) {
			requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/nuovoUtente.jsp");
			requestDispatcher.forward(request, response);
		}
		EmailValidator emailValidator = new EmailValidator();
			if(!emailValidator.validateEmail(username)) {
				System.out.println("Email non valida");
			}
		if(password.length()<5) System.out.println("Password non valida");
		UtenteBean u = new UtenteBean();
		UtenteDAO uDao = new UtenteDAO();
		try {
			 u = uDao.doRetrieveByUsernamePassword(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(u!=null) {
			request.getSession().setAttribute("utente", u);
			request.getSession().setMaxInactiveInterval(60);
			if(u.getAmministratore()==1) {
				requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/adminIndex.jsp");
			}
			else requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/userIndex.jsp");
		}
		else requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/nuovoUtente.jsp");
		request.setAttribute("username", username);	
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
