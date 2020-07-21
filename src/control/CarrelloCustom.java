package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Carrello;
import model.PaninoBean;

/**
 * Servlet implementation class CarrelloCustom
 */
@WebServlet("/CarrelloCustom")
public class CarrelloCustom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarrelloCustom() {
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
		
		PaninoBean pb = new PaninoBean();
		pb.setNome("Panino personalizzato");		
		pb.setDescrizione("Panino personalizzato");
		
		pb.setPrezzo(
				Double.parseDouble(request.getParameter("pane")) + Double.parseDouble(request.getParameter("carne"))
				+ Double.parseDouble(request.getParameter("add1")) + Double.parseDouble(request.getParameter("add2")) +				
				Double.parseDouble(request.getParameter("salse")));
		
		System.out.println(pb.getPrezzo());
		
		HttpSession session = request.getSession();
		Carrello carrello = (Carrello) session.getAttribute("carrello");
		if(carrello == null) {
			carrello = new Carrello();
			session.setAttribute("carrello", carrello);
		}
		carrello.add(pb);
		
		RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
		rd.forward(request, response);
			
	}

}
