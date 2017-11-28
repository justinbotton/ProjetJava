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
public class Jeu extends Observable {
	private int enVie;
	private int nombreJoueur;
	private ArrayList<Hero> joueur;
	private boolean inGame = false;
	//private ArrayList<Donjon> donjons14;
	private Donjon donj;
	int donjonNum = 0;

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
		//donjons14 = new ArrayList<Donjon>();
		
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
	public Donjon getDonj() {
		return donj;
	}
	public void setDonj(Donjon donj) {
		this.donj = donj;
	}
	public int getDonjonNum() {
		return donjonNum;
	}
	public void setDonjonNum(int donjonNum) {
		this.donjonNum = donjonNum;
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
				System.out.println("---------- Création des joueurs ---------- \n");
			}
			System.out.println("Selection du personnage du joueur "+ joueur + ": ");
			System.out.println("1 : Elfe");
			System.out.println("2 : Nain");
			System.out.println("3 : Orque");
			System.out.println("4 : Humain");
		}
	}
	/**
	 * cree les donjon 1 a 4.
	 */
	public void creationDonjons() {
		int sumNiv = 0;
		for (Hero h : this.getJoueur()) {
			sumNiv += h.getNiveau();
		}
		if (donjonNum < 5 && this.getEnVie() > 0) {
			/*Donjon d = new Donjon(sumNiv);
			donjons14.add(d);*/
			donj = new Donjon(sumNiv);
			donjonNum++;
			setChanged();
	        notifyObservers();
		}
		if (donjonNum == 5) {
			donj = new Donjon("boss", sumNiv);
			setChanged();
	        notifyObservers();
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Jeu();
	}

}
