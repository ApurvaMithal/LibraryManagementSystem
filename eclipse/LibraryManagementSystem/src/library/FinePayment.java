package library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FinePayment {

	public static JSONArray getDetails(String cardId, String isbn) throws JSONException {
		// TODO Auto-generated method stub
		DbConnection dbObj = new DbConnection();
		Connection conn = null;
		conn = dbObj.getDBConnection();
		
		JSONArray fines = new JSONArray();
		JSONObject fine = null;
		int flag = 1;
		String db = "use library_system;";
		try {
			
				
				String sql = "select tab.*, fines.fine_amt, fines.paid from (select * from book_loans where (date_in is null and due_date < curdate()) or (date_in is not null and due_date < date_in)) tab left outer join fines on fines.loan_id = tab.loan_id where tab.card_id = "+cardId+ " and upper(tab.isbn) = '"+isbn+"';";
				System.out.println("sql1 "+sql);
				
				ResultSet rs = null;
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.execute(db);
				rs = ps.executeQuery();
				while(rs.next()){
					fine = new JSONObject();
					fine.put("loan_id", rs.getInt("loan_id"));
					fine.put("isbn", rs.getString("isbn"));
					fine.put("card_id", rs.getInt("card_id"));
					fine.put("date_out", rs.getDate("date_out"));
					fine.put("due_date", rs.getDate("due_date"));
					fine.put("date_in", rs.getDate("date_in"));
					fine.put("fine_amt", rs.getDouble("fine_amt"));
					fine.put("paid", rs.getInt("paid"));
					fines.put(fine);
				}
				if(rs!=null)
					rs.close();
				return fines;
				
				
	}
		catch(SQLException e){
			e.printStackTrace();
		}
		return fines;
		
	}
}
