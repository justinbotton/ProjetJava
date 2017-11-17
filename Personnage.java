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
	/*public static final int degatFourchette = 1;
	public static final int degatEpee = 3;
	public static final int degatHachette = 3;
	public static final int degatArc = 3;
	public static final int degatMasse = 3;
	public static final int degatBaton = 4;
	public static final int degatKatana = 5;*/
	public static final String ptVie = " points de vie !";
	
	protected String classe;
	protected int vie;
	protected int force;
	protected int endurance;
	protected int niveau;
	protected Arme armeDroite;
	protected int vitesseAttaque;
	protected String etat;
	protected String type;

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
	public Arme getArmeDroite() {
		return armeDroite;
	}
	public void setArmeDroite(Arme armeDroite) {
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * fonction d attaque.
	 * @param p personnage Hero/ennemi qui est attaque.
	 */
	public void attaque(Personnage p) {
		int degatPrimaire =  this.force + this.niveau;
		int vitesseDAttaque = this.vitesseAttaque;
		int degat = 0;
		if (this.armeDroite != null) {
			degat = (this.armeDroite.getDegat() + degatPrimaire) * vitesseDAttaque;
		}
		else {
			degat =  degatPrimaire * vitesseDAttaque;
		}
		p.setDegat(degat);
	}
	/**
	 *  set les parametre de base du personnage.
	 *  
	 */
	public void setUpPersonnage(String classe, int endurance, int vie, int force, Arme armeDroite, int vitesseAttaque){
		this.classe = classe;
		this.endurance = endurance;
		this.vie = vie;
		this.force = force;
		this.armeDroite = armeDroite;
		this.vitesseAttaque = vitesseAttaque;
	}
	/**
	 * applique les degats a l ennemi.
	 * @param d >0.
	 */
	public void setDegat(int d) {
		this.vie -= d;
		if (this.vie <= 0) {
			this.setVie(0);
			this.setEtat("mort");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
