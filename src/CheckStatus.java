import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class CheckStatus {
	
	@SuppressWarnings("resource")
	public CheckStatus() throws Exception{
				
		System.out.println("===================================");
		System.out.println("	Lookup Users Status");
		System.out.println("===================================");
		System.out.println();
		
		System.out.print("Enter an Username: ");
		Scanner in1 = new Scanner(System.in);
		String un= in1.nextLine();

		try{ 
		com.mysql.jdbc.Connection con = Connectdb.getConnection("sql12228915","sql12228915","suS2gIQEFz");
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from UserStatus where UserName = '"+un+"'");  
		while(rs.next())  
		System.out.println(rs.getString("UserName")+" Was "+rs.getString("Status")+" on the "+rs.getString("StatusUpdatedTime"));  
		con.close(); 
		
		BackMenu();
		}
		catch(Exception e){ System.out.println("Sorry That user does not exist. Please Try again");
		BackMenu();
		}  
	}

		@SuppressWarnings({ "unused", "resource" })
		public void BackMenu() throws Exception{
			
			try{
			System.out.println();
			System.out.println("What would you like to do?");
			System.out.println("1.	Select Another user");
			System.out.println("2.	Back to Main Menu");
			
			Scanner keyboard = new Scanner(System.in);
			System.out.print("Enter an option:");
			int choice = keyboard.nextInt();
			System.out.println();
			
			if(choice==1)
			{
				CheckStatus cs = new CheckStatus();
			}
			else if (choice==2)
			{
				Menu mm = new Menu();
			}
			}catch(Exception e){ System.out.println("Incorrect Imput. Please Try again");
			BackMenu();
	}
		}
		}
