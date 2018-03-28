

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/*
 * Connection to the database to hold all of the Mini Net info
 * 
 * 
 */
	
	public class Connectdb {   
		static {
		     try {
		        Class.forName("com.mysql.jdbc.Driver");
		    } catch (ClassNotFoundException e) {
		        throw new IllegalArgumentException("MySQL db driver isnot on classpath");
		    }
		}
		public static Connection getConnection(String db_name,String user_name,String password) throws SQLException
		{
		    return (Connection) DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com,3306/"+db_name+"?user="+user_name+"&password="+password);    
		}
} 