package application.model.entity;

public class BulletEntity extends Entity {

	public BulletEntity(String image, int width, int height, int x, int y, int n, int s, int w, int e) {
		super(image, width, height, x, y, n, s, w, e);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getDirX() {
		return w + e;
	}

	@Override
	public int getDirY() {
		return n + s;
	}
}
