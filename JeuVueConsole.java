package info;
import java.util.*;
import java.lang.*;
import java.io.*;

public class JeuVueConsole extends JeuVue implements Observer {
	protected Scanner scan;
	private volatile boolean end = false;
	
	public JeuVueConsole(Jeu j, JeuController jControl) {
		super(j, jControl);
		update(null, null);
		scan = new Scanner(System.in);
		new Thread (new ReadInput()).start();	
	}
	
	@Override
	public void update(Observable o, Object arg) {
		//System.out.println(j);
		//printHelp();
		
	}

	private void printHelp(){
		this.affiche("Choisissez un chiffre entre 0 et 9");
	}
	private void printTuto() {
		this.affiche("Vous serez face a des choix pour vous battre ou récolter \n"+"des ressources. "
				+ "Tapez un chiffre entre 0 et 9 pour effectuer votre choix \n"
				+ "Vous jouez a tour de rôle jusqu'a ce que mort s'en suive ou \n"
				+ "jusqu'a ce que vous ayez vaincu le Boss maitre du Donjon. \n");
	}
	private void ended() {
		this.end = true;
	}
	
	
	private class ReadInput implements Runnable{
		int i = 1;
		int joueur = 1;
		public void run() {
			while(!end){
				try {
					jControl.printTextMenu(i, 0); //affiche joueur/quitter
					i = scan.nextInt();
					gestionMenu0(i); // gestion joueur/quitter + affiche liste choix joueur 1 
					
					i = scan.nextInt(); //joueur 1 fait son choix
					gestionMenu1(i); // gestion choix joueur 1 + affiche liste choix joueur 2
					
					i = scan.nextInt();
					gestionMenu2(i); // gestion choix joueur 2
					
					
					affiche("---------- La partie va commencer ----------");
					
					while (jControl.jeu.getEnVie() > 0 && jControl.jeu.getDonjonNum() < 5 ) { // boucle des donjons
						jControl.creationDonjons(); // affiche("---------- Création des donjons ... ----------");
													// affiche("---------- Création des vagues d'ennemi ... ----------");
						
						Donjon d = jControl.jeu.getDonj();
						int vagueNum = 1;
						boolean boss = false;
						if (d.getBoss() != null) {
							boss = true;
						}
						while(vagueNum < 3) { // boucle des vagues 1-2 + gere xp
							int choixMob = 0;
							boolean endVague = false;
							while (!endVague) {
								jControl.afficheVague(vagueNum);
								choixMob = scan.nextInt(); //==> gere le zero ligne gestion0 en dessous marche pas pour ici
								//gestion0(choixMob);
								jControl.combat(vagueNum, choixMob,  1); //1 est le num joueur => a traiter
								if (jControl.allDead(vagueNum)) {
									endVague = true;
								}
							}
							vagueNum++;
						}
						if (!boss) { //vague 3 + gerer xp
							
						}
						else { //boss
							
						}
						
						//gerer loot 
						
						// jControl.gestionLoot un truc dans le genre

					}
					
					
					/* TEST POUR COMPRENDRE UN TRUC
					 * Hero h = jControl.jeu.getJoueur().get(0);
					h.setForce(8000000);
					//jControl.jeu.getJoueur().add(h);
					for (Hero u : jControl.jeu.getJoueur()) {
						System.out.println(u.getForce());
					}*/
					
					affiche("---------- La partie est finie ! ----------");
					ended();
				}
				catch(InputMismatchException e){
					//affiche("Format d'input incorrect");
					//printHelp();
					//System.exit(0);
				}
			}
		}
	}
	private void correctInput(int i) {
		if (i < 0 || i > 9) {
			affiche("Choix non disponnible.");
		}
	}
	private void gestion0(int i) {
		
			affiche("Voulez-vous vraiment quitter ? y or n");
			String c = scan.next();
			if (c.length() != 1) {
				affiche("Format d'input incorrect");
			}
			switch(c) {
			case "y" :
				ended();
				System.exit(0);
				break;
			case "n" :
			default :
			}
		
	}
	private void gestionMenu0(int i) {
		correctInput(i);
		if (i == 0) {
			gestion0(0);
		}
		if (i == 1) {
			jControl.menu(i,1);
			i++;
		}
	}
	private void gestionMenu1(int i) {
		correctInput(i);
		if (i == 0) {
			gestion0(0);
		}
		else {
			jControl.choixPersonnage(i);
		}
		jControl.printTextMenu(2,2);
		i++;
	}
	private void gestionMenu2(int i) {
		correctInput(i);
		if (i == 0) {
			gestion0(0);
		}
		else {
			jControl.choixPersonnage(i);
		}
		i++;
	}
	
	

	@Override
	public void affiche(String string) {
		System.out.println(string);
		
	}

}
