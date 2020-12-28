package views;

import java.awt.Component;
import java.util.Arrays;

import javax.swing.JFrame;

import config.Config;

@SuppressWarnings("serial")
public class Window extends JFrame {
	public Window() {
		// TODO Auto-generated constructor stub
		super("LEMMINGS GAME");
		this.setSize(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
		this.setLocation(50, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.add(new GamePanel());

		this.setResizable(false);
		this.setVisible(true);
		setEnabled(true);

	}

	@Override
	public void repaint() {
		// TODO Auto-generated method stub
		super.repaint();
		Arrays.stream(this.getComponents()).forEach(Component::repaint);
	}

}
