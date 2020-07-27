package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Carrello;
import model.OrdineBean;
import model.OrdineDAO;
import model.ProductBean;
import model.RelativoABean;
import model.RelativoADAO;
import model.UserBean;

/**
 * Servlet implementation class CompletaOrdine
 */
@WebServlet("/CompletaOrdine")
public class CompletaOrdine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompletaOrdine() {
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
		
		double subTot = 0;
		
		Carrello cart = (Carrello) request.getSession().getAttribute("carrello");
		UserBean user = (UserBean) request.getSession().getAttribute("utente");
		
		
		OrdineDAO dao = new OrdineDAO();		
		OrdineBean bean = new OrdineBean();	
		
		
		for(ProductBean b : cart.getprodotto()) {
			subTot += b.getPrezzo();
			if(!b.getNome().equals("Panino personalizzato"))
				bean.addProduct(b);
			
			
		}
		request.getSession().setAttribute("carrello", new Carrello());
		
		bean.setUsername(user.getUsername());
		bean.setTotale(subTot + 5);
		bean.setPagamento(request.getParameter("pagamento"));
		
		
		try {
			dao.doSave(bean);
			/*SALVATAGGIO in relativoa*/
			int cod_ordine = dao.getLastOrder();
			RelativoADAO rad = new RelativoADAO();
			for(ProductBean b : bean.getProductList() ) {
				RelativoABean rab = new RelativoABean();
				rab.setCod_ordine(cod_ordine);
				rab.setCod_prodotto(b.getCod_prodotto());
				rad.doSave(rab);
				
			}
						
			RequestDispatcher rd = request.getRequestDispatcher(response.encodeURL("Menu"));
			rd.forward(request, response);
		} 
		catch (SQLException e) { e.printStackTrace(); }

	
		
	}

}
