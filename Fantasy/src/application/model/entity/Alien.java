package application.model.entity;

public class Alien extends Entity {

	public Alien(String image, int width, int height, int x, int y) {
		super(image, width, height, x, y);
	}

	
	
	@Override
	public int getDirX() {
		return 0;
	}

	@Override
	public int getDirY() {
		return 0;
	}
}
