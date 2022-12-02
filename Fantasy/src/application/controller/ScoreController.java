package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ScoreController extends Controller{
	
	private EventHandler<ActionEvent> menuPressed;
	
	@FXML
	private Label high;
	@FXML
	private Label score;
	@FXML
	private Button menu;
	
	@Override
	protected void setHandlers() {
		menuPressed = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				setStage("menu");
			}
		};
		menu.addEventHandler(ActionEvent.ACTION, menuPressed);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setHandlers();
		
		if (Main.score > Main.high) {
			Main.high = Main.score;
		}
		
		high.setText("Highscore: " + Main.high);
		score.setText("Score: " + Main.score);
	}
}
