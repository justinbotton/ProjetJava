package info;

import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * @author louis & justin & philemon
 *
 */
public class Ennemi extends Personnage {
	
	/**
	 * caracteristiques des ennemis
	 */
	
	//Gobelin
	public static final int forceGobelin = 2;
	public static final int enduranceGobelin = 10;
	public static final int vitesseAttaqueGobelin = 1;
	
	//Troll
	public static final int forceTroll = 2;
	public static final int enduranceTroll = 20;
	public static final int vitesseAttaqueTroll = 1;
	
	//Groupe de Gobelins
	public static final int forceGroupeGobelin = 2;
	public static final int enduranceGroupeGobelin = 30;
	public static final int vitesseAttaqueGroupeGobelin = 1;
	
	//Magicien Noir
	public static final int forceMagicienNoir = 3;
	public static final int enduranceMagicienNoir = 15;
	public static final int vitesseAttaqueMagicienNoir = 1;
	
	//Grand mage
	public static final int forceGrandMage = 8;
	public static final int enduranceGrandMage = 400;
	
	//Samourai
	public static final int forceSamourai = 10;
	public static final int enduranceSamourai = 300;
	
	//Icone des personnages
	private ImageIcon icone1;
	private ImageIcon icone2;
	
	//Xp reçu lorsqu un Hero tue un ennemi
	private int xpMob;

	/**
	 * constructeur sans arguments
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
		this.xpMob = 20;
	}
	/**
	 * constructeur avec arguments
	 * @param selectEnnemi : ennemi choisi
	 * @param sommeNiveau :  somme niveau des joueurs
	 */
	public Ennemi(String selectEnnemi, int sommeNiveau) {
		super();
		switch(selectEnnemi) {
			case "gobelin" : 
				setEnnemi(1, sommeNiveau);
				break;
			case "troll" : 
				setEnnemi(2, sommeNiveau);
				break;
			case "groupe gobelin" : 
				setEnnemi(3, sommeNiveau);
				break;
			case "magicien noir" : 
				setEnnemi(4, sommeNiveau);
				break;
			case "grand mage" : 
				setEnnemi(991,sommeNiveau);
				break;
			case "samourai" : 
				setEnnemi(992,sommeNiveau);
				break;
			default : 
				setEnnemi(1, sommeNiveau);
				break;
		}
	}
	
	/**
	 * @Getter XpMob
	 * @return XpMob : xp recue quand un ennemi meurt
	 */
	public int getXpMob() {
		return xpMob;
	}
	
	/**
	 * @Setter XpMob
	 * @param xpMob : remplace l xpMob par celle en parametre
	 */
	public void setXpMob(int xpMob) {
		this.xpMob = xpMob;
	}
	
	/**
	 * @Setter ennemi : permet de creer les ennemis en fonction du random choix
	 * 		   et regle leur force en fonction du niveau des Heros
	 * @param choix est le random qui choisi l ennemi qui fera 
	 * 		  partie de la vague
	 * @param sommeNiveau est un entier pour ajuster les caracteristiques 
	 * 		  des ennemis en fonction du niveau du groupe de joueur
	 */
	public void setEnnemi(int choix, int sommeNiveau) {
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
			Arme armeGob = new Arme("hachette", 3);
			this.setUpPersonnage("gobelin", enduranceGobelin + ajustement, 2 * enduranceGobelin, forceGobelin + ajustement, armeGob, vitesseAttaqueGobelin + ajustVitesse);
			this.xpMob = 20 * this.niveau;
			this.icone1 = new ImageIcon("src/info/img/gobelinB.png");
			//this.icone2 = new ImageIcon("src/info/img/gobelinB2.png");
			break;
			
		case 2 : 
			Arme armeTroll = new Arme("masse", 3);
			this.setUpPersonnage("troll", enduranceTroll + ajustement, 2 * enduranceTroll, forceTroll + ajustement, armeTroll, vitesseAttaqueTroll + ajustVitesse);
			this.xpMob = 40 * this.niveau;
			this.icone1 = new ImageIcon("src/info/img/trollB.png");
			//this.icone2 = new ImageIcon("src/info/img/trollB2.png");
			break;
			
		case 3 : 
			Arme armeGGob = new Arme("hachette", 3);
			this.setUpPersonnage("groupe gobelin", enduranceGroupeGobelin + ajustement, 2 * enduranceGroupeGobelin, forceGroupeGobelin + ajustement, armeGGob, vitesseAttaqueGroupeGobelin + ajustVitesse);
			this.xpMob = 60 * this.niveau;
			this.icone1 = new ImageIcon("src/info/img/groupegobelinB.png");
			//this.icone2 = new ImageIcon("src/info/img/groupegobelinB2.png");
			break;
			
		case 4 : 
			Arme armeMag = new Arme("baton", 3);
			this.setUpPersonnage("magicien noir", enduranceMagicienNoir + ajustement, 2 * enduranceMagicienNoir, forceMagicienNoir + ajustement, armeMag, vitesseAttaqueMagicienNoir + ajustVitesse);
			this.xpMob = 50 * this.niveau;
			this.icone1 = new ImageIcon("src/info/img/magicienB.png");
			//this.icone2 = new ImageIcon("src/info/img/magicienB2.png");
			break;
			
		case 991 :
			// boss 1
			this.classe = "grand mage";
			this.type = "boss";
			this.niveau = ajustement + 1;
			Arme armeGMag = new Arme("baton", 4);
			this.setUpPersonnage("grand mage", enduranceGrandMage + ajustement, 2 * enduranceGrandMage, forceGrandMage + ajustement, armeGMag, 1 + ajustVitesse);
			this.xpMob = 500 * this.niveau;
			this.icone1 = new ImageIcon("src/info/img/grandmageB.png");
			this.icone2 = new ImageIcon("src/info/img/grandmageB2.png");
			break;
			
		case 992 :
			// boss 2
			this.classe = "samourai";
			this.type = "boss";
			this.niveau = ajustement + 1;
			Arme armeSam = new Arme("katana", 5);
			this.setUpPersonnage("samourai", enduranceSamourai + ajustement, 2 * enduranceSamourai, forceSamourai + ajustement, armeSam, 1+ ajustVitesse);
			this.xpMob = 500 * this.niveau;
			this.icone1 = new ImageIcon("src/info/img/samouraiB.png");
			//this.icone2 = new ImageIcon("src/info/img/samouraiB2.png");
			break;
			
		default : 
			Arme armeDefaut = new Arme("hachette", 3);
			this.setUpPersonnage("gobelin", enduranceGobelin + ajustement, 2 * enduranceGobelin, forceGobelin + ajustement, armeDefaut, vitesseAttaqueGobelin + ajustVitesse);
			this.xpMob = 20 * this.niveau;
			this.icone1 = new ImageIcon("src/info/img/gobelinB.png");
			//this.icone2 = new ImageIcon("src/info/img/gobelinB2.png");
			break;
		}
	}
}
