package info;

//import java.util.ArrayList;

/**
 * @author Louis & Philemon & Justin.
 *
 */
public class Personnage {
	
	/**
	 * Variables caracteristiques d une instance Personnage.
	 */
	
	/**
	 * nom de la classe.
	 */
	protected String classe;
	/**
	 * nombre de points de vie.
	 */
	protected int vie;
	/**
	 * nombre de force (+grand = +fort).
	 */
	protected int force;
	/**
	 * endurance caracterise la vie.
	 */
	protected int endurance;
	/**
	 * niveau.
	 */
	protected int niveau;
	/**
	 * objet Arme qui est l arme du Personnage.
	 */
	protected Arme armeDroite;
	/**
	 * vitesse d attaque (+grand = +degats par attaque).
	 */
	protected int vitesseAttaque;
	/**
	 * etat mort ou vivant.
	 */
	protected String etat;
	/**
	 * Personnage classique ou evolue.
	 */
	protected String type;

	/**
	 * constructeur sans argument.
	 */
	public Personnage() {
	}
	
	/**
	 * @Getter Niveau.
	 * @return : recupere le niveau
	 */
	public int getNiveau() {
		return niveau;
	}
	
	/**
	 * @Setter Niveau : remplace la valeur de niveau par celle en parametre.
	 * @param niveau : nouveau niveau
	 */
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	
	/**
	 * @Getter Vie.
	 * @return : recupere la vie
	 */
	public int getVie() {
		return vie;
	}
	
	/**
	 * @Setter Vie : remplace la valeur de vie par celle en parametre.
	 * @param vie : nouvelle vie
	 */
	public void setVie(int vie) {
		this.vie = vie;
	}
	
	/**
	 * @Getter Force.
	 * @return : recupere la force
	 */
	public int getForce() {
		return force;
	}
	
	/**
	 * @Setter Force : remplace la valeur de force par celle en parametre.
	 * @param force : nouvelle force
	 */
	public void setForce(int force) {
		this.force = force;
	}
	
	/**
	 * @Getter Endurance.
	 * @return : recupere l endurance
	 */
	public int getEndurance() {
		return endurance;
	}
	
	/**
	 * @Setter Endurance : remplace la valeur d endurance par celle en parametre.
	 * @param endurance : nouvelle endurance
	 */
	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}
	
	/**
	 * @Getter armeDroite.
	 * @return : recupere l armeDroite
	 */
	public Arme getArmeDroite() {
		return armeDroite;
	}
	
	/**
	 * @Setter armeDroite : remplace la valeur d armeDroite par celle en parametre.
	 * @param armeDroite : nouvelle armeDroite
	 */
	public void setArmeDroite(Arme armeDroite) {
		this.armeDroite = armeDroite;
	}
	
	/**
	 * @Getter Classe.
	 * @return : recupere la classe
	 */
	public String getClasse() {
		return this.classe;
	}
	
	/**
	 * @Setter Classe : remplace la valeur de classe par celle en parametre.
	 * @param classe : nouvelle classe
	 */
	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	/**
	 * @Getter vitesseAttaque.
	 * @return : recupere vitesseAttaque
	 */
	public int getVitesseAttaque() {
		return vitesseAttaque;
	}
	
	/**
	 * @Setter vitesseAttaque : remplace la valeur de vitesseAttaque par celle en parametre.
	 * @param vitesseAttaque : nouvelle vitesseAttaque
	 */
	public void setVitesseAttaque(int vitesseAttaque) {
		this.vitesseAttaque = vitesseAttaque;
	}
	
	/**
	 * @Getter Etat.
	 * @return : recupere l etat
	 */
	public String getEtat() {
		return etat;
	}
	
	/**
	 * @Setter Etat : remplace la valeur de etat par celle en parametre.
	 * @param etat : nouvel etat
	 */
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	/**
	 * @Getter Type.
	 * @return : recupere l etat
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * @Setter Type : remplace la valeur de type par celle en parametre.
	 * @param type : nouveau type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * fonction d attaque.
	 * @param p personnage Hero/ennemi qui attaque.
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
	 * set les parametre de base du personnage.
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
