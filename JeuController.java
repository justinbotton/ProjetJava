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
		if (jeu.getDonjonNum() < 5) {
			jVue.affiche("---------- Création du donjon " + jeu.getDonjonNum() + " ... ----------");
			jVue.affiche("---------- Création des 3 vagues d'ennemi ... ----------\n");
		}
		if (jeu.getDonjonNum() == 5) {
			jVue.affiche("---------- Création du donjon " + jeu.getDonjonNum() + " ... ----------");
			jVue.affiche("---------- Création des 2 vagues d'ennemi ... ----------");
			jVue.affiche("---------- Création du boss ... ----------\n");
		}
	}

	public void addView(JeuVue jVue) {
		this.jVue = jVue;
		
	}
}
