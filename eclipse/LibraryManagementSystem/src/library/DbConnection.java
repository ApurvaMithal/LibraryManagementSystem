package library;

import java.sql.*;

public class DbConnection {

	static Connection conn = null;
    /**
     * @param args
     */
    public Connection getDBConnection() {
		
		try {
			/* Create a connection to the local MySQL server, with the "company" database selected. */
			//        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "mypassword");
			//
			/* Create a connection to the local MySQL server, with the NO database selected. */
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "apurva");
			
			return conn;
		} 
		catch(SQLException ex) {
			System.out.println("Error in connection: " + ex.getMessage());
		}
		return conn;
    }

}


    