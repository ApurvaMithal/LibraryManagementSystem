package library;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;

@WebServlet("/NewBorrowerServlet")
public class NewBorrowerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      public NewBorrowerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ssn = request.getParameter("ssn");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		if(!ssn.equals(""))
			ssn = ssn.toUpperCase();
		if(!name.equals(""))
			name = name.toUpperCase();
		if(!address.equals(""))
			address = address.toUpperCase();
		System.out.println("inside servlet");
	    JSONArray json = null;
		try {
			json = NewBorrower.addBorrower(ssn, name, address, phone);
			System.out.println("JSON "+json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    response.setContentType("application/json");
	    response.getWriter().print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
