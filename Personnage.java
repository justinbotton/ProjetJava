/**
 * 
 */
package info;

//import java.util.ArrayList;

/**
 * @author Louis & Philemon & Justin.
 *
 */
public class Personnage {
	/*public static final int degatFourchette = 1;
	public static final int degatEpee = 3;
	public static final int degatHachette = 3;
	public static final int degatArc = 3;
	public static final int degatMasse = 3;
	public static final int degatBaton = 4;
	public static final int degatKatana = 5;*/
	
	/**
	 * classe du Personnage (Nain, Elfe,...).
	 */
	protected String classe;
	
	/**
	 * points de vie.
	 */
	protected int vie;
	
	/**
	 * points de force.
	 */
	protected int force;
	
	/**
	 * points d endurance.
	 */
	protected int endurance;
	
	/**
	 * niveau du personnage.
	 */
	protected int niveau;
	
	/**
	 * arme du personnage.
	 */
	protected Arme armeDroite;
	
	/**
	 * points de vitesse d attaque.
	 */
	protected int vitesseAttaque;
	
	/**
	 * etat du personnage : vivant/mort.
	 */
	protected String etat;
	
	/**
	 * type du personnage.
	 */
	protected String type;

	/**
	 * constructeur sans arguments
	 */
	public Personnage() {

	}
	
	/**
	 * @Getter niveau.
	 * @return niveau : le niveau du personnage
	 */
	public int getNiveau() {
		return niveau;
	}
	
	/**
	 * @Setter niveau.
	 * @param niveau : remplace le niveau courant par celui en parametre
	 */
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	
	/**
	 * @Getter vie.
	 * @return vie : la vie du personnage
	 */
	public int getVie() {
		return vie;
	}
	
	/**
	 * @Setter vie.
	 * @param vie : remplace la vie courante par celle en parametre
	 */
	public void setVie(int vie) {
		this.vie = vie;
	}
	
	/**
	 * @Getter force.
	 * @return force : la force du personnage
	 */
	public int getForce() {
		return force;
	}
	
	/**
	 * @Setter force.
	 * @param force : remplace la force courante par celle en parametre
	 */
	public void setForce(int force) {
		this.force = force;
	}
	
	/**
	 * @Getter endurance.
	 * @return endurance : l endurance du personnage
	 */
	public int getEndurance() {
		return endurance;
	}
	
	/**
	 * @Setter endurance.
	 * @param endurance : remplace l endurance courante par celle en parametre
	 */
	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}
	
	/**
	 * @Getter arme.
	 * @return arme : l arme du personnage
	 */
	public Arme getArmeDroite() {
		return armeDroite;
	}
	
	/**
	 * @Setter arme.
	 * @param arme : remplace l arme courante par celle en parametre
	 */
	public void setArmeDroite(Arme armeDroite) {
		this.armeDroite = armeDroite;
	}
	
	/**
	 * @Getter classe.
	 * @return classe : la classe du personnage
	 */
	public String getClasse() {
		return this.classe;
	}
	
	/**
	 * @Setter classe.
	 * @param classe : remplace la classe courante par celle en parametre
	 */
	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	/**
	 * @Getter vitesse d attaque.
	 * @return vitesse d attaque : la vitesse d attaque du personnage
	 */
	public int getVitesseAttaque() {
		return vitesseAttaque;
	}
	
	/**
	 * @Setter vitesse d attaque.
	 * @param vitesse d attaque : remplace la vitesse d attaque courante par celle en parametre
	 */
	public void setVitesseAttaque(int vitesseAttaque) {
		this.vitesseAttaque = vitesseAttaque;
	}
	
	/**
	 * @Getter etat.
	 * @return etat : l etat du personnage
	 */
	public String getEtat() {
		return etat;
	}
	
	/**
	 * @Setter etat
	 * @param etat : remplace l etat courant par celui en parametre
	 */
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	/**
	 * @Getter type.
	 * @return type : le type du personnage
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * @Setter type.
	 * @param type : remplace le type courant par celui en parametre
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * fonction d attaque.
	 * @param p personnage Hero/Ennemi qui est attaque
	 */
	public void attaque(Personnage p) {
		int degatPrimaire =  this.force + this.niveau;
		int vitesseDAttaque = this.vitesseAttaque;
		int degat = 0;
		if (this.armeDroite != null) {
			degat = (this.armeDroite.getDegat() + degatPrimaire) * vitesseDAttaque;
		}
		else {
			degat =  degatPrimaire * vitesseDAttaque;
		}
		p.setDegat(degat);
	}
	
	/**
	 *  set les parametre de base du personnage.
	 *  @param classe : classe
	 *  @param endurance : points d endurance
	 *  @param vie : points de vie
	 *  @param force : points de force
	 *  @param armeDroite : arme
	 *  @param vitesseAttaque : vitesse d attaque
	 */
	public void setUpPersonnage(String classe, int endurance, int vie, int force, Arme armeDroite, int vitesseAttaque){
		this.classe = classe;
		this.endurance = endurance;
		this.vie = vie;
		this.force = force;
		this.armeDroite = armeDroite;
		this.vitesseAttaque = vitesseAttaque;
	}
	
	/**
	 * applique les degats a l ennemi.
	 * @param d > 0
	 */
	public void setDegat(int d) {
		this.vie -= d;
		if (this.vie <= 0) {
			this.setVie(0);
			this.setEtat("mort");
		}
	}

}
