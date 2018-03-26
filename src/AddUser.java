import java.io.BufferedWriter;
import java.io.File;

import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class AddUser{
	
	
	
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
	
	try {
		com.mysql.jdbc.Connection con = Connectdb.getConnection("sql12228915","sql12228915","suS2gIQEFz");
		Statement stmt = con.createStatement();  
		stmt.executeUpdate("Insert Into Users (UserName,Name,Age) Values ('"+u1+"','"+u2+"',"+u3+")");  
		con.close();  
	}
	
	catch(Exception e){ System.out.println(e);
				
	System.out.println("folowing user has been added: "+u1+","+u2+","+u3);
	System.out.println();
	
	try {
	BackMenu();
	} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
	}
	}
}
	
	public void BackMenu() throws Exception{
		

		System.out.println("Need to add another User?");
		System.out.println("1.	Yes");
		System.out.println("2.	Save and Back to Main Menu");
		
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
