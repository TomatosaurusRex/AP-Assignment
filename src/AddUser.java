import java.sql.Statement;
import java.util.Scanner;

/*
 * Adding of Users to the Mininet Database
 * 
 */

public class AddUser{

	String d1,d2;

	@SuppressWarnings({ "resource", "unused" })
	public AddUser() throws Exception{

		System.out.println();
		System.out.println("===================================");
		System.out.println("	Adding User to MiniNet");
		System.out.println("===================================");
		System.out.println();

		System.out.print("Enter an Username: ");
		System.out.print("*10 charactors limit");
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
		try {
			com.mysql.jdbc.Connection con = Connectdb.getConnection("sql12228915","sql12228915","suS2gIQEFz");
			Statement addUser = con.createStatement();  
			addUser.executeUpdate("Insert Into Users (UserName,Name,Age) Values ('"+u1+"','"+u2+"',"+u3+")");    

			try{
				while (d1!=null&&d2!=null){
					Statement addParent = con.createStatement();  
					addParent.executeUpdate("Insert Into Users (UserName,P1UserName,P2UserName) Values ('"+u1+"','"+d1+"',"+d2+")");  
				}
			}
			catch(Exception e){ System.out.println("One or both parents do not exists in the database. Please try again");
			}
			con.close();
			BackMenu();
		}
		catch(Exception e){ System.out.println("That username already exists or user name is over 10 charactors long");
		}
	}
	@SuppressWarnings({ "unused", "resource" })
	public void BackMenu() throws Exception{

		try{
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
		}catch(Exception e){ System.out.println("Incorrect Imput. Please Try again");
		BackMenu();}
	}
}
