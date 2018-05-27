package library;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.json.JsonArray;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;

@WebServlet("/PopulateBook")


public class PopulateBook extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public PopulateBook()  {
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String search_key = request.getParameter("term");
		if(!search_key.equals(""))
			search_key = search_key.toUpperCase();
	    System.out.println("search_key  " + search_key);
	   // FetchBook al = new FetchBook();
	    JSONArray json = null;
		try {
			json = FetchBook.getAllBooks(search_key);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    response.setContentType("application/json");
	    response.getWriter().print(json);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
}


