package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.entity.PlayerEntity;
import application.model.handler.CombatHandler;
import application.model.scheduler.CombatScheduler;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class CombatController extends Controller {
	
	public PlayerEntity playerEntity;

	private CombatHandler handler = new CombatHandler(this);
	private CombatScheduler scheduler = new CombatScheduler(this, 60);
	
	private EventHandler<KeyEvent> keyPressed;
	private EventHandler<KeyEvent> keyReleased;
	
	@FXML
	private AnchorPane anchorPane;
	@FXML
	private Label stats;
	
	public CombatHandler getHandler() {
		return this.handler;
	}
	
	public CombatScheduler getScheduler() {
		return this.scheduler;
	}
	
	public AnchorPane getAnchorPane() {
		return this.anchorPane;
	}
	
	public Label getStats() {
		return this.stats;
	}
	
	@Override
	protected void setHandlers() {
		keyPressed = new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				if (getKeyState(e.getCode()))
					return;
				
				setKeyState(e.getCode(), true);
			}
		};
		Main.stage.addEventHandler(KeyEvent.KEY_PRESSED, keyPressed);
		
		keyReleased = new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				setKeyState(e.getCode(), false);
			}
		};
		Main.stage.addEventHandler(KeyEvent.KEY_RELEASED, keyReleased);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setHandlers();
		
		playerEntity = new PlayerEntity("data/images/game/Player.png", 36, 36, 300 - 18, 600 - 26);
		anchorPane.getChildren().add(playerEntity);
		
		scheduler.start();
		
		Main.score = 0;
	}
}
