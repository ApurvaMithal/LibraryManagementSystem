package library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class CheckInUpdate {


	public static JSONArray checkInUpd(String loan_id, String card_id, String isbn) throws JSONException {
		// TODO Auto-generated method stub
		DbConnection dbObj = new DbConnection();
		Connection conn = null;
		conn = dbObj.getDBConnection();
		String db = "use library_system;";
		JSONArray checkIn = new JSONArray();
		
		int flag = 1;
		
		try {
		
				PreparedStatement ps = null;
				ps = conn.prepareStatement("update book_loans set date_in = curdate() where loan_id = "+ loan_id+";");
				
				ps.execute(db);
				ps.execute();
				if(conn!=null)
					conn.close();
				ps.close();
				
				JSONObject obj = new JSONObject();
				obj.put("id",1);
				checkIn.put(obj);
				
				return checkIn;
				
			}
		
		catch (SQLException e) {
		e.printStackTrace();
		}
		return checkIn;
		
	}

}
