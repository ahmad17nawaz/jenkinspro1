package vtiger.Practise;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;

public class SampleJDBCExecuteUpdate {
 
public static void main(String[] args) throws SQLException{
		
		Driver driverRef = new Driver();
		Connection con = null;
		try {
		//Step 1: Register the driver
		DriverManager.registerDriver(driverRef);
		
		//Step 2: Get the connection
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientdb","root","root");
		
		//Step 3: Issue create statement
		 java.sql.Statement state = con.createStatement();
		
		//Step 4: Execute a query
		String query = "insert into clientinfo values('Satish',15,'Pune);";
		int result = state.executeUpdate(query);
		
		//System.out.println(result);
		if(result==1)
		{
		System.out.println("data inserted");	
		}
		else {
			System.out.println("data not inserted");
		}
		}
		
		catch (Exception e) {
			// TODO: handle exception
		}
		
		finally {
			//Step 5: Close database
			 con.close();
			 System.out.println("database closed");
		}
		
}
}


