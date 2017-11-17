/**
 * 
 */
package info;

/**
 * @author Louis & Justin & Philemon
 *
 */
public class Loot {
	/**
	 * nom du loot.
	 */
	private String nom;
	/**
	 * xp de la desintegration du loot.
	 */
	private int xp;

	/**
	 *  cree un loot.
	 */
	public Loot() {
		this.nom = "gourde";
		this.xp = 20;
	}
	/**
	 *  cree un loot.
	 */
	public Loot(String nom, int xp) {
		this.nom = nom;
		this.xp = xp;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getXp() {
		return xp;
	}
	public void setXp(int xp) {
		this.xp = xp;
	}

	
}
