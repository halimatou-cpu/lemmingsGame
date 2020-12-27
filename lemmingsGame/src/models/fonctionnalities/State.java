package models.fonctionnalities;

import models.Lemming;
import models.ModelContainer;

public abstract class State {
	
	public abstract void action (Lemming lemming, ModelContainer container);
}
