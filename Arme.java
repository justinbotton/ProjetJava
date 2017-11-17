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
	 * construit une arme.
	 */
	public Arme() {
		this.nom = "epee";
		this.degat = 3;
	}
	
	/**
	 * construit une arme.
	 * @param nom : nom de l arme.
	 * @param degat : degat de l arme.
	 */
	public Arme(String nom, int degat) {
		this.nom = nom;
		this.degat = degat;
	}
	/**
	 * @return le nom de l arme 
	 */
	public String getNom() {
		return nom;
	}
	/** 
	 * @param nom : nom a mettre pour l arme.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return les degat de l arme
	 */
	public int getDegat() {
		return degat;
	}
	/** 
	 * @param degat : degat de l arme.
	 */
	public void setDegat(int degat) {
		this.degat = degat;
	}
	
}
