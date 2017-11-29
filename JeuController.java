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
			jVue.affiche("Voulez-vous vraiment quitter ? y or n");
			System.exit(0);
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
			story(num);
		}
		if (num == 5) {
			jVue.affiche("---------- Création du donjon 5 ... ----------");
			jVue.affiche("---------- Création des 2 vagues d'ennemi ... ----------");
			jVue.affiche("---------- Création du boss ... ----------\n");
		}
	}
	public void combat(int vagueNum,int choixMob, int joueurNum) {
		String s = jeu.combat(vagueNum, choixMob, joueurNum);
		if (s.compareTo("mort") == 0) {
			jVue.affiche("Votre coup a tué votre ennemi.\n");
			if (jeu.checkVagueClean(vagueNum)) {
				jVue.affiche("Pièce clean. Vous avez annéanti les forces ennemies qui entravaient votre chemin.");
				jVue.affiche("Vous passez donc dans la pièce suivante !\n");
			}
		}
		else {
			jVue.affiche("Votre ennemi n'a pas succombé à votre attaque.\n");
		}
	}
	public boolean allDead(int vagueNum) {
		if (vagueNum == 1) {
			for (Ennemi e : jeu.getDonj().getVague1()) {
				if (e.getEtat().compareTo("vivant") == 0) {
					return false;
				}
			}
		}
		else if (vagueNum == 2) {
			for (Ennemi e : jeu.getDonj().getVague2()) {
				if (e.getEtat().compareTo("vivant") == 0) {
					return false;
				}
			}
		}
		else if (vagueNum == 3) {
			for (Ennemi e : jeu.getDonj().getVague3()) {
				if (e.getEtat().compareTo("vivant") == 0) {
					return false;
				}
			}
		}
		return true;
	}
	public void afficheVague(int vagueNum) {
		jVue.affiche("Quel ennemi allez vous attaquer ?");
		jeu.afficheVague(vagueNum);
	}
	public void story(int num) {
		if (num == 1) {
			jVue.affiche("Vous arrivez face à votre premier donjon. Serez-vous assez fort que pour vaincre ceux qui l'habite ?");
			jVue.affiche("Vous poussez la porte d'entrée et arrivez dans une première salle.\n");
		}
		if (num == 2) {
			jVue.affiche("Vous avez vaincu votre premier donjon. Mais ne vous reposez pas, le suivant vous attend !");
			jVue.affiche("A peine passé la porte, des ennemis vous repèrent. BASTON !\n");
		}
		if (num == 3) {jVue.affiche("toto1");}
		if (num == 4) {jVue.affiche("toto2");}
		if (num == 5) {jVue.affiche("toto3");}
	}

	public void addView(JeuVue jVue) {
		this.jVue = jVue;
		
	}
}
