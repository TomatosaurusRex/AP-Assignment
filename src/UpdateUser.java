import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateUser {
	
	static String username;
	
	public UpdateUser() throws Exception {
		
		System.out.println();
		System.out.println("===================================");
		System.out.println("	Updateing User to MiniNet");
		System.out.println("===================================");
		System.out.println();
		
		System.out.print("Enter an Username that needs updating: ");
		Scanner in1 = new Scanner(System.in);
		username= in1.nextLine();
		
		Update();
	}	
	
	public void Update() throws Exception{		
		
		
		
		com.mysql.jdbc.Connection con = Connectdb.getConnection("sql12228915","sql12228915","suS2gIQEFz");
		
		System.out.println("===================================");
		System.out.println("	Which fields needs updateing?");
		System.out.println("===================================");
		System.out.println("1.	Name");
		System.out.println("2.	Age");
		System.out.println("3.	Back to Main Menu");
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter an option:");
		int choice = keyboard.nextInt();
		System.out.println();
		
		if(choice==1){
			
			System.out.println("Updating Name");
			System.out.print("Enter New Name: ");	
			Scanner p1 = new Scanner(System.in);
			String u2= p1.nextLine();
			
			try{ 
				Statement addUser = con.createStatement();  
				addUser.executeUpdate("Update Users set Name =  '"+u2+"'");  
				con.close(); 
				
				BackMenu();
				
				}catch(Exception e){ System.out.println(e);}  
		}
		else if (choice==2)
		{
			System.out.println("Updating Age");
			System.out.print("Enter New Age: ");	
			Scanner p2 = new Scanner(System.in);
			int u2= p2.nextInt();
			
			try{ 
				Statement addUser = con.createStatement();  
				addUser.executeUpdate("Update Users set Age = "+u2);  
				con.close(); 
				
				BackMenu();
				
				}catch(Exception e){ System.out.println(e);}  
			}
		else if (choice==3)
		{
			Menu cs = new Menu();
		}
}

	public void BackMenu() throws Exception{
		
		System.out.println();
		System.out.println("Keep updating current user?");
		System.out.println("1.	Yes");
		System.out.println("2.	Change Username");
		System.out.println("3.	Save and Back to Main Menu");
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter an option:");
		int choice = keyboard.nextInt();
		System.out.println();
		
		if(choice==1){
			Update();
		}
		else if (choice==2)
		{
			UpdateUser su = new UpdateUser();
		}
		else if (choice==3)
		{
			Menu su = new Menu();
		}
	}
	}
	



