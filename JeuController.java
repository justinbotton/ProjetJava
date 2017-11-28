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

	public void menu(int num) {
		switch(num){
		case 0 :
			jVue.affiche("Voulez-vous vraiment quitter ? y or n");
			System.exit(0);
			break;
		case 1 :
			jeu.printMenuText(2);
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
	
	public void printTextMenu(int i){
		if (i == 1) {
			jeu.printMenuText(1);
			
		}
		else if (i == 2) {
			jeu.printMenuText(2);
		}
	}
	public void choixPersonnage(int i) {
		switch(i){
			case 0 : 
				jVue.affiche("Voulez-vous vraiment quitter ? y or n");
				break;
			case 1 :
				jeu.choixPerso(1);
				jVue.affiche("Personnage choisi : Elfe !");
				break;
			case 2 : 
				jeu.choixPerso(2);
				jVue.affiche("Personnage choisi : Nain !");
				break;
			case 3 : 
				jeu.choixPerso(3);
				jVue.affiche("Personnage choisi : Orque !");
				break;
			case 4 : 
				jeu.choixPerso(4);
				jVue.affiche("Personnage choisi : Humain !");
				break;
			default :
				jeu.choixPerso(4);
				jVue.affiche("Personnage par defaut choisi : Humain !");
		}
	}

	public void methode2(int numLivre) {
		//model.rendre(numLivre);
		//vue.affiche("Livre rendu.");
		
		//TODO
	}


	public void addView(JeuVue jVue) {
		this.jVue = jVue;
		
	}
}
