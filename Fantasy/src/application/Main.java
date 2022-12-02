package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {
	
	public static AnchorPane anchorPane; 
	public static Scene scene;
	public static Stage stage;
	
	public static int credits = 0;
	public static int firepower = 1;
	public static int storage = 1;
	public static int engine = 2;
	public static int shield = 0;
	
	public static int score = 0;
	public static int high = 0;
	
	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;
		
		try {
			anchorPane = (AnchorPane) new FXMLLoader(getClass().getResource("view/MenuView.fxml")).load();
			scene = new Scene(anchorPane,600,800);
			
			stage.setTitle("Telemetry");
			stage.setResizable(false);
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
