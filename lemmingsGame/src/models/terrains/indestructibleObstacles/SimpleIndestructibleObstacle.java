package models.terrains.indestructibleObstacles;

import java.awt.Color;
import java.awt.Graphics;

import config.Config;
import models.Lemming;
import models.ModelContainer;
import models.Position;
import models.terrains.Obstacle;

public class SimpleIndestructibleObstacle extends Obstacle {

	@Override
	public void action(Lemming lemming, ModelContainer container) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDestructible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void print(Graphics graphics, Position position) {
		graphics.setColor(Color.BLACK);
		graphics.fillRect(position.getX() * Config.SCALE, position.getY() * Config.SCALE, Config.SCALE, Config.SCALE);
	}

}
