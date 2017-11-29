package info;
import java.util.*;
import java.lang.*;
import java.io.*;

public class JeuVueConsole extends JeuVue implements Observer {
	protected Scanner scan;
	private volatile boolean end = false;
	private int i = 1;
	
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
		//int i = 1;
		int playerTurn = 1;
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
					
					
					affiche("---------- Votre partie de Beat The Donjon va commencer... ----------");
					affiche("*** Attention, durant vos phases d'attaques, si vous choisissez une ***\n"
							+ "*** proposition n'existant plus, vous perdrez votre tour d'attaque. ***\n");
					
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
							int choixMob = 1;
							boolean endVague = false;
							while (!endVague) {
								displayTurn(playerTurn);
								jControl.afficheVague(vagueNum);
								choixMob = scan.nextInt(); 
								while (!correctInput(choixMob)) { // gerer chiffre 0-9 non compris dans la liste
									choixMob = scan.nextInt();
								}
								
								endVague = resolveFight(vagueNum, choixMob, playerTurn);
								if (playerTurn == 2) { // si tour jour 2 passe => alors tour mob
									mobFight();
								}
								playerTurn = upTurn(playerTurn);
							}
							vagueNum++;
						}
						if (!boss) { //vague 3 + gerer xp
							int choixMob = 1;
							boolean endVague = false;
							while (!endVague) {
								displayTurn(playerTurn);
								jControl.afficheVague(vagueNum);
								choixMob = scan.nextInt();
								while (!correctInput(choixMob)) {
									choixMob = scan.nextInt();
								}
								
								endVague = resolveFight(vagueNum, choixMob, playerTurn); 
								playerTurn = upTurn(playerTurn);
							}
							vagueNum++;
						}
						else { //boss
							
						}
						
						//gerer loot 
						
						// jControl.gestionLoot un truc dans le genre
						
						//jControl.jeu.setEnVie(0);
						if (jControl.jeu.getEnVie() <= 0) {
							affiche("Vous avez succomber aux forces du Donjon. Vous avez perdu !");
						}
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
	private boolean correctInput(int i) {
		if (i < 0 || i > 9) {
			affiche("Choix non disponnible.");
			return false;
		}
		return true;
	}
	private void gestion0() {
		
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
				i = scan.nextInt();
			default :
			}
		
	}
	private void gestionMenu0(int i) {
		correctInput(i);
		if (i == 0) {
			gestion0();
		}
		if (i == 1) {
			jControl.menu(i,1);
			i++;
		}
	}
	private void gestionMenu1(int i) {
		correctInput(i);
		if (i == 0) {
			gestion0();
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
			gestion0();
		}
		else {
			jControl.choixPersonnage(i);
		}
		i++;
	}
	/**
	 * resoud le combat.
	 * @param vagueNum > 0 && <= 3
	 * @param choixMob
	 * @param joueurNum 1 || 2
	 * @return
	 */
	private boolean resolveFight(int vagueNum, int choixMob, int joueurNum) {
		if (choixMob == 0) {
			gestion0();
		}
		jControl.combat(vagueNum, choixMob,  joueurNum);
		if (jControl.allDead(vagueNum)) {
			return true;
		}
		else {
			return false;
		}
	}
	private int upTurn(int t) {
		if (t == 2) {return 1;}
		if (t == 1) {return 2;}
		else {return -1;}
	}
	private void displayTurn(int pTurn) {
		affiche("-- JOUEUR " + pTurn + " : A vous d'attaquer --");
	}
	private void mobFight() {
		affiche("mob fight gestion ==> TO DO");
	}
	

	@Override
	public void affiche(String string) {
		System.out.println(string);
		
	}

}
