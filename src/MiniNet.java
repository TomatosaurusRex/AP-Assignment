

import java.io.Console;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextAreaBuilder;
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
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;



@SuppressWarnings("deprecation")
public class MiniNet extends Application{

	String center;
	
	public static void main(String[] args) {
		
		
		launch(args);

	}
	
	Stage window;
	Scene scene1, scene2;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		window = primaryStage;
		BorderPane border = new BorderPane();
		HBox hbox = addHBox();
		border.setTop(hbox);
		border.setLeft(addVBox());
		
		Scene scene = new Scene(border,800,600);
		window.setTitle("Mini Net");
		window.setScene(scene);
		window.show();
	}
	
	private Node addVBox() throws Exception {
		
		Button btn1 = new Button("List/Add users");
		Button btn3 = new Button("Lookup Friends");
		Button btn4 = new Button("Check Status");
		Button btn5 = new Button("Update Friends List");
		Button btn6 = new Button("Update Details");
		Button btn7 = new Button("Update Status");
		Button btn8 = new Button("Delete User");
		Button close = new Button("Exit");
		
		btn1.setOnAction (e -> window.setScene(scene2));
	    ListUsers l1 = new ListUsers();
			scene2 = new Scene(l1.listUsers(), 800,600);
		btn3.setOnAction(e -> {try {
			FriendLookup u = new FriendLookup();
		} catch (Exception e1) {
			e1.printStackTrace();
		}});
		btn4.setOnAction(e -> {try {
			CheckStatus u = new CheckStatus();
		} catch (Exception e1) {
			e1.printStackTrace();
		}});
		btn5.setOnAction(e -> {try {
			AddFriends u = new AddFriends();
		} catch (Exception e1) {
			e1.printStackTrace();
		}});
		btn6.setOnAction(e -> {try {
			UpdateUser u = new UpdateUser();
		} catch (Exception e1) {
			e1.printStackTrace();
		}});
		btn7.setOnAction(e -> {try {
			UpdateStatus u = new UpdateStatus();
		} catch (Exception e1) {
			e1.printStackTrace();
		}});
		btn8.setOnAction(e -> {try {
			DeleteUser u = new DeleteUser();
		} catch (Exception e1) {
			e1.printStackTrace();
		}});
		close.setOnAction(e -> System.exit(0));
		
		btn1.setMaxWidth(Double.MAX_VALUE);
		btn3.setMaxWidth(Double.MAX_VALUE);
		btn4.setMaxWidth(Double.MAX_VALUE);
		btn5.setMaxWidth(Double.MAX_VALUE);
		btn6.setMaxWidth(Double.MAX_VALUE);
		btn7.setMaxWidth(Double.MAX_VALUE);
		btn8.setMaxWidth(Double.MAX_VALUE);
		close.setMaxWidth(Double.MAX_VALUE);
		
		VBox addVBox = new VBox(2);
		addVBox.getChildren().addAll(btn1,btn3,btn4,btn5,btn6,btn7,btn8,close);
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
}
