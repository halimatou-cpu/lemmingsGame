package models;

import java.util.ArrayList;
import java.util.List;

import config.Config;
import models.terrains.doors.EntryDoor;

public class ModelContainer {

	private static ModelContainer instance;
	private Plan plan;
	private final List<Lemming> lemmings;

	private ModelContainer() {
		this.plan = new Plan();
		this.lemmings = new ArrayList<>();
//		Position position ;
		Position position = EntryDoor.getPosition();
		for (int count = 0; count < Config.LEMMINGS_NUMBER; count++) {
//			position = new Position(count + 3, 3);
			lemmings.add(new Lemming(position, count % 2 == 0 ? Direction.RIGHT : Direction.LEFT));
			position = new Position(position.getX() + 1, position.getY());
		}
	}

	public Plan getPlan() {
		return plan;
	}

	public List<Lemming> getLemmings() {
		return lemmings;
	}

	public static ModelContainer getInstance() {
		if (instance == null) {
			instance = new ModelContainer();
		}
		return instance;
	}

	public Lemming findLemmingAt(int x, int y) {
		
		for (Lemming lemming : getLemmings()) {
			Position position = lemming.getPosition();
			if (lemming.isActive()
					&& ((x>=position.getX() - 2) && (x<=position.getX() +2)) 
					&& ((y>=position.getY() - 2) && (y<=position.getY() +2)))			
				return lemming;
		}
		return null;
	}

}
