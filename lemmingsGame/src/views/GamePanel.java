package views;

import java.awt.Font;

import javax.swing.JButton;

import config.Config;


//import models.ModelContainer;
//import views.panels.GameMouseListener;

public class GamePanel extends AbstractPanel {
	public GamePanel() {
		// TODO Auto-generated constructor stub
		super();
//		this.container = ModelContainer.getInstance();
		this.createButtons();
		this.addMouseListener(new GameMouseListener(this));
	}

	private void createButtons() {
		this.add(this.createButton("Marcheur", 1));
		this.add(this.createButton("Charpentier", 2));
	}

	private JButton createButton(String text, final int index) {
		JButton button = new JButton(text);
		final int height = 50;

		button.setLocation(Config.MAIN_COMPONENT_WIDTH, height * (index - 1));
		button.setSize(Config.MENU_WIDTH, height);
		button.setFont(new Font(Font.DIALOG, Font.PLAIN | Font.BOLD, 10));
		button.setFocusPainted(false);

//		button.addActionListener(actionEvent -> {
//			if (index == 1)
//				state = new WalkerState();
//			if (index == 2)
//				state = new CarpenterState();
//		});

		return button;
	}
}
