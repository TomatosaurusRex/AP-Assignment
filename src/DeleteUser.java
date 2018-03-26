import java.util.Scanner;

public class DeleteUser {
	
	String u1;
	
	public DeleteUser() throws Exception{
	
		System.out.println("===================================");
		System.out.println("	Delete User");
		System.out.println("===================================");
		System.out.println();
		
		System.out.print("Enter an Username that needs deleting: ");
		Scanner in1 = new Scanner(System.in);
		u1= in1.nextLine();
		
		System.out.println();
		System.out.println("Are you sure you want to delete " + u1 + "?");
		System.out.println("1.	Yes");
		System.out.println("2.	No");
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter an option:");
		int choice = keyboard.nextInt();
		System.out.println();
		
		if(choice==1)
		{
			DeleteU();
		}
		else if (choice==2)
		{
			BackMenu();
		}
	}
	
	public void DeleteU() throws Exception{
		
		System.out.println();
		System.out.println("Are you Ready sure you want to delete " + u1 + "?");
		System.out.println("1.	Yes. Cannot be undone");
		System.out.println("2.	No");
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter an option:");
		int choice = keyboard.nextInt();
		System.out.println();
		
		if(choice==1)
		{
			DeleteU();
		}
		else if (choice==2)
		{
			BackMenu();
		}	
	}
	
	public void BackMenu() throws Exception{
		
		System.out.println();
		System.out.println("What would you liek to do?");
		System.out.println("1.	Delete another User");
		System.out.println("2.	Back to Main Menu");
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter an option:");
		int choice = keyboard.nextInt();
		System.out.println();
		
		if(choice==1)
		{
			DeleteUser du = new DeleteUser();
		}
		else if (choice==2)
		{
			Menu m = new Menu();
		}
	}
}
