package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;

import config.Config;
import models.Direction;
import models.Lemming;
import models.ModelContainer;
import models.Position;
import models.fonctionnalities.State;

//import models.ModelContainer;
//import views.panels.GameMouseListener;

public class GamePanel extends AbstractPanel {

	private State state;
	private final ModelContainer container;

	String marcheur = "MARCHEUR";
	String bloqueur = "BLOQUEUR";
	String tunnelier = "TUNNELIER";
	String foreur = "FOREUR";
	String bombeur = "BOMBEUR";
	String charpentier = "CHARPENTIER";
	String grimpeur = "GRIMPEUR";
	String parachutiste = "PARACHUTISTE";

	public GamePanel() {
		// TODO Auto-generated constructor stub
		super();
		this.container = ModelContainer.getInstance();
		this.createButtons();
		this.addMouseListener(new GameMouseListener(this));
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		graphics.setColor(Color.DARK_GRAY);
		graphics.fillRect(0, 0, Config.MAIN_COMPONENT_WIDTH, Config.MAIN_COMPONENT_HEIGHT);

//		this.printCases(graphics);
		this.printLemmings(graphics);
	}

	private void printLemmings(Graphics graphics) {
//		(new Lemming(new Position(12,12), Direction.RIGHT)).print(graphics, new Position(12, 12));
		for (Lemming lemming : this.container.getLemmings()) {
			if (lemming.isActive())
				lemming.print(graphics, lemming.getPosition());
		}
//		this.container.getLemmings().stream()
//        .filter(Lemming::isActive)
//        .forEach(lemming -> lemming.print(graphics, lemming.getPosition()));
	}

	private void createButtons() {
		this.add(this.createButton(marcheur, 1));
		this.add(this.createButton(bloqueur, 2));
		this.add(this.createButton(tunnelier, 3));
		this.add(this.createButton(foreur, 4));
		this.add(this.createButton(bombeur, 5));
		this.add(this.createButton(charpentier, 6));
		this.add(this.createButton(grimpeur, 7));
		this.add(this.createButton(parachutiste, 8));
	}

	private JButton createButton(String text, final int index) {
		JButton button = new JButton(text);
		final int height = 50;

		button.setLocation(Config.MAIN_COMPONENT_WIDTH, height * (index - 1));
		button.setSize(Config.MENU_WIDTH, height);
		button.setFont(new Font(Font.DIALOG, Font.PLAIN | Font.BOLD, 10));
		button.setFocusPainted(false);

		// pour racccourcir ceci, faire une methode externe like "actionsetter(int
		// index), then un match with"

//		button.addActionListener(actionEvent -> {
//			if (index == 1)
//				state = new WalkerState();
//			if (index == 2)
//				state = new CarpenterState();
//		});

		return button;
	}

	public void setCurrentLemming(Lemming lemming) {
		// TODO Auto-generated method stub

	}
}
