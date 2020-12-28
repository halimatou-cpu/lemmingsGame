package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;

import config.Config;
import models.terrains.doors.EntryDoor;

public class ModelContainer {

	private static ModelContainer instance;
	private Plan plan;
	private final List<Lemming> lemmings;

	private ModelContainer() {
		this.plan = new Plan();
		this.lemmings = new ArrayList<>();
		Position position ;
//		Position position = EntryDoor.getPosition();
		for (int count = 0; count < Config.LEMMINGS_NUMBER; count++) {
			position = new Position(count + 3, 3);
			lemmings.add(new Lemming(position, count % 2 == 0 ? Direction.RIGHT : Direction.LEFT));
//			position = new Position(position.getX(), position.getY() + 1);
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

//		for (Lemming lemming : getLemmings()) {
//			Position position = lemming.getPosition();
//			if (lemming.isActive() && ((x >= position.getX() - 2) && (x <= position.getX() + 2))
////					&& ((y >= position.getY() - 2) && (y <= position.getY() + 2)))
//					&& ((y >= position.getY() ) && (y <= position.getY() )))
//				return lemming;
//		}
//		return null;
//	}
		BiPredicate<Integer, Integer> predicate = (value, pos) -> value >= pos - 2 && value <= pos + 2;

		Optional<Lemming> result = getLemmings().stream().filter(Lemming::isActive).filter(lemming -> {
			Position position = lemming.getPosition();
			return predicate.test(x, position.getX()) && predicate.test(y, position.getY());
		}).findFirst();

		return result.orElse(null);
	}

}
