/**
 * 
 */
package info;

import java.util.ArrayList;

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
	 * 
	 */
	public Donjon() {
		this.vague1 = genererVague(1, 2);
		this.vague2 = genererVague(2, 2);
		this.vague3 = genererVague(3, 2);
	}
	/**
	 * 
	 */
	public Donjon(int sommeNiveau) {
		this.vague1 = genererVague(1, sommeNiveau);
		this.vague2 = genererVague(2, sommeNiveau);
		this.vague3 = genererVague(3, sommeNiveau);
	}
	/**
	 * 
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
	public Ennemi[] getVague1() {
		return vague1;
	}
	public void setVague1(Ennemi[] vague1) {
		this.vague1 = vague1;
	}
	public Ennemi[] getVague2() {
		return vague2;
	}
	public void setVague2(Ennemi[] vague2) {
		this.vague2 = vague2;
	}
	public Ennemi[] getVague3() {
		return vague3;
	}
	public void setVague3(Ennemi[] vague3) {
		this.vague3 = vague3;
	}
	public Ennemi getBoss() {
		return boss;
	}
	public void setBoss(Ennemi boss) {
		this.boss = boss;
	}
	public ArrayList<String> getloot() {
		return loot;
	}
	public void setloot(ArrayList<String> loot) {
		this.loot = loot;
	}
	/**
	 * 
	 * @param donjonNum numero du donjon.
	 * @param nombrePlayer nombre de joueurs
	 */
	public void lootDonjon(int donjonNum, int nombrePlayer) {
		for (int i = 0; i < donjonNum * nombrePlayer; i++) {
			this.loot.add("epee");
		}
		this.loot.add("carte");
	}
	public Ennemi[] getPopVague(int vagueNum) {
		if (vagueNum == 1) {return this.vague1;}
		if (vagueNum == 2) {return this.vague2;}
		if (vagueNum == 3) {return this.vague3;}
		else {return this.vague1;}
	}
	
	
	/**
	 * @param a > 0
	 * @param sommeNiveau est la somme des niveau des joueurs
	 * @return une vague d ennemi
	 * cree une vague avec plus ou moins de mob selon la vague.
	 * les ennemis de la vague sont plus ou moins fort selon 
	 * la somme des niveaux des joueurs
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