import java.util.Scanner;

public class Menu {
	
	public Menu() throws Exception{
		
	System.out.println("===================================");
	System.out.println("	MiniNet	Menu");
	System.out.println("===================================");
	System.out.println("1.	List all Users");
	System.out.println("2.	Select a User");
	System.out.println("3.	Who are their friends");
	System.out.println("4.	Check User status");
	System.out.println("5.	Add User");
	System.out.println("6.	Update User");
	System.out.println("7.	Delete User");
	System.out.println("8.	Exit");
	System.out.println();

	@SuppressWarnings("resource")
	Scanner keyboard = new Scanner(System.in);
	System.out.print("Enter an option:");
	int choice = keyboard.nextInt();
	if(choice==1){
		ListUsers lu = new ListUsers();
		//SQLAccess sa = new SQLAccess();
	}
	else if (choice==2)
	{
		SelectUser su = new SelectUser();
	}
	else if (choice==3)
	{
		FriendLookup fl = new FriendLookup();
	}
	else if (choice==4)
	{
		CheckStatus cs = new CheckStatus();
	}
	else if (choice==5)
	{
		AddUser au = new AddUser();
	}
	else if (choice==6)
	{
		UpdateUser uu = new UpdateUser();
	}
	else if (choice==7)
	{
		DeleteUser du = new DeleteUser();
	}
	else if (choice==8)
	{
		System.out.println("Good Bye");
		System.exit(0);
	}
	}
}
