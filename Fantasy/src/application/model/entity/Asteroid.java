package application.model.entity;

public class Asteroid extends Entity {

	public Asteroid(String image, int width, int height, int x, int y, int n, int s, int w, int e) {
		super(image, width, height, x, y, n, s, w, e);
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
