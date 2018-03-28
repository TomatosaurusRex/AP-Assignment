import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;

public class UpdateStatus {
	
static String username;
	
	public UpdateStatus() throws Exception {
		
		System.out.println();
		System.out.println("===================================");
		System.out.println("	Updateing User to MiniNet");
		System.out.println("===================================");
		System.out.println();
		
		System.out.print("Enter an Username that needs updating: ");
		Scanner in1 = new Scanner(System.in);
		username= in1.nextLine();
		
		try{
			System.out.print("Enter New Status: ");	
			Scanner p3 = new Scanner(System.in);
			String u3= p3.nextLine();
			System.out.println("Updating Status");
			
			com.mysql.jdbc.Connection con = Connectdb.getConnection("sql12228915","sql12228915","suS2gIQEFz");
			Statement addUser = con.createStatement();  
			addUser.executeUpdate("Insert Into UserStatus (UserName,StatusUpdatedTime,Status) Values ('"+username+"','"+LocalDateTime.now()+"','"+u3+"')");    

			BackMenu();
			
		}catch(Exception e){ System.out.println("Sorry That user does not exist. Please Try again");
		BackMenu();
		}
	}
		public void BackMenu() throws Exception{
			
			try{
			System.out.println();
			System.out.println("Update Another User?");
			System.out.println("1.	Yes");
			System.out.println("2.	Back to Main Menu");
			
			Scanner keyboard = new Scanner(System.in);
			System.out.print("Enter an option:");
			int choice = keyboard.nextInt();
			System.out.println();
			
			if(choice==1){
				
				UpdateStatus us = new UpdateStatus();
			}
			else if (choice==2)
			{
				Menu su = new Menu();
			}
			}catch(Exception e){ System.out.println("Incorrect Imput. Please Try again");
			BackMenu();}
		}
}