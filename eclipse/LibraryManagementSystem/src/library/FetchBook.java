package library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import library.DbConnection;
public class FetchBook {

	public FetchBook() {
	}
	/*public static void main(String args[]){
		JSONArray bookList = new JSONArray();
		try {
			bookList = getAllBooks("aa");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	public static JSONArray getAllBooks(String search_key) throws JSONException {
		DbConnection dbObj = new DbConnection();
		Connection conn = null;
		conn = dbObj.getDBConnection();
		JSONArray  books = new JSONArray();
		JSONObject book;
		String db = "use library_system;";
		String[] searchArray = search_key.split(" "); 
		
		try {
			String sql = "select book.*, group_concat(tab.name) Name from book left outer join (select book_authors.isbn, authors.name from book_authors left outer join authors on book_authors.author_id = authors.author_id) tab on tab.isbn = book.isbn ";
			
			int j=0;
			String word = "";
			for(int k=0; k<searchArray.length; k++){
				if(searchArray[k] != ""){
					sql+= "where ";
					break;
				}
			}
		if(searchArray.length>0){
			while(j < searchArray.length - 1){
			//	System.out.println("word "+word);
				word = searchArray[j];
				if(!word.equals("")){
					sql += " upper(book.isbn)like '%"+word+"%'  or upper(book.title) like '%"+word+"%' or upper(tab.name) like '%"+word+"%' or";
				}
			j++;
			}
			word = searchArray[j];
			if(!word.equals("")){
				sql += " upper(book.isbn) like '%"+word+"%'  or upper(book.title) like '%"+word+"%' or upper(tab.name) like '%"+word+"%' ";
				//System.out.println("word "+word);
				}
		}
		
			sql += "group by (book.isbn);";
	//	System.out.println("sql "+sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.execute(db);
			ResultSet rs = ps.executeQuery();
			int i=0;
			PreparedStatement ps2 = null;
			ResultSet rs2 = null;
			
			while(rs.next()) { 
					String avail = "Available";
					ps2 = conn.prepareStatement("select date_out, date_in, curdate() curr from book_loans where upper(isbn) like '%"+rs.getString("isbn").toUpperCase()+"%' order by date_out desc limit 1;");
					 rs2 = ps2.executeQuery();
					 if(rs2.next()){
						// System.out.println("inside ");
						 if(!(rs2.getDate("date_out")==null)){
							 if(!(rs2.getDate("date_in")==null) && (rs2.getDate("date_in").compareTo( rs2.getDate("curr"))<0)){
								 avail = "Available";
							 }
							 else if(rs2.getDate("date_in")==null)
								 avail = "Not Available";
						}
					 }
					 else{
						 avail = "Available";
					 }
					 
					book = new JSONObject();
					book.put("id", i);
					book.put("isbn", rs.getString("isbn"));
					book.put("name", rs.getString("name"));
					book.put("title", rs.getString("title"));
					book.put("avail", avail);
					books.put(book);
					i++;
					
			}
		//	json.put("book", books);
			if(rs!=null)
				rs.close();
			if(conn!=null)
				conn.close();
			if(rs2!=null)
				rs2.close();
		}
		catch (SQLException e) {
		e.printStackTrace();
		}
		return books;
	}
}

