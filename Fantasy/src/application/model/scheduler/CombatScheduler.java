package application.model.scheduler;

import application.controller.CombatController;

public class CombatScheduler extends Scheduler {

	private CombatController controller;
	
	public CombatScheduler(CombatController controller, long schedule) {
		super(schedule);
		this.controller = controller;
	}

	@Override
	protected void onExecute() {
		controller.getHandler().tick();
		controller.getHandler().handleKeys();
		controller.getHandler().handleMovement();
		controller.getHandler().handleBullets();
		controller.getHandler().handleAliens();
	}
}
