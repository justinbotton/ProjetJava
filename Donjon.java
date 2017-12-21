/**
 * 
 */
package info;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;

/**
 * @author louis & justin & philemon
 *	Un donjon est constitue de 3 vagues de mobs, et une partie est compose de 5 donjon.
 *	Le 5e donjon ne possede que 2 vague de mobs mais termine par un Boss.
 *	Vague 1 : 2 mobs
 *	Vague 2 : 3 mobs
 *	Vague 3 : 5 mobs
 */
public class Donjon {
	
	/**
	 * tableau d ennemis de la vague 1
	 */
	private Ennemi[] vague1;
	
	/**
	 * tableau d ennemis de la vague 2
	 */
	private Ennemi[] vague2;
	
	/**
	 * tableau d ennemis de la vague 3
	 */
	private Ennemi[] vague3;
	
	/**
	 * true si on est a la vague du boss false sinon
	 */
	private Ennemi boss = null;
	
	/**
	 * contient les loot genere apres chaque vagues
	 */
	private ArrayList<Loot> loot = new ArrayList<Loot>();

	/**
	 * Constructeur sans paramètre
	 */
	public Donjon() {
		this.vague1 = genererVague(1, 2);
		this.vague2 = genererVague(2, 2);
		this.vague3 = genererVague(3, 2);
	}
	
	/**
	 * Constructeur tenant compte de la somme des niveaux
	 * @param sommeNiveau : somme des niveaux des Heros
	 */
	public Donjon(int sommeNiveau) {
		this.vague1 = genererVague(1, sommeNiveau);
		this.vague2 = genererVague(2, sommeNiveau);
		this.vague3 = genererVague(3, sommeNiveau);
	}
	
	/**
	 * Constructeur pour la vague contenant le boss
	 * @param boss : true si on est a la vague du boss false sinon
	 * @param sommeNiveau : somme des niveaux des Heros
	 */
	public Donjon(String boss, int sommeNiveau) {
		this.vague1 = genererVague(1, sommeNiveau);
		this.vague2 = genererVague(2, sommeNiveau);
		double rand = (Math.random() * 2);
		int bossNum = (int) rand + 1;
		String s;
		switch(bossNum) {
			case 1 : 
				s = "grand mage";
				break;
			case 2 : 
				s = "samourai";
				break;
			default : 
				s = "grand mage";
				break;
		}
		this.boss = new Ennemi(s, sommeNiveau);
	}
	
	/**
	 * @Getter vague1
	 * @return vague1 : tableau contenant la vague1 d ennemis
	 */
	public Ennemi[] getVague1() {
		return vague1;
	}
	
	/**
	 * @Setter vague1
	 * @param vague1 : remplace la valeur de vague1 par celle en parametre
	 */
	public void setVague1(Ennemi[] vague1) {
		this.vague1 = vague1;
	}
	
	/**
	 * @Getter vague2
	 * @return vague2 : tableau contenant la vague2 d ennemis
	 */
	public Ennemi[] getVague2() {
		return vague2;
	}
	
	/**
	 * @Setter vague2
	 * @param vague2 : remplace la valeur de vague2 par celle en parametre
	 */
	public void setVague2(Ennemi[] vague2) {
		this.vague2 = vague2;
	}
	
	/**
	 * @Getter vague3
	 * @return vague3 : tableau contenant la vague3 d ennemis
	 */
	public Ennemi[] getVague3() {
		return vague3;
	}
	
	/**
	 * @Setter vague3
	 * @param vague3 : remplace la valeur de vague3 par celle en parametre
	 */
	public void setVague3(Ennemi[] vague3) {
		this.vague3 = vague3;
	}
	
	/**
	 * @Getter boss
	 * @return	boss : true si on est a la vague du boss false sinon
	 */
	public Ennemi getBoss() {
		return boss;
	}
	
	/**
	 * @Setter boss
	 * @param boss : remplace la valeur de boss par celle en parametre
	 */
	public void setBoss(Ennemi boss) {
		this.boss = boss;
	}
	
