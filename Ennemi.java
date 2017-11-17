
import java.util.ArrayList;

/**
 * @author louis & justin & philemon
 *
 */
public class Ennemi extends Personnage {
	
	public static final int forceGobelin = 2;
	public static final int enduranceGobelin = 10;
	public static final int vitesseAttaqueGobelin = 1;
	public static final int forceTroll = 2;
	public static final int enduranceTroll = 20;
	public static final int vitesseAttaqueTroll = 1;
	public static final int forceGroupeGobelin = 2;
	public static final int enduranceGroupeGobelin = 30;
	public static final int vitesseAttaqueGroupeGobelin = 1;
	public static final int forceMagicienNoir = 3;
	public static final int enduranceMagicienNoir = 15;
	public static final int vitesseAttaqueMagicienNoir = 1;
	public static final int forceGrandMage = 5;
	public static final int enduranceGrandMage = 50;
	//public static final int vitesseAttaqueGrandMage = 1; pas utile
	public static final int forceSamourai = 8;
	public static final int enduranceSamourai = 40;
	

	/**
	 * Constructeur Ennemi
	 */
	public Ennemi() {
		super();
		this.classe = "gobelin";
		this.type = "mob";
		this.force = forceGobelin;
		this.endurance = enduranceGobelin;
		this.vie = 2 * this.endurance;
		this.armeDroite = new Arme("hachette", 3);
		this.vitesseAttaque = vitesseAttaqueGobelin;
		this.niveau = 1;
		this.etat = "vivant";
	}
	/**
	 * Constructeur Ennemi avec deux arguments
	 */
	public Ennemi(String selectEnnemi, int sommeNiveau) {
		switch(selectEnnemi) {
			case "gobelin" : 
				new Ennemi(1, sommeNiveau);
				break;
			case "troll" : 
				new Ennemi(2, sommeNiveau);
				break;
			case "groupe gobelin" : 
				new Ennemi(3, sommeNiveau);
				break;
			case "magicien noir" : 
				new Ennemi(4, sommeNiveau);
				break;
			/*case "boss" : 
				new Ennemi(991,sommeNiveau);
				break;*/
			default : 
				new Ennemi(1, sommeNiveau);
				break;
		}
	}
	/**
	 * @param choix est le random qui choisi l ennemi qui fera 
	 * 		partie de la vague
	 * @param sommeNiveau est un entier pour ajuster les caracteristiques 
	 * 		des ennemis en fonction du niveau du groupe de joueur
	 */
	public Ennemi(int choix, int sommeNiveau) {
		int ajustement = (int) (sommeNiveau / 2);
		int ajustVitesse = (int) (ajustement / 4);
		this.etat = "vivant";
		if (ajustement != 0) {
			this.niveau =  ajustement;
		}
		else {
			this.niveau = 1;
		}
		this.type = "mob";
		switch(choix) {
		case 1 : 
			//System.out.println("Vous affrontez un goblein !!");
			Arme armeGob = new Arme("hachette", 3);
			this.setUpPersonnage("gobelin", enduranceGobelin + ajustement, 2 * enduranceGobelin, forceGobelin + ajustement, armeGob, vitesseAttaqueGobelin + ajustVitesse);
			break;
		case 2 : 
			//System.out.println("Vous affrontez un troll !!");
			Arme armeTroll = new Arme("masse", 3);
			this.setUpPersonnage("troll", enduranceTroll + ajustement, 2 * enduranceTroll, forceTroll + ajustement, armeTroll, vitesseAttaqueTroll + ajustVitesse);
			break;
		case 3 : 
			//System.out.println("Vous affrontez un groupe de gobelin !!");
			Arme armeGGob = new Arme("hachette", 3);
			this.setUpPersonnage("groupe gobelin", enduranceGroupeGobelin + ajustement, 2 * enduranceGroupeGobelin, forceGroupeGobelin + ajustement, armeGGob, vitesseAttaqueGroupeGobelin + ajustVitesse);
			break;
		case 4 : 
			//System.out.println("Vous affrontez un magicien noir !!");
			Arme armeMag = new Arme("baton", 3);
			this.setUpPersonnage("magicien noir", enduranceMagicienNoir + ajustement, 2 * enduranceMagicienNoir, forceMagicienNoir + ajustement, armeMag, vitesseAttaqueMagicienNoir + ajustVitesse);
			break;
		case 991 :
			// boss 1
			this.classe = "grand mage";
			this.type = "boss";
			this.niveau = ajustement + 1;
			Arme armeGMag = new Arme("baton", 4);
			this.setUpPersonnage("gobelin", enduranceGrandMage + ajustement, 2 * enduranceGrandMage, forceGrandMage + ajustement, armeGMag, ajustVitesse);
			break;
		case 992 :
			// boss 2
			this.classe = "samourai";
			this.type = "boss";
			this.niveau = ajustement + 1;
			Arme armeSam = new Arme("katana", 5);
			this.setUpPersonnage("gobelin", enduranceSamourai + ajustement, 2 * enduranceSamourai, forceSamourai + ajustement, armeSam, ajustVitesse);
			break;
		default : 
			//System.out.println("Vous affrontez un gobelin !!");
			Arme armeDefaut = new Arme("hachette", 3);
			this.setUpPersonnage("gobelin", enduranceGobelin + ajustement, 2 * enduranceGobelin, forceGobelin + ajustement, armeDefaut, vitesseAttaqueGobelin + ajustVitesse);
			break;
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Ennemi e = new Ennemi(4,5);
		System.out.println(e.getClasse());
		System.out.println(e.force);
		System.out.println(e.vitesseAttaque);
		System.out.println(e.niveau);
		

	}

}
