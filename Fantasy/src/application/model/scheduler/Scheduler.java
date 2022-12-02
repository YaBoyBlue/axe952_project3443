package application.model.scheduler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class Scheduler {
	
	private long schedule;
	
	ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
	
	public Scheduler(long schedule) {
		this.schedule = schedule;
	}
	
	public void start() {
		this.scheduledExecutorService.scheduleAtFixedRate(this::onExecute, 0, 1000 / this.schedule, TimeUnit.MILLISECONDS);
	}
	
	public void stop() {
		this.scheduledExecutorService.shutdown();
	}
	
	protected abstract void onExecute();
}