	/**
	 * @Getter loot
	 * @return loot : arraylist contenant les loot
	 */
	public ArrayList<Loot> getLoot() {
		return loot;
	}
	
	/**
	 * @Setter loot
	 * @param loot : remplace l arraylist de Loot par celui en parametre
	 */
	public void setLoot(ArrayList<Loot> loot) {
		this.loot = loot;
	}
	
	/**
	 * Remplir l arraylist loot avec les Loot dans la database
	 * @param donjonNum numero du donjon.
	 * @return loot : arraylist rempli avec les objets Loot de la database
	 */
	public ArrayList<Loot> lootDonjon(int donjonNum) {
		Connection connection = null;
  		Statement select = null;
  		ResultSet query = null;
  		try {
  			Class.forName("org.postgresql.Driver");
  			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjetJava", "postgres", "sql");
  			select = connection.createStatement();
  			for (int i = 0; i < donjonNum * 2; i++) {
  				Loot sLoot = null;
  				String nomLoot = null;
  				int xpLoot = 0;
  				int rand = (int)((Math.random() * (25-1)) + 1);
  				query = select.executeQuery("SELECT lootName, lootXpValue FROM tbLoot WHERE lootId="+rand);
  				while(query.next()) {
					nomLoot = query.getString("lootName");
					xpLoot = query.getInt("lootXpValue");
				}
  				sLoot = new Loot(nomLoot, xpLoot);
				this.loot.add(sLoot);
  			}
  			query.close();
		    select.close();
		    connection.close();
   		} catch (Exception e) {
		    e.printStackTrace();
		    System.err.println(e.getClass().getName()+" : "+e.getMessage());
   		}	
	    return loot;
	}
	
	/**
	 * simplifie la recuperation des vagues
	 * @Getter vagueX
	 * @param vagueNum : numero de vague
	 * @return vagueX : une vague d ennemi dont le numero est en parametre
	 */
	public Ennemi[] getPopVague(int vagueNum) {
		if (vagueNum == 1) {return this.vague1;}
		if (vagueNum == 2) {return this.vague2;}
		if (vagueNum == 3) {return this.vague3;}
		else {return this.vague1;}
	}
	
	
	/**
	 * cree une vague avec plus ou moins d ennemis selon la vague.
	 * les ennemis de la vague sont plus ou moins fort selon la somme des niveaux des joueurs
	 * @param a > 0
	 * @param sommeNiveau est la somme des niveau des joueurs
	 * @return une vague d ennemi
	 */
	private Ennemi[] genererVague(int a, int sommeNiveau) {
		Ennemi[] v;
		
		// choisi la taille de la vague en fonction de son numero
		if (a >= 3) {
			 v = new Ennemi[a + 2];
		}
		else {
			v = new Ennemi[a + 1];
		}
		
		// for rempli de maniere aleatoire la vague de mobs
		double rand;
		for (int i = 0; i < v.length; i++) {
			rand =  Math.random() * 4;
			int numero = (int) rand + 1;
			String s;
			switch(numero) {
				case 1 : 
					s = "gobelin";
					break;
				case 2 : 
					s = "troll";
					break;
				case 3 : 
					s = "groupe gobelin";
					break;
				case 4 : 
					s = "magicien noir";
					break;
				default : 
					s = "gobelin";
					break;
			}
			v[i] = new Ennemi(s, sommeNiveau);
		}
		
		// verifie qu il n y ait jamais plus de 2 troll/magicien noir
		// dans une vague
		if (a != 1) {
			int countMage = 0;
			int countTroll = 0;
			for (Ennemi e : v) {
				String classe = (String) e.getClasse();
				if (classe.compareTo("troll") == 0) {
					countTroll++;
				}
				else if (classe.compareTo("magicien noir") == 0) {
					countMage++;
				}
			}
			if (countMage > 2 || countTroll > 2) {
				return genererVague(a, sommeNiveau);
			}
		}
		return v;
	}
}