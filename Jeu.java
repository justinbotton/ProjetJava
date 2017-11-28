/**
 * 
 */
package info;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.Icon;
import javax.swing.JOptionPane;

/**
 * @author louis & justin & philemon
 *
 */
public class Jeu extends Observable{
	private int enVie;
	private int nombreJoueur;
	private ArrayList<Hero> joueur;
	private boolean inGame = false;

	/**
	 * 
	 */
	public Jeu() {
		/*Hero h = new Hero();
		String[] args = null;
		h.main(args);*/
		this.enVie = 1;
		//this.nombreJoueur = 1;
		joueur = new ArrayList<Hero>();
		Donjon d;
		Donjon boss;
		int i = 4;
		while (i > 0 && this.getEnVie() > 0) {
			d = new Donjon();
			String appelVagues;
			appelVagues = "oui";
			//d.main(appelVagues);
			d.afficheMob(appelVagues);
			i--;
			// + tous le reste a faire dans un donjon (resolution combat...)
		}
		//j.setEnVie(0); //exemple si les heros meurent avant le boss
		// => donjon boss ne se fait pas
		if (this.getEnVie() > 0) {
			int sumNiveau = 0;
			for (Hero h : this.getJoueur()) {
				if (h.getVie() > 0) {
					sumNiveau = sumNiveau + h.getNiveau();
				}
			}
			boss = new Donjon("boss", sumNiveau);
			String appelBoss;
			appelBoss = "BOSS";
			boss.afficheMob(appelBoss);
			//System.out.println(boss.getBoss().getClasse());
		}
	}

	public int getEnVie() {
		return enVie;
	}
	public void setEnVie(int enVie) {
		this.enVie = enVie;
	}
	public int getNombreJoueur() {
		return nombreJoueur;
	}
	public void setNombreJoueur(int nombreJoueur) {
		this.nombreJoueur = nombreJoueur;
	}
	public ArrayList<Hero> getJoueur() {
		return joueur;
	}
	public void setJoueur(ArrayList<Hero> joueur) {
		this.joueur = joueur;
	}
	public void ajoutJoueur(Hero h) {
		this.joueur.add(h);
	}
	
	public void choixPerso(int i) {
		switch(i){
			case 1 :
				Hero elfe = new Hero("elfe");
				this.ajoutJoueur(elfe);
				setChanged();
		        notifyObservers();
				break;
			case 2 : 
				Hero nain = new Hero("nain");
				this.ajoutJoueur(nain);
				setChanged();
		        notifyObservers();
				break;
			case 3 : 
				Hero orque = new Hero("nain");
				this.ajoutJoueur(orque);
				setChanged();
		        notifyObservers();
				break;
			case 4 : 
				Hero humain = new Hero("nain");
				this.ajoutJoueur(humain);
				setChanged();
		        notifyObservers();
				break;
			default :
				Hero humain2 = new Hero("nain");
				this.ajoutJoueur(humain2);
				setChanged();
		        notifyObservers();
		}
	}

	public void printMenuText(int i, int joueur){
		if (i == 1 && !inGame) {
			System.out.println("1 : Jouer");
			System.out.println("0 : Quitter");
			System.out.println("Pour quitter a tout moment, appuyer sur 0.");
			inGame = true;
			
		}
		else if (i == 2) {
			if (joueur == 1) {
				System.out.println(".......... Création des joueurs ..........");
			}
			System.out.println("choix personnage joueur "+ joueur + ": ");
			System.out.println("1 : Elfe");
			System.out.println("2 : Nain");
			System.out.println("3 : Orque");
			System.out.println("4 : Humain");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Jeu();
	}

}
