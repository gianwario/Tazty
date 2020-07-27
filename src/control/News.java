package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import model.NewDAO;
import model.NewBean;

/**
 * Servlet implementation class News
 */
@WebServlet("/News")
public class News extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public News() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JSONArray newsJson = new JSONArray();
		NewDAO dao = new NewDAO();
		ArrayList<NewBean> list = dao.getLatestNews();		
		try {
			
			for(int i = 0; i<4; i++) {
				JSONObject obj = new JSONObject();
				
				NewBean news = list.get(i);
				
				obj.put("titolo", news.getTitolo());
				obj.put("corpo", news.getCorpo());
				obj.put("dataora", news.getDataora());
				obj.put("username", news.getUsername());
				obj.put("foto", news.getImage());
				
				newsJson.put(obj);
			}		
		} catch (JSONException e) {
			e.printStackTrace();
		}		
		response.setContentType("application/json");
		response.getWriter().append(newsJson.toString());	
		
	}

}
