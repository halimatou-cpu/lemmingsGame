package controllers;

import java.util.stream.Stream;

import models.Lemming;
import models.ModelContainer;
import models.terrains.Case;
import views.Window;

public class GameController {
	private final Window window;
	private final ModelContainer container;

	public GameController(Window window) {
		this.container = ModelContainer.getInstance();
		this.window = window;
	}

	public boolean alive() {

		return this.container.getLemmings().stream().map(Lemming::isActive).reduce(true, (o, n) -> o || n);
//		return true;
	}

	public void step() {
		this.controlLemmings();
		this.window.repaint();
	}

//	public void controlLemmings() {
//		Stream<Lemming> lemmings = this.container.getLemmings().stream().filter(Lemming::isActive);
//
//		lemmings.forEach(lemming -> {
//			lemming.getState().action(lemming, ModelContainer.getInstance());
//			Case aCase = container.getPlan().getCase(lemming.getPosition().getX(), lemming.getPosition().getY() + 1);
//
//			if (aCase != null && aCase.isNotEmpty()) {
//				aCase.getObstacle().action(lemming, container);
//			}
//		});
//	}
	
	 public void controlLemmings() {
	        Stream<Lemming> lemmings = this.container
	                .getLemmings().stream()
	                .filter(Lemming::isActive);


	        lemmings.forEach(lemming -> {
	            lemming.getState().action(lemming, ModelContainer.getInstance());
	            Case aCase = container.getPlan()
	                    .getCase(lemming.getPosition().getX() , lemming.getPosition().getY() + 1);

	            if (aCase != null && aCase.isNotEmpty()) {
	                aCase.getObstacle().action(lemming, container);
	            }
	            System.out.println( lemming.toString());
	        });
	    }
}
