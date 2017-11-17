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
public class Hero extends Personnage {
	
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
	/*
	 * pour une future maj
	private ArrayList<Arme> inventaireArme = new ArrayList<Arme>();
	private int tailleInventaireArme;*/
	private int xp;
	
	

	/**
	 * constructeur.
	 */
	public Hero() {
		super();
		Arme arme = new Arme("fourchette", 1);
		this.setUpPersonnage("euh... j'ai pas choisi de classe moi !!", enduranceHumain, 2 * enduranceHumain, forceHumain, arme, vitesseAttaqueHumain);
		this.niveau = 1;
		this.xp = 0;
		/*
		 * pour une future maj
		this.inventaireArme.add(armeDroite);
		this.tailleInventaireArme = 1;
		*/
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
				Arme arme = new Arme("arc", 3);
				this.setUpPersonnage("Elfe", enduranceElfle, 2 * enduranceElfle, forceElfle, arme, vitesseAttaqueElfe);
				break;
			case "Nain" : 
				System.out.println("je suis un Nain !!");
				Arme arme2 = new Arme("hachette", 3);
				this.setUpPersonnage("Nain", enduranceNain, 2 * enduranceNain, forceNain, arme2, vitesseAttaqueNain);
				break;
			case "Orque" : 
				System.out.println("je suis un Orque !!");
				Arme arme3 = new Arme("masse", 3);
				this.setUpPersonnage("Orque", enduranceOrque, 2 * enduranceOrque, forceOrque, arme3, vitesseAttaqueOrque);
				break;
			case "Humain" : 
				System.out.println("je suis un Humain !!");
				Arme arme4 = new Arme("epee", 1);
				this.setUpPersonnage("Huamin", enduranceHumain, 2 * enduranceHumain, forceHumain, arme4, vitesseAttaqueHumain);
				break;
			default : 
				System.out.println("je suis un ... heu... j'ai pas choisi !!");
				Arme arme5 = new Arme("epee", 1);
				this.setUpPersonnage("je suis un ... heu... j'ai pas choisi !!", enduranceHumain, 2 * enduranceHumain, forceHumain, arme5, vitesseAttaqueHumain);
				break;
		}
	}
	private static Icon getIcon() {
		return icon;
	}
	private static void setIcon(Icon icon) {
		Hero.icon = icon;
	}
	/*
	 * pour une future maj
	public ArrayList<Arme> getInventaireArme() {
		return inventaireArme;
	}
	public void setInventaireArme(ArrayList<Arme> inventaireArme) {
		this.inventaireArme = inventaireArme;
	}
	public int getTailleInventaireArme() {
		return tailleInventaireArme;
	}
	public void setTailleInventaireArme(int tailleInventaireArme) {
		this.tailleInventaireArme = tailleInventaireArme;
	}*/
	public int getXp() {
		return xp;
	}
	public void setXp(int xp) {
		this.xp = xp;
	}
	
	public void ajoutXp(int xp) {
		this.xp += xp;
		if (this.xp >= capLevel()) {
			this.niveau++;
			this.xp -= capLevel();	
		}
	}
	/**
	 * @return le nombre d xp pour passer au niveau suivant
	 */
	public int capLevel() {
		return 500 * this.niveau; // mettre formule du genre exponentielle
	}
	/*
	 * pour une future maj
	 * 
	public void ajoutInventaire(ArrayList<Arme> objet) {
		for (int i = 0; i < objet.size(); i++) {
			this.inventaireArme.add(objet.get(i));
		}
	}*/
	
	/**
	 * commentaire de definition :  chaque joueur choisi un loot 
	 * via un alea pour savoir qui commence.
	 * @param drop array d items
	 */
	public void ramasser(ArrayList<Loot> drop) {
		int taille = drop.size();
		Object[] possibilities = new Object[taille];
		for (int i = 0; i < taille; i++) {
			possibilities[i] = drop.get(i).getNom();
		}
		Component frame = null;
		String s = (String) JOptionPane.showInputDialog(frame, "Choose your loot :\n", "Customized Dialog",
		                    							JOptionPane.PLAIN_MESSAGE, icon, possibilities,	"oui");
		if ((s != null) && (s.length() > 0)) {
		    System.out.println("loot choisi : " + s);
		    switch(s) {
		    // ajouter le loot si arme et desintegrer et ajout xp sinon^^ par rapport a la db
		    case "s" :
		    break;
		    }
		    
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
		    ArrayList<Loot> drop = new ArrayList<Loot>();
		    drop.add(new Loot("epee", 100));
		    drop.add(new Loot("gourde", 20));
		    h.ramasser(drop);
		    return;
		}

		//If here, the return value s is null/empty.
		System.out.println("Come on, choose your Hero !");

	}

}
