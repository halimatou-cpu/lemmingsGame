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

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				cases[y][x] = new Case();

				if (map[y][x] == 1)
					cases[y][x].setObstacle(new EntryDoor());

				if (map[y][x] == 2)
					cases[y][x].setObstacle(new ExitDoor());

				if (map[y][x] == 3)
					cases[y][x].setObstacle(new SimpleDestructibleObstacle());
				if (map[y][x] == 4)
					cases[y][x].setObstacle(new SimpleIndestructibleObstacle());

				if (map[y][x] == 5)
					cases[y][x].setObstacle(new FireObstacle());
				if (map[y][x] == 6)
					cases[y][x].setObstacle(new MagicObstacle());
				if (map[y][x] == 7)
					cases[y][x].setObstacle(new TeleporterObstacle());
				if (map[y][x] == 8)
					cases[y][x].setObstacle(new ExplosiveObstacle());

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

}
