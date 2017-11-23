package info;

import java.util.*;

public abstract class JeuVue implements Observer{
	
	protected Jeu j;
	protected JeuController jControl;

	public JeuVue(Jeu jeu, JeuController controller) {
		this.j = jeu;
		this.jControl = controller;
		j.addObserver(this); // Connexion entre la vue et le modele
	}

	public abstract void affiche(String string) ;
}
