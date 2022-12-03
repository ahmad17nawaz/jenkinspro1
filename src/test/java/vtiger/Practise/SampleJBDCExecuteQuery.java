package vtiger.Practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;



public class SampleJBDCExecuteQuery {
	
	public static void main(String[] args) throws SQLException{
		
		Driver driverRef = new Driver();
		
		//Step 1: Register the driver/database
		DriverManager.registerDriver(driverRef);
		
		//Step 2: Get the connection with database -> provide database name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clientdb","root","root");
		
		//Step 3: Issue create statement
		 java.sql.Statement state = con.createStatement();
		
		//Step 4: Execute a query - > provide table name
		ResultSet result = state.executeQuery("select * from clientinfo;");
		while(result.next())
		{
		System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));	
		}
		
		//Step 5: close the database
				con.close();
	}
}
