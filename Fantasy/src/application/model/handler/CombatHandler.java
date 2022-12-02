package application.model.handler;

import java.util.ArrayList;

import application.Main;
import application.controller.CombatController;
import application.model.entity.Alien;
import application.model.entity.BulletEntity;
import application.model.entity.Group;
import javafx.scene.input.KeyCode;

public class CombatHandler extends Handler {

	private CombatController controller;
	
	private int shield = Main.shield;
	private int rechargeShield = 0;
	
	private int storage = 5 * Main.storage;
	private int refillStorage = 0;
	
	private ArrayList<BulletEntity> bullets = new ArrayList<BulletEntity>();

	private Group<Alien> aliens = new Group<Alien>();
	private int alienSpawn = 0;
	boolean spawnable = true;
	
	public CombatHandler(CombatController controller) {
		this.controller = controller;
	}
	
	public void tick() {
		alienSpawn++;
		rechargeShield++;
		refillStorage++;
		
		if (alienSpawn >= 90) {
			alienSpawn = 0;
			spawnable = true;
		}
		
		if (rechargeShield >= 240) {	
			if (shield < Main.shield) {
				shield++;
			}
			rechargeShield = 0;
		}
		
		if (refillStorage >= 45) {
			if (storage < 5 * Main.storage) {
				storage++;
			}
			refillStorage = 0;
		}
	}
	
	public void handleKeys() {
		if (controller.getKeyState(KeyCode.ESCAPE)) {
			controller.getScheduler().stop();
			controller.setStage("Menu");
		}
		
		if (controller.getKeyState(KeyCode.W) != getKeyState(KeyCode.W)) {
			if (controller.getKeyState(KeyCode.W)) {
				controller.playerEntity.setN(-1);
				setKeyState(KeyCode.W, true);
			} else {
				controller.playerEntity.setN(0);
				setKeyState(KeyCode.W, false);
			}
		}
		
		if (controller.getKeyState(KeyCode.S) != getKeyState(KeyCode.S)) {
			if (controller.getKeyState(KeyCode.S)) {
				controller.playerEntity.setS(1);
				setKeyState(KeyCode.S, true);
			} else {
				controller.playerEntity.setS(0);
				setKeyState(KeyCode.S, false);
			}
		}
		
		if (controller.getKeyState(KeyCode.A) != getKeyState(KeyCode.A)) {
			if (controller.getKeyState(KeyCode.A)) {
				controller.playerEntity.setW(-1);
				setKeyState(KeyCode.A, true);
			} else {
				controller.playerEntity.setW(0);
				setKeyState(KeyCode.A, false);
			}
		}
		
		if (controller.getKeyState(KeyCode.D) != getKeyState(KeyCode.D)) {
			if (controller.getKeyState(KeyCode.D)) {
				controller.playerEntity.setE(1);
				setKeyState(KeyCode.D, true);
			} else {
				controller.playerEntity.setE(0);
				setKeyState(KeyCode.D, false);
			}
		}
		
		if (controller.getKeyState(KeyCode.SPACE) != getKeyState(KeyCode.SPACE)) {
			if (storage > 0) {
				if (controller.getKeyState(KeyCode.SPACE)) {
					
					if (Main.firepower >= 1) {
						BulletEntity bullet1 = new BulletEntity("data/images/game/Bullet.png", 6, 6, (int)controller.playerEntity.getX() + 17, (int)controller.playerEntity.getY(), -1, 0, 0, 0);
						controller.addEntity(controller.getAnchorPane(), bullet1);
						bullets.add(bullet1);
					}
					
					if (Main.firepower >= 2) {
						BulletEntity bullet1 = new BulletEntity("data/images/game/Bullet.png", 6, 6, (int)controller.playerEntity.getX() + 17, (int)controller.playerEntity.getY(), 0, 1, 0, 0);
						controller.addEntity(controller.getAnchorPane(), bullet1);
						bullets.add(bullet1);
					}
					
					if (Main.firepower >= 3) {
						BulletEntity bullet1 = new BulletEntity("data/images/game/Bullet.png", 6, 6, (int)controller.playerEntity.getX() + 17, (int)controller.playerEntity.getY(), 0, 0, -1, 0);
						controller.addEntity(controller.getAnchorPane(), bullet1);
						bullets.add(bullet1);
					}
					
					if (Main.firepower >= 4) {
						BulletEntity bullet1 = new BulletEntity("data/images/game/Bullet.png", 6, 6, (int)controller.playerEntity.getX() + 17, (int)controller.playerEntity.getY(), 0, 0, 0, 1);
						controller.addEntity(controller.getAnchorPane(), bullet1);
						bullets.add(bullet1);
					}
					
					storage--;
					
					setKeyState(KeyCode.SPACE, true);
				} else {
					setKeyState(KeyCode.SPACE, false);
				}
			}
		}
	}
	
