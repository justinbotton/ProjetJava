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
	 * caracteristiques des Heros.
	 */
	
	//Elfe
	public static final int forceElfe = 8;
	public static final int enduranceElfe = 200;
	public static final int vitesseAttaqueElfe = 1;
	
	//Nain
	public static final int forceNain = 6;
	public static final int enduranceNain = 300;
	public static final int vitesseAttaqueNain = 1;
	
	//Orque
	public static final int forceOrque = 4;
	public static final int enduranceOrque = 400;
	public static final int vitesseAttaqueOrque = 1;
	
	//Humain
	public static final int forceHumain = 10;
	public static final int enduranceHumain = 150;
	public static final int vitesseAttaqueHumain = 1;
	
	/**
	 * boite de selection.
	 */
	private static Icon icon;
	
	/**
	 * experience d un heros.
	 */
	private int xp;
	
	/**
	 * vie max du heros.
	 */
	private int vieMax;
	

	/**
	 * constructeur sans argument.
	 */
	public Hero() {
		super();
		Arme arme = new Arme("fourchette", 1);
		this.setUpPersonnage("euh... je n ai pas choisi de classe moi !!", enduranceHumain, 2 * enduranceHumain, forceHumain, arme, vitesseAttaqueHumain);
		this.niveau = 1;
		this.xp = 0;
		this.vieMax = 2 * enduranceHumain;
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
				Arme arme = new Arme("arc", 3);
				this.setUpPersonnage("Elfe", enduranceElfe, 2 * enduranceElfe, forceElfe, arme, vitesseAttaqueElfe);
				this.vieMax = 2 * enduranceElfe;
				break;
				
			case "Nain" : 
				Arme arme2 = new Arme("hachette", 3);
				this.setUpPersonnage("Nain", enduranceNain, 2 * enduranceNain, forceNain, arme2, vitesseAttaqueNain);
				this.vieMax = 2 * enduranceNain;
				break;
				
			case "Orque" : 
				Arme arme3 = new Arme("masse", 3);
				this.setUpPersonnage("Orque", enduranceOrque, 2 * enduranceOrque, forceOrque, arme3, vitesseAttaqueOrque);
				this.vieMax = 2 * enduranceOrque;
				break;
				
			case "Humain" : 
				Arme arme4 = new Arme("epee", 3);
				this.setUpPersonnage("Humain", enduranceHumain, 2 * enduranceHumain, forceHumain, arme4, vitesseAttaqueHumain);
				this.vieMax = 2 * enduranceHumain;
				break;
				
			default : 
				Arme arme5 = new Arme("fourchette", 1);
				this.setUpPersonnage("je suis un...heu...je n ai pas choisi !!", enduranceHumain, 2 * enduranceHumain, forceHumain, arme5, vitesseAttaqueHumain);
				this.vieMax = 2 * enduranceHumain;
				break;
		}
	}
	
	/**
	 * @Getter vieMax
	 * @return vieMax : la vie maximum d un joueur
	 */
	public int getVieMax() {
		return vieMax;
	}
	
	/**
	 * @Setter vieMax
	 * @param vieMax : remplace la valeur de vieMax par celle en parametre
	 */
	public void setVieMax(int vieMax) {
		this.vieMax = vieMax;
	}
	
	
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
			this.vie = this.vieMax;
		}
	}
	
	/**
	 * Xp a obtenir pour passer au niveau suivant.
	 * @return xp maximum du niveau du hero
	 */
	public int capLevel() {
		return 500 * this.niveau;
	}
	
	/**
	 * Converti un objet Loot en Xp pour le hero, si le Loot est une arme meilleur, remplace l arme du Hero.
	 * @param drop : ArrayList contenant des objets Loot
	 * @param entree : int indice ArrayList
	 */
	public void ramasser(ArrayList<Loot> drop, int entree) {
		String s = drop.get(entree-1).getNom();
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
	       }
	       if(weapDam>0) {
	    	   if(this.getArmeDroite().getDegat() < weapDam) {
	    		   System.out.println("Vous avez choisi : "+s+" / degat : "+weapDam);
	    		   Arme a = new Arme(s, weapDam);
	    		   this.setArmeDroite(a);
	    	   }else {
	    		   System.out.println("Vous avez choisi : "+s+" / valeur d XP : "+lootXp);
	    		   this.ajoutXp(lootXp);
	    	   }
	       } else {
	    	   System.out.println("Vous avez choisi : "+s+" / valeur d XP : "+lootXp);
	    	   this.ajoutXp(lootXp);
	       }
	       query.close();
	       select.close();
	       c.close();
	       drop.remove(entree-1);
	    } catch (Exception e) {
	    	e.printStackTrace();
	        System.err.println(e.getClass().getName()+": "+e.getMessage());
	        System.exit(0);
	    }
	}
}

