package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class MenuController extends Controller {

	
	private EventHandler<MouseEvent> telemetryMouseClick;
	private EventHandler<ActionEvent> launchPressed;
	private EventHandler<ActionEvent> shipPressed;
	private EventHandler<ActionEvent> abortPressed;
	
	@FXML
	private AnchorPane anchorPane;
	@FXML
	private ImageView background;
	@FXML
	private Text telemetry;
	@FXML
	private Button launch;
	@FXML
	private Button ship;
	@FXML
	private Button abort;
	
	@Override
	protected void setHandlers() {
		telemetryMouseClick = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				System.out.println("Telemetry clicked!");
			}
		};
		telemetry.addEventHandler(MouseEvent.MOUSE_CLICKED, telemetryMouseClick);
		
		launchPressed = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				setStage("Combat");
			}
		};
		launch.addEventHandler(ActionEvent.ACTION, launchPressed);
		
		shipPressed = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				setStage("Ship");
			}
		};
		ship.addEventHandler(ActionEvent.ACTION, shipPressed);
		
		abortPressed = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Platform.exit();
			}
		};
		abort.addEventHandler(ActionEvent.ACTION, abortPressed);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setHandlers();		
	}
}
