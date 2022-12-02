package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class ShipController extends Controller {

	private EventHandler<MouseEvent> shipPressed;
	private EventHandler<ActionEvent> firepowerPressed;
	private EventHandler<ActionEvent> storagePressed;
	private EventHandler<ActionEvent> enginePressed;
	private EventHandler<ActionEvent> shieldPressed;
	private EventHandler<ActionEvent> backPressed;
	
	@FXML
	private AnchorPane anchorPane;
	@FXML
	private ImageView background;
	@FXML
	private Text ship;
	@FXML
	private Text credits;
	@FXML
	private Button firepower;
	@FXML
	private Button storage;
	@FXML
	private Button engine;
	@FXML
	private Button shield;
	@FXML
	private Button back;
	
	@Override
	protected void setHandlers() {
		shipPressed = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				Main.credits += 100;
				credits.setText("Credits: " + Main.credits);
			}
		};
		ship.addEventHandler(MouseEvent.MOUSE_CLICKED, shipPressed);
		
		firepowerPressed = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (Main.credits >= 100) {
					if (Main.firepower < 4) {
						Main.firepower += 1;
						Main.credits -= 100;
						credits.setText("Credits: " + Main.credits);
						
						if (Main.firepower < 4) {
							firepower.setText("Upgrade firepower to " + (Main.firepower + 1) + " for 100 credits!");
						} else {
							firepower.setText("Firepower is at max level!");
						}
					}
				}
			}
		};
		firepower.addEventHandler(ActionEvent.ACTION, firepowerPressed);
		
		storagePressed = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (Main.credits >= 100) {
					if (Main.storage < 3) {
						Main.storage += 1;
						Main.credits -= 100;
						credits.setText("Credits: " + Main.credits);
						
						if (Main.storage < 3) {
							storage.setText("Upgrade storage to " + (Main.storage + 1) + " for 100 credits!");
						} else {
							storage.setText("Storage is at max level!");
						}
					}
				}
			}
		};
		storage.addEventHandler(ActionEvent.ACTION, storagePressed);
		
		enginePressed = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (Main.credits >= 100) {
					if (Main.engine < 3) {
						Main.engine += 1;
						Main.credits -= 100;
						credits.setText("Credits: " + Main.credits);
						
						if (Main.engine < 3) {
							engine.setText("Upgrade engine to " + (Main.engine + 1) + " for 100 credits!");
						} else {
							engine.setText("Engine is at max level!");
						}
					}
				}
			}
		};
		engine.addEventHandler(ActionEvent.ACTION, enginePressed);
		
		shieldPressed = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if (Main.credits >= 100) {
					if (Main.shield < 2) {
						Main.shield += 1;
						Main.credits -= 100;
						credits.setText("Credits: " + Main.credits);
						
						if (Main.shield < 2) {
							shield.setText("Upgrade shield to " + (Main.shield + 1) + " for 100 credits!");
						} else {
							shield.setText("Shield is at max level!");
						}
					}
				}
			}
		};
		shield.addEventHandler(ActionEvent.ACTION, shieldPressed);
		
		backPressed = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				setStage("Menu");
			}
		};
		back.addEventHandler(ActionEvent.ACTION, backPressed);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setHandlers();
		
		credits.setText("Credits: " + Main.credits);
		
		if (Main.firepower < 4) {
			firepower.setText("Upgrade firepower to " + (Main.firepower + 1) + " for 100 credits!");
		} else {
			firepower.setText("Firepower is at max level!");
		}
		
		if (Main.storage < 3) {
			storage.setText("Upgrade storage to " + (Main.storage + 1) + " for 100 credits!");
		} else {
			storage.setText("Storage is at max level!");
		}
		
		if (Main.engine < 3) {
			engine.setText("Upgrade engine to " + (Main.engine + 1) + " for 100 credits!");
		} else {
			engine.setText("Engine is at max level!");
		}
		
		if (Main.shield < 2) {
			shield.setText("Upgrade shield to " + (Main.shield + 1) + " for 100 credits!");
		} else {
			shield.setText("Shield is at max level!");
		}
	}
}
