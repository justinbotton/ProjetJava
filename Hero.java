/**
 * 
 */
package info;
import java.awt.Component;

import java.io.*;
import java.lang.*;
import java.util.*;

import javax.swing.Icon;
import javax.swing.JOptionPane;


/**
 * @author Louis & Justin & Philemon
 * date 18/10/17
 * @version 0.1
 *
 */
public class Hero extends Personnage{
	
	public static final int forceElfle = 4;
	public static final int enduranceElfle = 4;
	public static final int vitesseAttaqueElfe = 1;
	public static final int forceNain = 3;
	public static final int enduranceNain = 6;
	public static final int vitesseAttaqueNain = 1;
	public static final int forceOrque = 1;
	public static final int enduranceOrque = 8;
	public static final int vitesseAttaqueOrque = 1;
	public static final int forceHumain = 5;
	public static final int enduranceHumain = 3;
	public static final int vitesseAttaqueHumain = 1;
	public static final int tailleInventaireArmeBase = 2;
	
	private static Icon icon;
	
	private ArrayList<String> inventaireArme = new ArrayList<String>();
	private int tailleInventaireArme;
	private int xp;
	
	

	/**
	 * constructeur.
	 */
	public Hero() {
		super();
		this.classe = "euh... j'ai pas choisi de classe moi !!";
		this.force = 2;
		this.endurance = enduranceHumain;
		this.vie = 2 * super.endurance;
		this.armeDroite = "fourchette";
		this.vitesseAttaque = 1;
		this.niveau = 1;
		this.xp = 0;
		this.inventaireArme.add("fourchette");
		this.tailleInventaireArme = 1;
		this.etat = "vivant";
	}
	/**
	 * constructeur 2.
	 * @param selectHero est le hero selectionne par le player
	 */
	public Hero(String selectHero) {
		this.etat = "vivant";
		this.niveau = 1;
		this.xp = 0;
		switch(selectHero) {
			case "Elfe" : 
				System.out.println("je suis un Elfle !!");
				this.classe = "Elfe";
				this.endurance = enduranceElfle;
				this.vie = 2 * this.endurance;
				this.force = forceElfle;
				this.armeDroite = "arc";
				this.vitesseAttaque = vitesseAttaqueElfe;
				this.inventaireArme.add("arc");
				this.inventaireArme.add("epee");
				System.out.println(this.inventaireArme);
				this.tailleInventaireArme = tailleInventaireArmeBase;
				break;
			case "Nain" : 
				System.out.println("je suis un Nain !!");
				this.classe = "Nain";
				this.endurance = enduranceNain;
				this.vie = 2 * this.endurance;
				this.force = forceNain;
				this.armeDroite = "hachette";
				this.vitesseAttaque = vitesseAttaqueNain;
				this.tailleInventaireArme = tailleInventaireArmeBase;
				break;
			case "Orque" : 
				System.out.println("je suis un Orque !!");
				this.classe = "Orque";
				this.endurance = enduranceOrque;
				this.vie = 2 * this.endurance;
				this.force = forceOrque;
				this.armeDroite = "masse";
				this.vitesseAttaque = vitesseAttaqueOrque;
				this.tailleInventaireArme = tailleInventaireArmeBase;
				break;
			case "Humain" : 
				System.out.println("je suis un Humain !!");
				this.classe = "Humain";
				this.endurance = enduranceHumain;
				this.vie = 2 * this.endurance;
				this.force = forceHumain;
				this.armeDroite = "epee";
				this.vitesseAttaque = vitesseAttaqueHumain;
				this.tailleInventaireArme = tailleInventaireArmeBase;
				break;
			default : 
				System.out.println("je suis un ... heu... j'ai pas choisi !!");
				this.force = forceHumain;
				this.endurance = enduranceHumain;
				this.vie = 2 * this.endurance;
				this.armeDroite = "defaut";
				this.vitesseAttaque = 1;
				this.tailleInventaireArme = tailleInventaireArmeBase;
				break;
		}
	}

	private static Icon getIcon() {
		return icon;
	}
	private static void setIcon(Icon icon) {
		Hero.icon = icon;
	}
	
