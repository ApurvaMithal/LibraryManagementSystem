package library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NewBorrower {

	NewBorrower() {

	}

	public static JSONArray addBorrower(String ssn, String name,
			String address, String phone) throws JSONException {
		// TODO Auto-generated method stub
		DbConnection dbObj = new DbConnection();
		Connection conn = null;
		conn = dbObj.getDBConnection();
		int flag_maxLimit = 1;
		int flag_ssn = 1;
		int flag_name = 1;
		int flag_address = 1;
		String db = "use library_system;";	
		JSONArray arr = new JSONArray();
		JSONObject obj = new JSONObject();

		try {

			PreparedStatement ps = conn
					.prepareStatement("select count(*) cnt from borrower where upper(ssn) = '"
							+ ssn + "';");
			ps.execute(db);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int cnt = rs.getInt("cnt");
				if (cnt > 0)
					flag_maxLimit = 0;
			}
			if(ssn.equals("")){
				flag_ssn = 0;
			}
			if(name.equals("")){
				flag_name = 0;
			}
			if(address.equals("")){
				flag_address = 0;
			}
			
			PreparedStatement ps2 = null;

			if ((flag_maxLimit == 1) && (flag_ssn == 1) && (flag_name == 1) && (flag_address == 1)){
				System.out.println("inside if");
				ps2 = conn
						.prepareStatement("insert into borrower(ssn, bname, address, phone) values ('"+ssn+"', '"+name+"', '"+address+"', '"+phone+"');");

				ps2.execute();
			}
			obj.put("flag_maxLimit", flag_maxLimit);
			obj.put("flag_ssn", flag_ssn);
			obj.put("flag_name", flag_name);
			obj.put("flag_address", flag_address);
			arr.put(obj);
			if(rs!=null)
				rs.close();
			if(conn!=null)
				conn.close();
			return arr;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

}
