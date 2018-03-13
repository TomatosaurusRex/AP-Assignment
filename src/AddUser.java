import java.util.Scanner;

public class AddUser {
	
	String user[];

	public AddUser() throws Exception{
		
		
		System.out.println();
		System.out.println("===================================");
		System.out.println("	Adding User to MiniNet");
		System.out.println("===================================");
		System.out.println();
		
	System.out.print("Enter an Username: ");
	Scanner in1 = new Scanner(System.in);
	String u1= in1.nextLine();
	
	System.out.print("Enter an Name: ");	
	Scanner in2 = new Scanner(System.in);
	String u2= in2.nextLine();
	
	System.out.print("Enter an age: ");	
	Scanner in3 = new Scanner(System.in);
	int u3= in3.nextInt();
	
	if (u3<16){
		System.out.println("You are under 16yo. Please enter your parents Usernames when prompted");
		System.out.print("Parents 1's Name: ");	
		Scanner p1 = new Scanner(System.in);
		String d1 = p1.nextLine();
		
		System.out.print("Parents 2's Name: ");	
		Scanner p2 = new Scanner(System.in);
		String d2 = p2.nextLine();
		}
	else{
		
	}
	
	System.out.print("Enter an status: ");	
	Scanner in4 = new Scanner(System.in);
	String u4= in4.nextLine();
	
	System.out.println("folowing user has been added: "+u1+","+u2+","+u3+","+u4);
	System.out.println();
	
	try {
		BackMenu();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	public void BackMenu() throws Exception{
		

		System.out.println("Need to add another User?");
		System.out.println("1.	Yes");
		System.out.println("2.	Back to Main Menu");
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter an option:");
		int choice = keyboard.nextInt();
		System.out.println();
		
		if(choice==1){
			AddUser nn = new AddUser();
		}
		else if (choice==2)
		{
			Menu su = new Menu();
		}

	}

}
