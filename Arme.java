/**
 * 
 */
package info;

/**
 * @author Louis & Justin & Philemon
 *
 */
public class Arme {
	
	/**
	 * nom de l arme.
	 */
	private String nom;
	
	/**
	 * degat de l arme.
	 */
	private int degat;
	
	/**
	 * constructeur sans argument.
	 */
	public Arme() {
		this.nom = "epee";
		this.degat = 3;
	}
	
	/**
	 * constructeur avec arguments.
	 * @param nom : nom 
	 * @param degat : degat
	 */
	public Arme(String nom, int degat) {
		this.nom = nom;
		this.degat = degat;
	}
	
	/**
	 * @Getter nom.
	 * @return nom : le nom de l arme 
	 */
	public String getNom() {
		return nom;
	}
	
	/** 
	 * @Setter nom
	 * @param nom : remplace le nom courant par celui en argument
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * @Getter degat.
	 * @return degat : les degat de l arme
	 */
	public int getDegat() {
		return degat;
	}
	
	/** 
	 * @Setter degat
	 * @param degat : remplace les degats courant par ceux en argument
	 */
	public void setDegat(int degat) {
		this.degat = degat;
	}
	
}
