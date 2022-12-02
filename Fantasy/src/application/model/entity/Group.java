package application.model.entity;

import java.util.ArrayList;

public class Group<T> {

	private ArrayList<T> group = new ArrayList<T>();
	
	public Group() {
		
	}
	
	public void addEntity(T t) {
		this.group.add(t);
	}
	
	public void removeEntity(T t) {
		this.group.remove(t);
	}
	
	public ArrayList<T> getGroup() {
		return this.group;
	}
}
