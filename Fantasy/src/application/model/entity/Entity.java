package application.model.entity;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Entity extends ImageView {
	
	protected boolean outOfBounds = false;
	
	protected int n = 0;
	protected int s = 0;
	protected int w = 0;
	protected int e = 0;
	
	public Entity(String image, int width, int height, int x, int y) {
		this.setImage(new Image(image, width, height, false, false));
		this.setX(x);
		this.setY(y);
	}
	
	public Entity(String image, int width, int height, int x, int y, int n, int s, int w, int e) {
		this.setImage(new Image(image, width, height, false, false));
		this.setX(x);
		this.setY(y);
		this.n = n;
		this.s = s;
		this.w = w;
		this.e = e;
	}
	
	public abstract int getDirX();
	
	public abstract int getDirY();
	
	public int getMovX() {
		return (int)(this.getX() + getDirX());
	}
	
	public int getMovY() {
		return (int)(this.getY() + getDirY());
	}
	
	public boolean getOutOfBounds() {
		return this.outOfBounds;
	}
	
	public void setOutOfBounds(boolean outOfBounds) {
		this.outOfBounds = outOfBounds;
	}
	
	public int getN() {
		return this.n;
	}
	
	public void setN(int n) {
		this.n = n;
	}
	
	public int getS() {
		return this.s;
	}
	
	public void setS(int s) {
		this.s = s;
	}
	
	public int getW() {
		return this.w;
	}
	
	public void setW(int w) {
		this.w = w;
	}
	
	public int getE() {
		return this.e;
	}
	
	public void setE(int e) {
		this.e = e;
	}
}