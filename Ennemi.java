/**
 * 
 */
package info;

import java.util.ArrayList;

/**
 * @author louis & justin & philemon
 *
 */
public class Ennemi {
	public static final int forceGobelin = 2;
	public static final int enduranceGobelin = 10;
	public static final int vitesseAttaqueGobelin = 1;
	public static final int forceTroll = 2;
	public static final int enduranceTroll = 20;
	public static final int vitesseAttaqueTroll = 1;
	public static final int forceGroupeGobelin = 2;
	public static final int enduranceGroupeGobelin = 30;
	public static final int vitesseAttaqueGroupeGobelin = 1;
	public static final int forceMagicienNoir = 3;
	public static final int enduranceMagicienNoir = 15;
	public static final int vitesseAttaqueMagicienNoir = 1;
	public static final int forceGrandMage = 5;
	public static final int enduranceGrandMage = 50;
	//public static final int vitesseAttaqueGrandMage = 1; pas utile
	public static final int forceSamourai = 8;
	public static final int enduranceSamourai = 40;
	public static final int degatEpee = 3;
	public static final int degatHachette = 2;
	public static final int degatArc = 3;
	public static final int degatMasse = 3;
	public static final int degatKatana = 5;
	public static final String ptVie = " points de vie !";
	
	private String classe;
	private String type; //mob ou boss
	private int vie;
	private int force;
	private int endurance;
	private int niveau;
	private String armeDroite;
	private int vitesseAttaque;
	private String etat;

	/**
	 * 
	 */
	public Ennemi() {
		this.classe = "gobelin";
		this.type = "mob";
		this.force = forceGobelin;
		this.endurance = enduranceGobelin;
		this.vie = 2 * this.endurance;
		this.armeDroite = "hachette";
		this.vitesseAttaque = vitesseAttaqueGobelin;
		this.niveau = 1;
		this.etat = "vivant";
	}
	/**
	 * 
	 */
	public Ennemi(String selectEnnemi, int sommeNiveau) {
		switch(selectEnnemi) {
			case "gobelin" : 
				new Ennemi(1, sommeNiveau);
				break;
			case "troll" : 
				new Ennemi(2, sommeNiveau);
				break;
			case "groupe gobelin" : 
				new Ennemi(3, sommeNiveau);
				break;
			case "magicien noir" : 
				new Ennemi(4, sommeNiveau);
				break;
			/*case "boss" : 
				new Ennemi(991,sommeNiveau);
				break;*/
			default : 
				new Ennemi(1, sommeNiveau);
				break;
		}
	}
	/**
	 * @param choix est le random qui choisi l ennemi qui fera 
	 * 		partie de la vague
	 * @param sommeNiveau est un entier pour ajuster les caracteristiques 
	 * 		des ennemis en fonction du niveau du groupe de joueur
	 */
	public Ennemi(int choix, int sommeNiveau) {
		int ajustement = (int) (sommeNiveau / 2);
		int ajustVitesse = (int) (ajustement / 4);
		this.etat = "vivant";
		this.niveau =  ajustement;
		this.type = "mob";
		switch(choix) {
		case 1 : 
			//System.out.println("Vous affrontez un goblein !!");
			this.classe = "gobelin";
			this.endurance = enduranceGobelin + ajustement;
			this.vie = 2 * this.endurance;
			this.force = forceGobelin + ajustement;
			this.armeDroite = "hachette";
			this.vitesseAttaque = vitesseAttaqueGobelin + ajustVitesse;
			break;
		case 2 : 
			//System.out.println("Vous affrontez un troll !!");
			this.classe = "troll";
			this.endurance = enduranceTroll + ajustement;
			this.vie = 2 * this.endurance;
			this.force = forceTroll + ajustement;
			this.armeDroite = "masse";
			this.vitesseAttaque = vitesseAttaqueTroll + ajustVitesse;
			break;
		case 3 : 
			//System.out.println("Vous affrontez un groupe de gobelin !!");
			this.classe = "groupe gobelin";
			this.endurance = enduranceGroupeGobelin + ajustement;
			this.vie = 2 * this.endurance;
			this.force = forceGroupeGobelin + ajustement;
			this.armeDroite = "hachette";
			this.vitesseAttaque = vitesseAttaqueGroupeGobelin + ajustVitesse;
			break;
		case 4 : 
			//System.out.println("Vous affrontez un magicien noir !!");
			this.classe = "magicien noir";
			this.endurance = enduranceMagicienNoir + ajustement;
			this.vie = 2 * this.endurance;
			this.force = forceMagicienNoir + ajustement;
			this.armeDroite = "baton";
			this.vitesseAttaque = vitesseAttaqueMagicienNoir + ajustVitesse;
			break;
		case 991 :
			// boss 1
			this.classe = "grand mage";
			this.type = "boss";
			this.endurance = enduranceGrandMage + ajustement;
			this.vie = 3 * this.endurance;
			this.niveau = ajustement + 1;
			this.force = forceGrandMage + ajustement; 
			this.armeDroite = "baton";
			this.vitesseAttaque = ajustVitesse;
			break;
		case 992 :
			// boss 2
			this.classe = "samourai";
			this.type = "boss";
			this.endurance = enduranceSamourai + ajustement;
			this.vie = 3 * this.endurance;
			this.niveau = ajustement + 1;
			this.force = forceSamourai + ajustement; 
			this.armeDroite = "katana";
			this.vitesseAttaque = ajustVitesse;
			break;
		default : 
			//System.out.println("Vous affrontez un gobelin !!");
			this.classe = "gobelin";
			this.endurance = enduranceGobelin + ajustement;
			this.vie = 2 * this.endurance;
			this.force = forceGobelin + ajustement;
			this.armeDroite = "hachette";
			this.vitesseAttaque = vitesseAttaqueGobelin + ajustVitesse;
			break;
		}
	}
	
	
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
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
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public String getArmeDroite() {
		return armeDroite;
	}
	public void setArmeDroite(String armeDroite) {
		this.armeDroite = armeDroite;
	}
	public int getVitesseAttaque() {
		return vitesseAttaque;
	}
	public void setVitesseAttaque(int vitesseAttaque) {
		this.vitesseAttaque = vitesseAttaque;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	public void attaque(Hero h) {
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
		h.setDegat(degat);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Ennemi e = new Ennemi(4,5);
		System.out.println(e.getClasse());
		System.out.println(e.force);
		System.out.println(e.vitesseAttaque);
		System.out.println(e.niveau);
		

	}

}