	public void handleMovement() {
		for (int i = 0; i < Main.engine; i++) {
			ArrayList<Alien> delete = new ArrayList<Alien>();
			
			controller.playerEntity.setX(controller.playerEntity.getMovX());
			controller.playerEntity.setY(controller.playerEntity.getMovY());
			
			
			int pleft = (int)controller.playerEntity.getX();
			int ptop = (int)controller.playerEntity.getY();
			int pright = pleft + 35;
			int pbottom = ptop + 35;
			
			for (Alien alien : aliens.getGroup()) {
				int aleft = (int)alien.getX();
				int atop = (int)alien.getY();
				int aright = aleft + 41;
				int abottom = atop + 32;
				
				//poor mans collision
				if (((aleft > pleft && aleft < pright) && (atop > ptop && atop < pbottom)) || //top left
					((aright > pleft && aright < pright) && (atop > ptop && atop < pbottom)) || //top right
					((aleft > pleft && aleft < pright) && (abottom > ptop && abottom < pbottom)) || //bottom left
					((aright > pleft && aright < pright) && (abottom > ptop && abottom < pbottom))) { //bottom right
					if (shield > 0) {
						delete.add(alien);
					} else {
						controller.getScheduler().stop();
						controller.setStage("Score");
					}
				}
			}
			
			for (Alien alien : delete) {
				aliens.getGroup().remove(alien);
				controller.removeEntity(controller.getAnchorPane(), alien);
				shield--;
				Main.credits += 10;
				Main.score += 1;
			}
		}
	}
	
	public void handleBullets() {
		ArrayList<BulletEntity> delete = new ArrayList<BulletEntity>();
		
		for (int i = 0; i < 4; i++) {
			for (BulletEntity bullet : bullets) {
				bullet.setX(bullet.getMovX());
				bullet.setY(bullet.getMovY());
				
				if (bullet.getX() < 0 || bullet.getX() > 600 || bullet.getY() < 0 || bullet.getY() > 800) {
					if (!delete.contains(bullet)) {
						delete.add(bullet);
					}
				}
			}
			
			for (BulletEntity bullet : delete) {
				bullets.remove(bullet);
				controller.removeEntity(controller.getAnchorPane(), bullet);
			}
		}
	}
	
	public void handleAliens() {
		for (Alien alien : aliens.getGroup()) {
			if (alien.getX() < controller.playerEntity.getX()) {
				alien.setX(alien.getX() + 1);
			} else {
				alien.setX(alien.getX() - 1);
			}
			
			if (alien.getY() < controller.playerEntity.getY()) {
				alien.setY(alien.getY() + 1);
			} else {
				alien.setY(alien.getY() - 1);
			}
		}
		
		for (int i = 0; i < aliens.getGroup().size(); i++) {
			Alien a = aliens.getGroup().get(i);
			int ax1 = (int)a.getX();
			int ax2 = (int)(ax1 + 41);
			int ay1 = (int)a.getY();
			int ay2 = (int)(ay1 + 32);
			
			for (int j = 0; j < bullets.size(); j++) {
				BulletEntity b = bullets.get(j);
				int bx = (int)b.getX();
				int by = (int)b.getY();
				
				if ((bx >= ax1 && bx <= ax2) && (by >= ay1 && by <= ay2)) {
					bullets.remove(b);
					aliens.removeEntity(a);
					controller.removeEntity(controller.getAnchorPane(), a);
					controller.removeEntity(controller.getAnchorPane(), b);
					
					Main.credits += 10;
					
					Main.score += 1;
					
					i--;
					j = bullets.size();
				}
			}
		}
		
		if (spawnable) {
			Alien alien2 = new Alien("data/images/game/Alien.png", 42, 33, (int)Math.floor(Math.random() * 600), (int)Math.floor(Math.random() * 600));
			aliens.addEntity(alien2);
			controller.addEntity(controller.getAnchorPane(), alien2);
			
			spawnable = false;
		}
	}
}
