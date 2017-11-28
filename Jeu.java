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
		this.enVie = 2;
		this.nombreJoueur = 2;
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
	 * @param vagueNum > 0 & <=3.
	 * @param choixMob >0 & <= 2 pour vague1, <= 3 pour vague2, <= 5 pour vague3
	 * @param joueurNum est le numero du joueur 1 || 2
	 */
	public String combat(int vagueNum,int choixMob, int joueurNum) {
		if (vagueNum == 1) {
			//Hero he = this.joueur.get(joueurNum-1);
			//Ennemi e = donj.getVague1()[choixMob - 1];
			this.joueur.get(joueurNum-1).attaque(donj.getVague1()[choixMob - 1]);
			setChanged();
	        notifyObservers();
	        return donj.getVague1()[choixMob - 1].getEtat();
		}
		return "d";
	}
	public void afficheVague(int vagueNum) {
		if (vagueNum == 1) {
			Ennemi[] vag = this.getDonj().getVague1();
			System.out.println("1 : " + vag[0].getClasse());
			System.out.println("2 : " + vag[1].getClasse());
			
		}
		if (vagueNum == 2) {
			Ennemi[] vag = this.getDonj().getVague2();
			System.out.println("1 : " + vag[0].getClasse());
			System.out.println("2 : " + vag[1].getClasse());
			System.out.println("3 : " + vag[2].getClasse());
			
		}
		if (vagueNum == 2) {
			Ennemi[] vag = this.getDonj().getVague3();
			System.out.println("1 : " + vag[0].getClasse());
			System.out.println("2 : " + vag[1].getClasse());
			System.out.println("3 : " + vag[2].getClasse());
			System.out.println("4 : " + vag[3].getClasse());
			System.out.println("5 : " + vag[4].getClasse());	
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Jeu();
	}

}
