package library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CheckIn {

	public static JSONArray check(String card, String isbn, String name) throws JSONException {
		// TODO Auto-generated method stub
		DbConnection dbObj = new DbConnection();
		Connection conn = null;
		conn = dbObj.getDBConnection();
		String db = "use library_system;";
		JSONArray book_loans = new JSONArray();
		
		int flag = 1;
		
		try {
			
			if(card.equals("") && isbn.equals("") && name.equals("")){
				flag = 0;
			}
			
			else{
				String sql = "select loan_id, isbn, card_id, date_out, due_date, date_in from book_loans where ";
			//	int cardId = Integer.parseInt(card);
				ResultSet rs = null;
				
				if(!card.equals("")){
					sql += "card_id = "+card;
					if(!isbn.equals("")){
						sql += " and upper(isbn) like '%"+ isbn.toUpperCase()+"%'";
						if(!name.equals("")){
							//sql += "and name = '"+ name+"'";
							sql += " and card_id in (select card_id from borrower where upper(bname) like '%"+ name.toUpperCase()+"%')";
						}
						
					}
					else{
						if(!name.equals("")){
							sql += " and card_id in (select card_id from borrower where upper(bname) like '%"+ name.toUpperCase()+"%')";
						}
					}
				}
				else{
					if(!isbn.equals("")){
						sql += " upper(isbn) like '%"+ isbn.toUpperCase()+"%'";
						if(!name.equals("")){
							sql += " and card_id in (select card_id from borrower where upper(bname) like '%"+ name.toUpperCase()+"%')";
						}
						
					}
					else{
						if(!name.equals("")){
							sql += " card_id in (select card_id from borrower where upper(bname) like '%"+ name.toUpperCase()+"%')";
						}
					}
				}
				sql += ";";
				System.out.println(sql);
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.execute(db);
				rs = ps.executeQuery();
				JSONObject book_loan;
				int i =0;
				while(rs.next()) { 
					book_loan = new JSONObject();
					book_loan.put("loan_id", rs.getInt("loan_id"));
					book_loan.put("isbn", rs.getString("isbn"));
					book_loan.put("card_id", rs.getInt("card_id"));
					book_loan.put("date_out", rs.getDate("date_out"));
					book_loan.put("due_date", rs.getDate("due_date"));
					book_loan.put("date_in", rs.getDate("date_in"));
					book_loans.put(book_loan);
					i++;
				}
			/*	PreparedStatement ps2 = null;
				ps2 = conn.prepareStatement("update book_loans set date_in = curdate() where loan_id = ;");
				ps2.execute();
				*/
				if(rs!=null)
					rs.close();
				if(conn!=null)
				conn.close();
				
			}
			/*	obj.put("flag",flag);
				arr.put(obj);
				*/
				
				return book_loans;
			}
		
		catch (SQLException e) {
		e.printStackTrace();
		}
		return book_loans;
		
	}

}
