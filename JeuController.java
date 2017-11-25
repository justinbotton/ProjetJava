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
			System.out.println("Voulez-vous vraiment quitter ? y or n");
			System.exit(0);
			break;
		case 1 :
			//jControl.methode(i);
			System.out.println("1");
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
		if (i == 0) {
			System.out.println("1 : Jouer");
			System.out.println("2 : Quitter");
			System.out.println("Pour quitter a tout moment, appuyer sur 0.");
			
		}
		else if (i == 1) {
			System.out.println("choix personnage joueur 1 : ");
			System.out.println("1 : Elfe");
			System.out.println("2 : Nain");
			System.out.println("3 : Orque");
			System.out.println("4 : Humain");
		}
	}
	public void choixPersonnage(int i) {
		switch(i){
			case 0 : 
				System.out.println("Voulez-vous vraiment quitter ? y or n");
				break;
			case 1 :
				//jControl.methode(i);
				Hero elfe = new Hero("elfe");
				jeu.ajoutJoueur(elfe);
				System.out.println("elfe");
				break;
			case 2 : 
				Hero nain = new Hero("nain");
				jeu.ajoutJoueur(nain);
				System.out.println("nain");
				//jControl.methode(i);
				break;
			case 3 : 
				Hero orque = new Hero("nain");
				jeu.ajoutJoueur(orque);
				System.out.println("orque");
				//jControl.methode(i);
				break;
			case 4 : 
				Hero humain = new Hero("nain");
				jeu.ajoutJoueur(humain);
				System.out.println("humain");
				//jControl.methode(i);
				break;
			default :
				Hero humain2 = new Hero("nain");
				jeu.ajoutJoueur(humain2);
				jVue.affiche("Operation incorrecte : vous etes par defaut un humain.");
				//printHelp();
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
