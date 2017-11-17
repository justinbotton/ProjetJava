/**
 * 
 */
package info;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JOptionPane;

/**
 * @author louis & justin & philemon
 *
 */
public class Jeu {
	private int enVie;
	private int nombreJoueur;
	private Hero[] joueur;

	/**
	 * 
	 */
	public Jeu() {
		/*Hero h = new Hero();
		String[] args = null;
		h.main(args);*/
		this.enVie = 1;
		this.nombreJoueur = 1;
		joueur = new Hero[this.nombreJoueur];
		for (int i = 0; i < nombreJoueur; i++) {
			Hero h = new Hero();
			String[] args = null;
			h.main(args);
			joueur[i] = h;
		}
		Donjon d;
		Donjon boss;
		int i = 4;
		while (i > 0 && this.getEnVie() > 0) {
			d = new Donjon();
			String[] appelVagues = new String[1];
			appelVagues[0] = "oui";
			d.main(appelVagues);
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
			String[] appelBoss = new String[1];
			appelBoss[0] = "BOSS";
			boss.main(appelBoss);
			System.out.println(boss.getBoss().getClasse());
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
	public Hero[] getJoueur() {
		return joueur;
	}
	public void setJoueur(Hero[] joueur) {
		this.joueur = joueur;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Jeu();
	}

}
