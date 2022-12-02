package application.model.entity;

public class PlayerEntity extends Entity {

	public PlayerEntity(String image, int width, int height, int x, int y) {
		super(image, width, height, x, y);
	}

	@Override
	public int getDirX() {
		return (w + e) != 0 ? ((w + e) < 0 ? (this.getX() - 1 < 0 ? 0 : -1) : (this.getX() + 37 > 600 ? 0 : 1)) : 0;
	}

	@Override
	public int getDirY() {
		return (n + s) != 0 ? ((n + s) < 0 ? (this.getY() - 1 < 0 ? 0 : -1) : (this.getY() + 27 > 800 ? 0 : 1)) : 0;
	}
}