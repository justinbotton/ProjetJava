/**
 * 
 */
package info;

import java.util.ArrayList;

/**
 * @author Louis & Philemon & Justin.
 *
 */
public class Personnage {
	public static final int degatFourchette = 1;
	public static final int degatEpee = 3;
	public static final int degatHachette = 3;
	public static final int degatArc = 3;
	public static final int degatMasse = 3;
	public static final int degatKatana = 5;
	public static final String ptVie = " points de vie !";
	
	protected String classe;
	protected int vie;
	protected int force;
	protected int endurance;
	protected int niveau;
	protected String armeDroite;
	protected int vitesseAttaque;
	protected String etat;

	/**
	 * 
	 */
	public Personnage() {
		// TODO Auto-generated constructor stub
	}
	
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public int getVie() {
		return vie;
	}
	public void setVie(int vie) {
		this.vie = vie;
	}
	public int getForce() {
		return force;
	}
	public void setForce(int force) {
		this.force = force;
	}
	public int getEndurance() {
		return endurance;
	}
	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}
	public String getArmeDroite() {
		return armeDroite;
	}
	public void setArmeDroite(String armeDroite) {
		this.armeDroite = armeDroite;
	}
	public String getClasse() {
		return this.classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public int getVitesseAttaque() {
		return vitesseAttaque;
	}
	public void setVitesseAttaque(int vitesseAttaque) {
		this.vitesseAttaque = vitesseAttaque;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	/**
	 * fonction d attaque.
	 * @param p personnage Hero/ennemi qui est attaque.
	 */
	public void attaque(Personnage p) {
		int degatPrimaire =  this.force + this.niveau;
		int degat = 0;
		int vitesseDAttaque = this.vitesseAttaque;
		switch(this.armeDroite) {
		case "epee" : 
			degat = (degatEpee + degatPrimaire) * vitesseDAttaque;
			break;
		case "arc" : 
			degat = (degatArc + degatPrimaire) * vitesseDAttaque;
			break;
		case "hachette" : 
			degat = (degatHachette + degatPrimaire) * vitesseDAttaque;
			break;
		case "masse" : 
			degat = (degatMasse + degatPrimaire) * vitesseDAttaque;
			break;
		case "cathana" : 
			degat = (degatKatana + degatPrimaire) * vitesseDAttaque;
			break;
		default : 
			degat = degatPrimaire * vitesseDAttaque;
			break;
		}
		p.setDegat(degat);
	}

	/**
	 * applique les degats a l ennemi.
	 * @param d >0.
	 */
	public void setDegat(int d) {
		this.vie -= d;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
