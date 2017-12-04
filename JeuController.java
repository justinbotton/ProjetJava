/**
 * 
 */
package info;

import java.util.Scanner;

/**
 * @author louis & philemon & justin
 *
 */
public class JeuController {

	Jeu jeu;
	JeuVue jVue;
	/**
	 * 
	 */
	public JeuController(Jeu jeu) {
		this.jeu = jeu;
	}

	public void menu(int num, int joueur) {
		switch(num){
		case 0 :
			//jVue.affiche("Voulez-vous vraiment quitter ? y or n");
			jeu.printMenuText(2, joueur);
			//System.exit(0);
			break;
		case 1 :
			jeu.printMenuText(2, joueur);
			break;
		case 2 : 
			System.exit(0);
			//jControl.methode(i);
			break;
		default : 
			jVue.affiche("Operation incorrecte");
			//printHelp();
	}
	
	}
	
	public void printTextMenu(int i, int joueur){
		if (i == 1) {
			jeu.printMenuText(1, joueur);
			
		}
		else if (i == 2) {
			jeu.printMenuText(2, joueur);
		}
	}
	public void choixPersonnage(int i) {
		switch(i){
			case 1 :
				jeu.choixPerso(1);
				jVue.affiche("Personnage choisi : Elfe !\n");
				break;
			case 2 : 
				jeu.choixPerso(2);
				jVue.affiche("Personnage choisi : Nain !\n");
				break;
			case 3 : 
				jeu.choixPerso(3);
				jVue.affiche("Personnage choisi : Orque !\n");
				break;
			case 4 : 
				jeu.choixPerso(4);
				jVue.affiche("Personnage choisi : Humain !\n");
				break;
			default :
				jeu.choixPerso(4);
				jVue.affiche("Personnage par defaut choisi : Humain !\n");
		}
	}

	public void creationDonjons() {
		jeu.creationDonjons();
		int num = jeu.getDonjonNum();
		if (num < 5) {
			jVue.affiche("---------- Création du donjon " + jeu.getDonjonNum() + " ... ----------");
			jVue.affiche("---------- Création des 3 vagues d'ennemi ... ----------\n");
			histoire(num);
		}
		if (num == 5) {
			jVue.affiche("---------- Création du donjon 5 ... ----------");
			jVue.affiche("---------- Création des 2 vagues d'ennemis ... ----------");
			jVue.affiche("---------- Création du boss ... ----------\n");
		}
	}
	public void combat(int vagueNum,int choixMob, int joueurNum) {
		String s = jeu.combat(vagueNum, choixMob, joueurNum);
		if (s.compareTo("mort") == 0) {
			int xp = jeu.xpRecu(vagueNum, choixMob);
			jVue.affiche("Votre coup a tué votre ennemi. Vous gagnez " + xp +" xp.\n");
			/* pour debug
			 * Integer no = new Integer(jeu.getJoueur().get(0).getXp());
			Integer niv = new Integer(jeu.getJoueur().get(0).getNiveau());
			jVue.affiche("xp : " + no.toString());
			jVue.affiche("niveau : " + niv.toString());*/
			if (jeu.checkVagueClean(vagueNum)) {
				jVue.affiche("Pièce clean. Vous avez annéanti les forces ennemies qui entravaient votre chemin.");
				jVue.affiche("Vous passez donc dans la pièce suivante !\n");
			}
		}
		else {
			Hero h = jeu.getJoueur().get(joueurNum-1);
			int degatPrimaire =  h.getForce() + h.getNiveau();
			int degat = (h.getArmeDroite().getDegat() + degatPrimaire) * h.getVitesseAttaque();
			jVue.affiche("Votre ennemi n'a pas succombé à votre attaque mais vous lui avez infligé " + degat +" points de degats !\n");
		}
	}
	public void afficheVague(int vagueNum) {
		jVue.affiche("Quel ennemi allez vous attaquer ?");
		jeu.afficheVague(vagueNum);
	}
	public void afficheChoixBoss() {
		jVue.affiche("Attaquez ce boss !");
		jeu.afficheChoixBoss();
	}
	public void histoire(int num) {
		if (num == 1) {
			jVue.affiche("Vous arrivez face à votre premier donjon. Serez-vous assez fort que pour vaincre ceux qui l'habite ?");
			jVue.affiche("Vous poussez la porte d'entrée et arrivez dans une première salle.\n");
		}
		if (num == 2) {
			jVue.affiche("Vous avez vaincu votre premier donjon. Mais ne vous reposez pas, le suivant vous attend !");
			jVue.affiche("A peine passé la porte, des ennemis vous repèrent. BASTON !\n");
		}
		if (num == 3) {jVue.affiche("toto1");}	// TODO 
		if (num == 4) {jVue.affiche("toto2");}	// TODO 
		if (num == 5) {jVue.affiche("toto3");}	// TODO 
	}
	
	public void tourMob(int vague) {
		if (!jeu.checkVagueClean(vague)) {
			String etatJoueur = jeu.combatMob(vague);
			if (etatJoueur.compareTo("mort") == 0) {
				jVue.affiche("Vous n'avez pas été assez résistant, joueur " + jeu.getJoueurMort() + " ! Vous etes mort dans d'attroces souffrances... \n");
				jeu.mortDUnJoueur();
			}
		}
	}
	/* plus necessaire, meme code que checkvagueclean()
	 * public boolean encoreMob(int vague) {
		for (Ennemi e : jeu.getDonj().getPopVague(vague)) {
			if (e.getEtat().compareTo("vivant") == 0) {
				return true;
			}
		}
		return false;
	}*/
	
	public void tourBoss() {
		if (jeu.getDonj().getBoss().getEtat().compareTo("vivant") == 0) {
			String etatJoueur = jeu.combatBoss();
			if (etatJoueur.compareTo("mort") == 0) {
				jVue.affiche("Vous n'avez pas été assez résistant, joueur " + jeu.getJoueurMort() + " ! Vous etes mort dans d'attroces souffrances... \n");
				jeu.mortDUnJoueur();
			}
		}
	}
	public void afficheFeuillePersonnages(int choix) {
		Hero h = jeu.getJoueur().get(choix-1);
		System.out.println("Feuille de personnage du joueur " + choix + " : ");
		System.out.println("Classe : " + h.getClasse());
		System.out.println("Niveau : " + h.getNiveau());
		System.out.println("Force : " + h.getForce());
		System.out.println("Vie : " + h.getVie());
		System.out.println("Endurance : " + h.getEndurance());
		System.out.println("xp : " + h.getXp());
		System.out.println("Arme : " + h.getArmeDroite().getNom());
		System.out.println("Etat : " + h.getEtat());
		System.out.println("---------- Retour au combat ----------\n");
		
	}
	
	
	public void addView(JeuVue jVue) {
		this.jVue = jVue;
		
	}
}
