package models;

import config.Config;
import models.terrains.Case;
import models.terrains.destructibleObstacles.ExplosiveObstacle;
import models.terrains.destructibleObstacles.MagicObstacle;
import models.terrains.destructibleObstacles.SimpleDestructibleObstacle;
import models.terrains.doors.EntryDoor;
import models.terrains.doors.ExitDoor;
import models.terrains.indestructibleObstacles.FireObstacle;
import models.terrains.indestructibleObstacles.SimpleIndestructibleObstacle;
import models.terrains.indestructibleObstacles.TeleporterObstacle;

public class Plan {

	private Case[][] cases;

	public Plan() {

		int[][] map = Config.MAP;

		int height = map.length;
		int width = map[0].length;

		this.cases = new Case[height][width];

		for (int x = 0; x < cases.length; x++) {
			for (int y = 0; y < cases[0].length; y++) {
				cases[x][y] = new Case();

				if (map[x][y] == 1)
					cases[x][y].setObstacle(new EntryDoor());

				if (map[x][y] == 2)
					cases[x][y].setObstacle(new ExitDoor());

				if (map[x][y] == 3)
					cases[x][y].setObstacle(new SimpleDestructibleObstacle());
				if (map[x][y] == 4)
					cases[x][y].setObstacle(new SimpleIndestructibleObstacle());

				if (map[x][y] == 5)
					cases[x][y].setObstacle(new FireObstacle());
				if (map[x][y] == 6)
					cases[x][y].setObstacle(new MagicObstacle());
				if (map[x][y] == 7)
					cases[x][y].setObstacle(new TeleporterObstacle());
				if (map[x][y] == 8)
					cases[x][y].setObstacle(new ExplosiveObstacle());

			}
		}
	}

	public Case[][] getCases() {
		return cases;
	}

	public Case getCase(int x, int y) {
		if (x >= 0 && x < cases.length && y >= 0 && y < cases[0].length) {
			return cases[x][y];
		}
		return null;
	}

	public void moveUp(Position position) {
		int value = Math.max(0, position.getX() - 1);
		position.setX(value);
	}

	public boolean isOnSupport(Lemming lemming) {
		// TODO Auto-generated method stub
		Position position = lemming.getPosition();
		int x = position.getX();
		int y = position.getY();

		Case aCase = this.getCase(x + 1, y);
		return aCase != null && aCase.isNotEmpty();
	}

	public boolean isWall(Position position) {
		// TODO Auto-generated method stub
		if (!validCase(position.getX(), position.getY()))
			return true;
		return getCase(position.getX(), position.getY()).isNotEmpty()
				&& (!validCase(position.getX() - 1, position.getY())
						|| getCase(position.getX() - 1, position.getY()).isNotEmpty());

	}

	public boolean validCase(int x, int y) {
		return x >= 0 && x < cases.length && y >= 0 && y < cases[0].length;
	}

	public Case nextCaseOf(Position position) {
		return this.cases[position.getX()][position.getY() + 1];
	}
}
