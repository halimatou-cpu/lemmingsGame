package models.fonctionnalities;

import models.Lemming;
import models.ModelContainer;

public class CarpenterState extends State {
    private int counter;

    public CarpenterState() {
        this.counter = 0;
    }


    @Override
    public void action(Lemming lemming, ModelContainer container) {
        if (counter >= 5) return;

        counter++;
//
//        Obstacle obstacle = new SimpleDestructibleObstacle();
//
//        Position position = lemming.getPosition();
//        Position obsPosition;
//
//        if (lemming.getDirection().isLeft()) {
//            obsPosition = new Position(position.getY(), position.getX() - 1);
//            container.getPlan().putObstacle(obstacle, obsPosition);
//            container.getPlan().moveLeft(position);
//        } else {
//            obsPosition = new Position(position.getY(), position.getX() + 1);
//            container.getPlan().putObstacle(obstacle, obsPosition);
//            container.getPlan().moveRight(position);
//        }
//
//        container.getPlan().moveUp(position);
    }
}
