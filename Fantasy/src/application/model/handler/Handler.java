package application.model.handler;

import java.util.HashMap;

import javafx.scene.input.KeyCode;

public abstract class Handler {

	private HashMap<KeyCode, Boolean> keyState = new HashMap<KeyCode, Boolean>();	
	
	public Handler() {
		for (KeyCode keyCode : KeyCode.values()) {
			this.keyState.put(keyCode, false);
		}
	}
	
	public boolean getKeyState(KeyCode keyCode) {
		return this.keyState.get(keyCode);
	}
	
	public void setKeyState(KeyCode keyCode, boolean state) {
		this.keyState.put(keyCode, state);
	}
}
