package models.fonctionnalities;

import models.Lemming;
import models.ModelContainer;
import models.Position;

public class WalkerState extends State {
	private int counter = 0;

	@Override
	public void action(Lemming lemming, ModelContainer container) {
		Position position = lemming.getPosition();
		// TODO Auto-generated method stub
		if (!container.getPlan().isOnSupport(lemming)) {
//			position.setX(position.getX() + 1);
			container.getPlan().moveDown(position);

			if (counter++ > 3)
				lemming.setActive(false);

			return;
		}

		this.walk(lemming, container);
	}

	public void walk(Lemming lemming, ModelContainer container) {
		Position position = lemming.getPosition();

//		if (position.getY() <= 0 || position.getY() >= container.getPlan().getCases()[0].length
//				|| container.getPlan().isWall(position))
//			lemming.switchDirection();
////		 if (position.getX() <= 0 ||
////	                position.getX() >= container.getPlan().getCases()[0].length ||
////	                container.getPlan().isWall(position)
////	        ) lemming.switchDirection();
//
//		int seed = (lemming.hasDirectionLeft() ? -1 : 1);
//		Position nextCasePosition = new Position(position.getX() , position.getY() + seed);
//
//		if (container.getPlan().nextCaseOf(nextCasePosition).isEmpty()) {
//			position.setY(lemming.getPosition().getY() + seed);
//		} else {
//		container.getPlan().moveUp(position);
//		position.setY(lemming.getPosition().getY() + seed);
//		this.counter = 0;
//		}
		Position nextPosition = new Position(position.getX(), position.getY() + 1);
		if (container.getPlan().isWall(nextPosition)) lemming.switchDirection();
		int seed = (lemming.hasDirectionLeft() ? -1:1);
		Position nextCasePosition = new Position(position.getX(), position.getY() + seed);
//		if(container.getPlan().nextCaseOf(nextCasePosition).isEmpty())
//		{
//			position.setY(nextCasePosition.getY());
			if(seed > 0) container.getPlan().moveRight(position) ;
			else container.getPlan().moveLeft(position);
//		}else {
//			container.getPlan().moveUp(position);
//			position.setY(nextCasePosition.getY());
//		}
	}

}
