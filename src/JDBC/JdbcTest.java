package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {

	public static void main(String[] args) throws SQLException {
	
	Connection myConnection = null;
	Statement myStatement = null;
	
	ResultSet myResult =null;
	
	String urlString = "jdbc:mysql://localhost:3306/amazonbooks";
	String username="root";
	String password="ANKARA06..";
	
	
	try {
	//1. Get a connection to database	
		
	 myConnection = DriverManager.getConnection(urlString, username, password);

					System.out.println("Database connection is succecfull!\n");
		//2. Create a statement
					
		myStatement = myConnection.createStatement();
		
		
		//3. Execute SQL query
		
		myResult = myStatement.executeQuery("select *from books");
		
		//4.process the result set
		
		while(myResult.next()) {
			
		
			
		System.out.println(myResult.getString("book_id")+
		" , " + myResult.getString("title")+ " , " + myResult.getString("author_fname")
		+ " , " + myResult.getString("author_lname")+ " , " + myResult.getString("released_year")
		+ " , " + myResult.getString("stock_quantity")+ " , " + myResult.getString("pages"));
		
		}
		
	
	} catch (Exception e) {
		e.printStackTrace();
	
	}	finally {
		if(myResult != null) {
		myResult.close();	
			
		}
	if(myStatement!=null) {
	myStatement.close();	
		
	}
	
	if(myConnection !=null) {
		
	myConnection.close();	
	
	}
	}
		
		
		
		
		
	}

}
