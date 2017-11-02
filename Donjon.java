/**
 * 
 */
package info;

/**
 * @author louis
 *	UN donjon est constitue de 3 vagues de mobs, et une partie est compose de 5 donjon.
 *	Le 5e donjon ne possede que 2 vague de mobs mais termine par un Boss.
 *	Vague 1 : 2 mobs
 *	Vague 2 : 3 mobs
 *	Vague 3 : 5 mobs
 */
public class Donjon {
	private Ennemi[] vague1;
	private Ennemi[] vague2;
	private Ennemi[] vague3;
	private Ennemi boss;

	/**
	 * 
	 */
	public Donjon() {
		this.vague1 = vague(1, 2);
		this.vague2 = vague(2, 2);
		this.vague3 = vague(3, 2);
	}
	/**
	 * 
	 */
	public Donjon(int sommeNiveau) {
		this.vague1 = vague(1, sommeNiveau);
		this.vague2 = vague(2, sommeNiveau);
		this.vague3 = vague(3, sommeNiveau);
	}
	/**
	 * 
	 */
	public Donjon(String boss, int sommeNiveau) {
		this.vague1 = vague(1, sommeNiveau);
		this.vague2 = vague(2, sommeNiveau);
		double rand = (Math.random() * 2);
		int bossNum = (int) rand + 1;
		this.boss = new Ennemi(990 + bossNum, sommeNiveau);
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
	/*
	 * @param a > 0
	 * cree une vague avec plus ou moins de mob selon la vague
	 * les ennemis de la vague sont plus ou moins fort selon 
	 * la somme des niveaux des joueurs
	 */
	private Ennemi[] vague(int a, int sommeNiveau) {
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
			v[i] = new Ennemi(numero, sommeNiveau);
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
				return vague(a, sommeNiveau);
			}
		}
		return v;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean isBoss = false;
		Donjon d;
		if (args[0].compareTo("BOSS") != 0) {
			d = new Donjon();
		}
		else {
			d = new Donjon("boss", 1);
			isBoss = true;
		}
		for (int i = 0; i < d.vague1.length; i++) {
			Ennemi e = d.vague1[i];
			System.out.println(e.getClasse() + " " + e.getVie() + " " + e.getForce());
		}
		System.out.println("\n");
		for (int i = 0; i < d.vague2.length; i++) {
			Ennemi e = d.vague2[i];
			System.out.println(e.getClasse() + " " + e.getVie()+ " " + e.getForce());
		}
		System.out.println("\n");
		if (!isBoss) {
			for (int i = 0; i < d.vague3.length; i++) {
				Ennemi e = d.vague3[i];
				System.out.println(e.getClasse() + " " + e.getVie()+ " " + e.getForce());
			}
			System.out.println("\n");
		}
		else {
			System.out.print("BOSS : ");
		}
	}

}