	public ArrayList<String> getInventaireArme() {
		return inventaireArme;
	}
	public void setInventaireArme(ArrayList<String> inventaireArme) {
		this.inventaireArme = inventaireArme;
	}
	public int getTailleInventaireArme() {
		return tailleInventaireArme;
	}
	public void setTailleInventaireArme(int tailleInventaireArme) {
		this.tailleInventaireArme = tailleInventaireArme;
	}
	public int getXp() {
		return xp;
	}
	public void setXp(int xp) {
		this.xp = xp;
	}
	
	public void ajoutXp(int xp) {
		this.xp += xp;
	}
	public void ajoutInventaire(ArrayList<String> objet) {
		for (int i = 0; i < objet.size(); i++) {
			this.inventaireArme.add(objet.get(i));
		}
	}

	/**
	 * 
	 * @return une phrase immersive comprennant les degats applique.
	 */
	public String attaqueTest() {
		int degatPrimaire =  this.force + this.niveau;
		int degat = 0;
		int vitesseDAttaque = this.vitesseAttaque;
		String s = null;
		switch(this.armeDroite) {
		case "fourchette" : 
			degat = (degatFourchette + degatPrimaire) * vitesseDAttaque;
			s = "TCHIC ! Tu perds " + degat + ptVie;
			break;
		case "epee" : 
			degat = (degatEpee + degatPrimaire) * vitesseDAttaque;
			s = "DING ! Tu perds " + degat + ptVie;
			break;
		case "arc" : 
			degat = (degatArc + degatPrimaire) * vitesseDAttaque;
			s = "FUUIT ! Tu perds " + degat + ptVie;
			break;
		case "hachette" : 
			degat = (degatHachette + degatPrimaire) * vitesseDAttaque;
			s = "TCHING ! Tu perds " + degat + ptVie;
			break;
		case "masse" : 
			degat = (degatMasse + degatPrimaire) * vitesseDAttaque;
			s = "BOUM ! Tu perds " + degat + ptVie;
			break;
		case "cathana" : 
			degat = (degatKatana + degatPrimaire) * vitesseDAttaque;
			s = "TCHINK ! Tu perds " + degat + ptVie;
			break;
		default : 
			degat = degatPrimaire * vitesseDAttaque;
			s = "Tu perds " + degat + ptVie;
			break;
		}
		return s;
	}
	/**
	 * applique les degats au heros.
	 * @param d >0.
	 */
	public void setDegat(int d) {
		this.vie -= d;
	}	
	
	/**
	 * commentaire de definition :  chaque joueur choisi un loot 
	 * via un alea pour savoir qui commence.
	 * @param drop array d items
	 */
	public void ramasser(ArrayList<String> drop) {
		Object[] possibilities = {drop.get(0), drop.get(1)};
		Component frame = null;
		String s = (String) JOptionPane.showInputDialog(
		                    frame,
		                    "Choose your loot :\n",
		                    "Customized Dialog",
		                    JOptionPane.PLAIN_MESSAGE,
		                    icon,
		                    possibilities,
		                    "oui");
		if ((s != null) && (s.length() > 0)) {
		    //System.out.println(s);
		    System.out.println("loot choisi : " + s);
		    this.ajoutInventaire(drop);
		    System.out.println(this.getInventaireArme());
		    return;
		}
	}
	
	/**
	 * @param args .
	 */
	public static void main(String[] args) {
		
		Object[] possibilities = {"Elfe", "Nain", "Orque", "Humain"};
		Component frame = null;
		String s = (String) JOptionPane.showInputDialog(
		                    frame,
		                    "Choose your hero :\n",
		                    "Customized Dialog",
		                    JOptionPane.PLAIN_MESSAGE,
		                    icon,
		                    possibilities,
		                    "oui");

		//If a string is choose, say what hero player choose.
		if ((s != null) && (s.length() > 0)) {
		    //System.out.println(s);
		    Hero h = new Hero(s);
		    System.out.println(h.attaqueTest());
		    ArrayList<String> drop = new ArrayList<String>();
		    drop.add("epee");
		    drop.add("gourde");
		    h.ramasser(drop);
		    System.out.println(h.xp);
		    System.out.println(h.niveau);
		    return;
		}

		//If you're here, the return value was null/empty.
		System.out.println("Come on, choose your Hero !");

	}

}
