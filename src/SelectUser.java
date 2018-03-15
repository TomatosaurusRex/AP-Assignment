import java.util.Scanner;

public class SelectUser {
	
	public SelectUser(){
		
		System.out.println("===================================");
		System.out.println("	View User");
		System.out.println("===================================");
		System.out.println();
		
			
	}
	public void SelectUser() throws Exception{
		
		System.out.print("Enter an Username you would like to view ");
		Scanner in1 = new Scanner(System.in);
		String u1= in1.nextLine();
		
		BackMenu();
		
	}
	
	public void BackMenu() throws Exception{
		
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println("1.	View a another user");
		System.out.println("2.	Back to Main Menu");
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter an option:");
		int choice = keyboard.nextInt();
		System.out.println();
		
		if(choice==1)
		{
			SelectUser us = new SelectUser();
		}
		else if (choice==2)
		{
			UpdateUser uu = new UpdateUser();
		}
		
		
		
	}

}
