package library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FinePaymentDisplay {

	public static JSONArray display() throws JSONException {
		// TODO Auto-generated method stub
		DbConnection dbObj = new DbConnection();
		Connection conn = null;
		conn = dbObj.getDBConnection();
		String db = "use library_system;";
		JSONArray fines = new JSONArray();
		JSONObject fine = null;
		int flag = 1;
		
		try {
			
				String sql = "select card_id, sum(fines.fine_amt) total_fine, paid from (select * from book_loans where (date_in is null and due_date < curdate()) or (date_in is not null and due_date < date_in)) tab left outer join fines on fines.loan_id = tab.loan_id group by card_id, paid;";
				System.out.println("sql1 "+sql);
				
				ResultSet rs = null;
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.execute(db);
				rs = ps.executeQuery();
				while(rs.next()){
					fine = new JSONObject();
					fine.put("card_id", rs.getInt("card_id"));
					fine.put("fine_amt", rs.getBigDecimal("total_fine"));
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
