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
import model.UserBean;
import model.UserDAO;

/**
 * Servlet implementation class Login
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+password);
		RequestDispatcher requestDispatcher = null;
		
		if(username==null || password==null || password.length() < 6) {
			requestDispatcher = request.getRequestDispatcher("register.html");
			requestDispatcher.forward(request, response);
			return;
		}
		
		UserBean u = new UserBean();
		UserDAO uDao = new UserDAO();
		
		try {
			 u = uDao.getUserByUsernameAndPassword(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(u);
		if(u!=null) {
			request.getSession().setAttribute("utente", u);
			request.getSession().setMaxInactiveInterval(60);
			requestDispatcher = request.getRequestDispatcher("index.jsp");
		}
		else {
			requestDispatcher = request.getRequestDispatcher("register.html");
		}
		requestDispatcher.forward(request, response);
	}

}
