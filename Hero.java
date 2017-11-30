/**
 * 
 */
package info;

import java.awt.Component;

//import java.io.*;
//import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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
	
	/**
	 * caracteristiques de la classe elfe.
	 */
	public static final int forceElfle = 4;
	public static final int enduranceElfle = 40;
	public static final int vitesseAttaqueElfe = 1;
	
	/**
	 * caracteristiques de la classe nain.
	 */
	public static final int forceNain = 3;
	public static final int enduranceNain = 60;
	public static final int vitesseAttaqueNain = 1;
	
	/**
	 * caracteristiques de la classe orque.
	 */
	public static final int forceOrque = 1;
	public static final int enduranceOrque = 80;
	public static final int vitesseAttaqueOrque = 1;
	
	/**
	 * caracteristiques de la classe humain.
	 */
	public static final int forceHumain = 5;
	//public static final int enduranceHumain = 30;
	public static final int enduranceHumain = 1;
	public static final int vitesseAttaqueHumain = 1;
	//public static final int tailleInventaireArmeBase = 2;
	
	/**
	 * boite de selection.
	 */
	private static Icon icon;
	
	/*
	 * pour une future maj.
	private ArrayList<Arme> inventaireArme = new ArrayList<Arme>();
	private int tailleInventaireArme;*/
	
	/**
	 * experience d un hero.
	 */
	private int xp;
	

	/**
	 * constructeur sans argument.
	 */
	public Hero() {
		super();
		Arme arme = new Arme("fourchette", 1);
		this.setUpPersonnage("euh... je n ai pas choisi de classe moi !!", enduranceHumain, 2 * enduranceHumain, forceHumain, arme, vitesseAttaqueHumain);
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
	 * constructeur avec argument.
	 * @param selectHero : hero choisi par le joueur
	 */
	public Hero(String selectHero) {
		super();
		this.etat = "vivant";
		this.niveau = 1;
		this.xp = 0;
		switch(selectHero) {
			case "Elfe" : 
				//System.out.println("je suis un Elfle !!");
				Arme arme = new Arme("arc", 3);
				this.setUpPersonnage("Elfe", enduranceElfle, 2 * enduranceElfle, forceElfle, arme, vitesseAttaqueElfe);
				//setUpHero("Elfe", enduranceElfle, 2 * enduranceElfle, forceElfle, arme, vitesseAttaqueElfe);
				break;
			case "Nain" : 
				//System.out.println("je suis un Nain !!");
				Arme arme2 = new Arme("hachette", 3);
				this.setUpPersonnage("Nain", enduranceNain, 2 * enduranceNain, forceNain, arme2, vitesseAttaqueNain);
				break;
			case "Orque" : 
				//System.out.println("je suis un Orque !!");
				Arme arme3 = new Arme("masse", 3);
				this.setUpPersonnage("Orque", enduranceOrque, 2 * enduranceOrque, forceOrque, arme3, vitesseAttaqueOrque);
				break;
			case "Humain" : 
				//System.out.println("je suis un Humain !!");
				Arme arme4 = new Arme("epee", 3);
				this.setUpPersonnage("Humain", enduranceHumain, 2 * enduranceHumain, forceHumain, arme4, vitesseAttaqueHumain);
				break;
			default : 
				//System.out.println("je suis un ... heu... j'ai pas choisi !!");
				Arme arme5 = new Arme("fourchette", 1);
				this.setUpPersonnage("je suis un...heu...je n ai pas choisi !!", enduranceHumain, 2 * enduranceHumain, forceHumain, arme5, vitesseAttaqueHumain);
				break;
		}
	}
	public void setUpHero(String classe, int endurance, int vie, int force, Arme armeDroite, int vitesseAttaque){
		this.classe = classe;
		this.endurance = endurance;
		this.vie = vie;
		this.force = force;
		this.armeDroite = armeDroite;
		this.vitesseAttaque = vitesseAttaque;
	}
	
	/*
	private static Icon getIcon() {
		return icon;
	}
	private static void setIcon(Icon icon) {
		Hero.icon = icon;
	}*/
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
	
	/**
	 * @Getter XP.
	 * @return : recupere l xp du hero
	 */
	public int getXp() {
		return xp;
	}
	
	/**
	 * @Setter XP.
	 * @param xp : remplace l xp d un hero par le parametre xp
	 */
	public void setXp(int xp) {
		this.xp = xp;
	}
	
	/**
	 * ajoute l xp en parametre a celle du hero.
	 * @param xp : xp a ajouter
	 */
	public void ajoutXp(int xp) {
		this.xp += xp;
		if (this.xp >= this.capLevel()) {
			this.xp -= this.capLevel();	
			this.niveau++;
		}
	}
	
	/**
	 * Xp a obtenir pour passer au niveau suivant.
	 * @return xp maximum du niveau du hero
	 */
	public int capLevel() {
		return 500 * this.niveau; // mettre formule du genre exponentielle
	}
	
	/*
	 * pour une future maj.
	 * 
	public void ajoutInventaire(ArrayList<Arme> objet) {
		for (int i = 0; i < objet.size(); i++) {
			this.inventaireArme.add(objet.get(i));
		}
	}*/
	
	/**
	 * Converti un objet Loot en Xp pour le hero, si le Loot est une arme meilleur, remplace l arme du Hero.
	 * @param drop : ArrayList contenant des objets Loot
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
		    
		    Connection c = null;
		      Statement select = null;
		      try {
		         Class.forName("org.postgresql.Driver");
		         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjetJava", "postgres", "sql");
		         select = c.createStatement();
		         ResultSet query = select.executeQuery("SELECT weaponDamage, lootXpValue from tbLoot WHERE lootName = \'"+s+"\'");
		         int weapDam = 0;
		         int lootXp = 0;
		         while(query.next()) {
		        	 weapDam = query.getInt("weaponDamage");
		        	 lootXp = query.getInt("lootXpValue");
		        	 //System.out.println(weapDam);
		         }
		         if(weapDam>0) {
		        	 if(this.getArmeDroite().getDegat() < weapDam) {
		        		 System.out.println(weapDam+" "+s);
		        		 Arme a = new Arme(s, weapDam);
		        		 this.setArmeDroite(a);
		        	 }
		         } else {
		        	 System.out.println(lootXp);
		        	 this.ajoutXp(lootXp);
		         }
		         query.close();
		         select.close();
		         c.close();
		      } catch (Exception e) {
		         e.printStackTrace();
		         System.err.println(e.getClass().getName()+": "+e.getMessage());
		         System.exit(0);
		      }
		      System.out.println("Opération effectuée");
		    
		}
	}
	
	
	
	/**
	 * methode d execution.
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
		    Hero h = new Hero("Elfe");
		    System.out.println(h.getClasse());
		    /*ArrayList<Loot> drop = new ArrayList<Loot>();
		    drop.add(new Loot("epee", 100));
		    drop.add(new Loot("gourde", 20));
		    h.ramasser(drop);*/
		    return;
		}

		//If here, the return value s is null/empty.
		System.out.println("Come on, choose your Hero !");

	}

}
