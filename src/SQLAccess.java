
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLAccess {
	
	public SQLAccess(){
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://sql12.freesqldatabase.com,3306/sql12228915","sql12228915","suS2gIQEFz");   
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from Users");  
			while(rs.next())  
			System.out.println(rs.getString("UserName")+"  "+rs.getString("Name")+"  "+rs.getInt("Age"));  
			con.close();  
			}catch(Exception e){ System.out.println(e);}  
			}  
	}
	
