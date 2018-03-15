import java.util.Scanner;

public class ListUsers {
	
	public ListUsers() throws Exception{
		
		System.out.println("===================================");
		System.out.println("	All Current Users");
		System.out.println("===================================");
		System.out.println();
		
		
		BackMenu();	
		
	}
		
		public void BackMenu() throws Exception{
			
			System.out.println();
			System.out.println("What would you liek to do?");
			System.out.println("1.	View a user");
			System.out.println("2.	Update a User");
			System.out.println("3.	Back to Main Menu");
			
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
				UpdateUser uu = new UpdateUser();
			}
			else if (choice==3)
			{
				Menu mm = new Menu();
			}
		
		
		
	}

}
