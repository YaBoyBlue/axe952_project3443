package application.controller;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import application.Main;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

public abstract class Controller implements Initializable {
	
	private int mouseX;
	private int mouseY;
	
	private HashMap<KeyCode, Boolean> keyState = new HashMap<KeyCode, Boolean>();
	
	public Controller() {
		for (KeyCode keyCode : KeyCode.values()) {
			this.keyState.put(keyCode, false);
		}
	}
	
	public int getMouseX() {
		return this.mouseX;
	}
	
	public void setMouseX(int mouseX) {
		this.mouseX = mouseX;
	}
	
	public int getMouseY() {
		return this.mouseY;
	}
	
	public void setMouseY(int mouseY) {
		this.mouseY = mouseY;
	}
	
	public boolean getKeyState(KeyCode keyCode) {
		return this.keyState.get(keyCode);
	}
	
	public void setKeyState(KeyCode keyCode, boolean state) {
		this.keyState.put(keyCode, state);
	}
	
	public void addEntity(AnchorPane anchorPane, Node node) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				anchorPane.getChildren().add(node);				
			}
			
		});
	}
	
	public void removeEntity(AnchorPane anchorPane, Node node) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				anchorPane.getChildren().remove(node);				
			}
			
		});
	}
	
	public void setStage(String fxml) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				try {
					Main.anchorPane = (AnchorPane) new FXMLLoader(getClass().getResource("../view/" + fxml + "View.fxml")).load();
					Main.scene = new Scene(Main.anchorPane,600,800);
					
					Main.stage.setScene(Main.scene);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	protected abstract void setHandlers();
	public abstract void initialize(URL location, ResourceBundle resources);
}