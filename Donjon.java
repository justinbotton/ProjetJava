/**
 * 
 */
package info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
	private Ennemi[] vague1;
	private Ennemi[] vague2;
	private Ennemi[] vague3;
	private Ennemi boss = null;
	private ArrayList<String> loot = new ArrayList<String>();

	/**
	 * constructeur sans arguments
	 */
	public Donjon() {
		this.vague1 = genererVague(1, 2);
		this.vague2 = genererVague(2, 2);
		this.vague3 = genererVague(3, 2);
	}
	/**
	 * constructeur avec la somme de niveau en argument
	 */
	public Donjon(int sommeNiveau) {
		this.vague1 = genererVague(1, sommeNiveau);
		this.vague2 = genererVague(2, sommeNiveau);
		this.vague3 = genererVague(3, sommeNiveau);
	}
	/**
	 * constructeur de boss
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
	 * @Getter vague1.
	 * @return vague1 : la vague1 d ennemis
	 */
	public Ennemi[] getVague1() {
		return vague1;
	}
	
	/**
	 * @Setter vague1.
	 * @param vague1 : remplace la vague1 de l instance par celle en argument
	 */
	public void setVague1(Ennemi[] vague1) {
		this.vague1 = vague1;
	}
	
	/**
	 * @Getter vague2.
	 * @return vague2 : la vague2 d ennemis
	 */
	public Ennemi[] getVague2() {
		return vague2;
	}
	
	/**
	 * @Setter vague2.
	 * @param vague2 : remplace la vague2 de l instance par celle en argument
	 */
	public void setVague2(Ennemi[] vague2) {
		this.vague2 = vague2;
	}
	
	/**
	 * @Getter vague3.
	 * @return vague3 : la vague3 d ennemis
	 */
	public Ennemi[] getVague3() {
		return vague3;
	}
	
	/**
	 * @Setter vague3.
	 * @param vague3 : remplace la vague3 de l instance par celle en argument
	 */
	public void setVague3(Ennemi[] vague3) {
		this.vague3 = vague3;
	}
	
	/**
	 * @Getter boss.
	 * @return boss : le boss de la vague
	 */
	public Ennemi getBoss() {
		return boss;
	}
	
	/**
	 * @Setter vague3.
	 * @param vague3 : remplace la vague3 de l instance par celle en argument
	 */
	public void setBoss(Ennemi boss) {
		this.boss = boss;
	}
	
	/**
	 * @Getter loot.
	 * @return loot : loot genere lors de la mort d un ennemi
	 */
	public ArrayList<String> getloot() {
		return loot;
	}
	
	/**
	 * @Setter loot.
	 * @param loot : remplace le loot de l instance par celle en argument
	 */
	public void setloot(ArrayList<String> loot) {
		this.loot = loot;
	}
	
	/**
	 * 
	 * @param donjonNum numero du donjon.
	 * @param nombrePlayer nombre de joueurs
	 */
	public void lootDonjon(int donjonNum) {
		Connection connection = null;
		Statement select = null;
		ResultSet query = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjetJava", "postgres", "sql");
			select = connection.createStatement();
			for (int i = 0; i < donjonNum * 2; i++) {
				String loot = null;
				int rand = (int)((Math.random() * (25-1)) + 1);
				query = select.executeQuery("SELECT lootName FROM tbLoot WHERE lootId="+rand);
				while(query.next()) {
					loot = query.getString("lootName");
				}
				this.loot.add(loot);
			}
		    query.close();
		    select.close();
		    connection.close();
		    Iterator<String> iter = loot.iterator();
		    while(iter.hasNext()) {
		    	System.out.println(iter.next());
		    }
		 } catch (Exception e) {
		    e.printStackTrace();
		    System.err.println(e.getClass().getName()+" : "+e.getMessage());
		    System.exit(0);
		 }
	}	
	
	
	public static void main (String[]args) {
		Donjon d1 = new Donjon();
		d1.lootDonjon(3);
	}
	
	
	/**
	 * cree une vague avec plus ou moins de mob selon la vague.
	 * les ennemis de la vague sont plus ou moins fort selon 
	 * la somme des niveaux des joueurs
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
	
	/**
	 * permet d afficher les ennemis du donjon
	 * @param boss
	 * @param sommeNiveau
	 */
	public static void afficheMob(String boss, int sommeNiveau) {
		boolean isBoss = false;
		Donjon d;
		if (boss.compareTo("BOSS") != 0) {
			d = new Donjon();
		}
		else {
			d = new Donjon("boss", 1);
			isBoss = true;
		}
		for (int i = 0; i < d.vague1.length; i++) {
			Ennemi e = d.vague1[i];
			//System.out.println(e.getClasse() + " " + e.getVie() + " " + e.getForce());
		}
		//System.out.println("\n");
		for (int i = 0; i < d.vague2.length; i++) {
			Ennemi e = d.vague2[i];
			//System.out.println(e.getClasse() + " " + e.getVie()+ " " + e.getForce());
		}
		//System.out.println("\n");
		if (!isBoss) {
			for (int i = 0; i < d.vague3.length; i++) {
				Ennemi e = d.vague3[i];
				//System.out.println(e.getClasse() + " " + e.getVie()+ " " + e.getForce());
			}
			//System.out.println("\n");
		}
		else {
			//System.out.print("BOSS : ");
			//System.out.print("BOSS : " + d.getBoss().getClasse());
		}
	}
	
	

}