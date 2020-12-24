package views;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import config.Config;
import models.Lemming;
//import models.ModelContainer;

public class GameMouseListener implements MouseListener {

	private final GamePanel gamePanel;

	public GameMouseListener(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void mouseClicked(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub
//		Lemming lemming = ModelContainer.getInstance().findLemmingAt(mouseEvent.getX() / Config.SCALE,
//				mouseEvent.getY() / Config.SCALE);
//		if (lemming != null) {
//			this.gamePanel.setCurrentLemming(lemming);
//		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
