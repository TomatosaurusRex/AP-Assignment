import java.sql.Statement;
import java.util.Scanner;

/*
 * Adding of Friends to the Mininet Database
 * 
 */

public class AddFriends {

	public AddFriends() throws Exception{

		System.out.println();
		System.out.println("===================================");
		System.out.println("	Who are your Friends?");
		System.out.println("===================================");
		System.out.println();

		System.out.print("Enter an Username: ");
		Scanner in1 = new Scanner(System.in);
		String u1= in1.nextLine();

		System.out.print("Enter an Friends UserName: ");	
		Scanner in2 = new Scanner(System.in);
		String u2= in2.nextLine();
		
		try {
			com.mysql.jdbc.Connection con = Connectdb.getConnection("sql12228915","sql12228915","suS2gIQEFz");
			Statement addUser = con.createStatement();  
			addUser.executeUpdate("Insert Into UserFriend (UserName,FriendName) Values ('"+u1+"','"+u2+"')");    

			con.close();
			BackMenu();
		}
		catch(Exception e){ System.out.println("That username does not exist or they are already friends");
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

