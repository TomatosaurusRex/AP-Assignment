import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ListUsers{

	private static final String STYLESHEET_CASPIAN = null;
	private TableView<Users> table = new TableView<Users>();
	final ObservableList<Users> data = FXCollections.observableArrayList();

	public BorderPane listUsers() throws Exception {

		BorderPane border = new BorderPane();
		HBox hbox = addHBox();
		border.setTop(hbox);
		border.setLeft(addVBox());
		border.setCenter(addTable());
		border.setBottom(addUser());

		return border;
	}

	private Node addVBox() throws Exception {

		Button btn1 = new Button("Back");
		Button close = new Button("Exit");

		btn1.setOnAction (e -> {try {MiniNet2 mn = new MiniNet2();
		} catch (Exception e1) {
			e1.printStackTrace();
		}});
		close.setOnAction(e -> System.exit(0));

		btn1.setMaxWidth(Double.MAX_VALUE);
		close.setMaxWidth(Double.MAX_VALUE);

		VBox addVBox = new VBox(2);
		addVBox.getChildren().addAll(btn1,close);
		addVBox.setPadding(new Insets(15, 12, 15, 12));
		addVBox.setStyle("-fx-background-color: #336699;");
		
		return addVBox;
	}

	private HBox addHBox() throws FileNotFoundException {

		Image image = new Image(new FileInputStream("C:\\Users\\thoma\\workspace\\AP-Assignment\\src\\M4H6iDSu.gif")); 
		ImageView imageView = new ImageView(image); 
		imageView.setPreserveRatio(true); 
		Label label = new Label("test text");
		label.setAlignment(Pos.CENTER);
		label.setStyle(STYLESHEET_CASPIAN);
		HBox hbox = new HBox();
		Region region1 = new Region();
		HBox.setHgrow(region1, Priority.ALWAYS);
		Region region2 = new Region();
		HBox.setHgrow(region2, Priority.ALWAYS);
		hbox.setPadding(new Insets(20, 12, 15, 12));
		hbox.setSpacing(5);
		hbox.setStyle("-fx-background-color: #336699;");
		hbox.getChildren().addAll(region1, imageView,region2);

		return hbox;
	}

	private TableView<Users> addTable() {

		try{ 
			com.mysql.jdbc.Connection con = Connectdb.getConnection("sql12228915","sql12228915","suS2gIQEFz");
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from Users"); 
			while(rs.next()){  
				String userName = rs.getString( "UserName" );                                
                String name = rs.getString( "Name" );
                String age = rs.getString( "Age" );
				ObservableList<String> row = FXCollections.observableArrayList();
//				System.out.println(rs.getString("UserName")+"  "+rs.getString("Name")+"  "+rs.getInt("Age"));  

				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					row.add(rs.getString(i));  
					System.out.println(row);
				}
				data.add((Users) row);
			}
			con.close(); 

		}catch(Exception e){ System.out.println(e);}  

		table.setItems(data);
		table.setEditable(true);

		TableColumn userNameCol = new TableColumn("UserName");
		userNameCol.setMinWidth(100);
		userNameCol.setCellValueFactory(
				new PropertyValueFactory<Users,String>("UserName")
				);
		TableColumn nameCol = new TableColumn("Name");
		nameCol.setMinWidth(100);
		nameCol.setCellValueFactory(
				new PropertyValueFactory<Users,String>("Name")
				);
		TableColumn ageCol = new TableColumn("Age");
		ageCol.setMinWidth(100);
		ageCol.setCellValueFactory(
				new PropertyValueFactory<Users,String>("Age")
				);

		table.getColumns().addAll(userNameCol, nameCol, ageCol);

		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(table);

		return table;
	}

	@SuppressWarnings("unused")
	private Node addUser() throws Exception {

		HBox hbox = new HBox();
		Region region1 = new Region();
		HBox.setHgrow(region1, Priority.ALWAYS);
		Region region2 = new Region();
		HBox.setHgrow(region2, Priority.ALWAYS);
		final TextField addUserName = new TextField();
		addUserName.setPromptText("User Name");
		addUserName.setMaxWidth(150);
		final TextField addName = new TextField();
		addName.setMaxWidth(150);
		addName.setPromptText("Name");
		final TextField addAge = new TextField();
		addAge.setMaxWidth(150);
		addAge.setPromptText("Age");
		final Button addButton = new Button("Add New User");
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				data.add(new Users(
						addUserName.getText(),
						addName.getText(),
						addAge.getText()));
				addUserName.clear();
				addName.clear();
				addAge.clear();
			}
		});
		hbox.setSpacing(5);
		hbox.setPadding(new Insets(15, 12, 15, 12));
		hbox.getChildren().addAll(region1,addUserName, addName,addAge,addButton,region2);


		return hbox;

	}

	public static class Users {
		private final SimpleStringProperty userName;
		private final SimpleStringProperty name;
		private final SimpleStringProperty age;

		private Users(String uName, String name, String age) {
			this.userName = new SimpleStringProperty(uName);
			this.name = new SimpleStringProperty(name);
			this.age = new SimpleStringProperty(age);
		}

		public String getUserName() {
			return userName.get();
		}
		public void setUserName(String uName) {
			userName.set(uName);
		}

		public String getName() {
			return name.get();
		}
		public void setName(String uName) {
			name.set(uName);
		}

		public String getAge() {
			return age.get();
		}
		public void setAge(String uName) {
			age.set(uName);
		}

	}
}
//public void ListUsers2()  throws Exception  {
//		
////		System.out.println("===================================");
////		System.out.println("	All Current Users");
////		System.out.println("===================================");
////		System.out.println();
////
//		try{ 
//		com.mysql.jdbc.Connection con = Connectdb.getConnection("sql12228915","sql12228915","suS2gIQEFz");
//		
//		Statement stmt=con.createStatement();  
//		ResultSet rs=stmt.executeQuery("select * from Users");  
//		while(rs.next())  
//		System.out.println(rs.getString("UserName")+"  "+rs.getString("Name")+"  "+rs.getInt("Age"));  
//		con.close(); 
//		
//		//BackMenu();
//		
//		}catch(Exception e){ System.out.println(e);}  
//	}
//}
////	
////	
////	static String read;
////	
////	private SimpleStringProperty userName;
//    private SimpleStringProperty name;
//    private SimpleStringProperty age1;
// 
//    private void Users(String uName, String rName, String age) {
//        this.userName = new SimpleStringProperty(uName);
//        this.name = new SimpleStringProperty(rName);
//        this.age1 = new SimpleStringProperty(age);
//    }
// 
//    public String getFirstName() {
//        return userName.get();
//    }
//    public void setFirstName(String fName) {
//    	userName.set(fName);
//    }
//        
//    public String getLastName() {
//        return name.get();
//    }
//    public void setLastName(String fName) {
//    	name.set(fName);
//    }
//    
//    public String getEmail() {
//        return age1.get();
//    }
//    public void setEmail(String fName) {
//    	age1.set(fName);
//    }
//	
//	public ListUsers()  throws Exception  {
//		
////		System.out.println("===================================");
////		System.out.println("	All Current Users");
////		System.out.println("===================================");
////		System.out.println();
////
//		try{ 
//		com.mysql.jdbc.Connection con = Connectdb.getConnection("sql12228915","sql12228915","suS2gIQEFz");
//		
//		Statement stmt=con.createStatement();  
//		ResultSet rs=stmt.executeQuery("select * from Users");  
//		while(rs.next())  
//		System.out.println(rs.getString("UserName")+"  "+rs.getString("Name")+"  "+rs.getInt("Age"));  
//		con.close(); 
//		
//		//BackMenu();
//		
//		}catch(Exception e){ System.out.println(e);}  
//	}
//		public void BackMenu() throws Exception{
//			
//			System.out.println();
//			System.out.println("What would you liek to do?");
//			System.out.println("1.	View a user");
//			System.out.println("2.	Update a User");
//			System.out.println("3.	Back to Main Menu");
//			
//			Scanner keyboard = new Scanner(System.in);
//			System.out.print("Enter an option:");
//			int choice = keyboard.nextInt();
//			System.out.println();
//			
//			if(choice==1)
//			{
//				CheckStatus cs = new CheckStatus();
//			}
//			else if (choice==2)
//			{
//				UpdateUser uu = new UpdateUser();
//			}
//			else if (choice==3)
//			{
//				Menu mm = new Menu();
//			}
//	}
//
////			
////			
////	@Override
////	public void start(Stage primaryStage) throws Exception {
////		
////		try{ 
////			com.mysql.jdbc.Connection con = Connectdb.getConnection("sql12228915","sql12228915","suS2gIQEFz");
////			
////			Statement stmt=con.createStatement();  
////			ResultSet rs=stmt.executeQuery("select * from Users");  
////			while(rs.next())  
////			System.out.println(rs.getString("UserName")+"  "+rs.getString("Name")+"  "+rs.getInt("Age"));  
////			con.close(); 
////			
////			//BackMenu();
////			
////			}catch(Exception e){ System.out.println(e);}
////
////		TableView table = new TableView();
////	    table.setEditable(true);
////
////	    TableColumn userNameCol = new TableColumn("UserName");
////	    TableColumn nameCol = new TableColumn("Name");
////	    TableColumn ageCol = new TableColumn("Age");
////	            
////	    table.getColumns().addAll(userNameCol, nameCol, ageCol);
////	    
////	    StackPane root = new StackPane();
////	    root.getChildren().add(table);
////	    primaryStage.setScene(new Scene(root, 200, 250));
////	    primaryStage.show();
////	  }
////		
//	}
//
