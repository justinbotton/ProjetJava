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
	 * constructeur sans arguments
	 */
	public Loot() {
		this.nom = "gourde";
		this.xp = 20;
	}
	
	/**
	 *  constructeur avec arguments
	 *  @param nom : nom du loot
	 *  @param xp : valeur en xp du loot
	 */
	public Loot(String nom, int xp) {
		this.nom = nom;
		this.xp = xp;
	}
	
	/**
	 * @Getter : recupere le nom d une instance de Loot
	 * @return String nom : nom de l'instance Loot
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * @Setter : place nom en argument dans nom d une instance Loot
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * @Getter : recupere la valeur d xp d une instance de Loot
	 * @return int nom : valeur d xp de l'instance Loot
	 */
	public int getXp() {
		return xp;
	}
	
	/**
	 * @Setter : place xp en argument dans xp d une instance Loot
	 * @param xp
	 */
	public void setXp(int xp) {
		this.xp = xp;
	}

	
}
