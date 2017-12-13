package info;
import java.util.*;
import java.lang.*;
import java.io.*;
/**
 * 
 * @author louis & justin & philemon
 *
 */
public class JeuVueConsole extends JeuVue implements Observer {
	protected Scanner scan;
	private volatile boolean end = false;
	private int i = 1;
	int playerTurn = 1;
	
	/**
	 * constructeur.
	 * @param j jeu du modele MVC
	 * @param jControl controleur du jeu du modele MVC
	 */
	public JeuVueConsole(Jeu j, JeuController jControl) {
		super(j, jControl);
		update(null, null);
		scan = new Scanner(System.in);
		new Thread (new ReadInput()).start();	
	}
	
	/**
	 * 
	 */
	public boolean getEnd() {
		return end;
	}
	
	/**
	 * 
	 */
	public void setEnd(boolean bool) {
		this.end = bool;
	}
	
	/**
	 * 
	 */
	public int getI() {
		return i;
	}
	
	/**
	 * 
	 */
	public void setI(int i) {
		this.i = i;
	}
	
	/**
	 * 
	 */
	public int getPlayerTurn() {
		return playerTurn;
	}
	
	/**
	 * 
	 */
	public void setPlayerTurn(int playerTurn) {
		this.playerTurn = playerTurn;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		//System.out.println(j);
		//printHelp();
		
	}
	/**
	 * affiche l exception en cas de catch.
	 */
	private void printHelpException(){
		this.affiche("Format d'entree non conforme, sans doute une lettre alphabetique.");
	}
	/**
	 * affiche le tutoriel.
	 */
	private void afficheTuto() {
		this.affiche("Vous serez face a des choix pour vous battre ou récolter \n"+"des ressources. "
				+ "Tapez un chiffre entre 0 et 9 pour effectuer votre choix où 9 (est pour afficher "
				+ "votre feuille de personnage) et 0 (pour quitter a tout moment). \n"
				+ "Vous jouez a tour de rôle jusqu'a ce que mort s'en suive ou jusqu'a ce que vous"
				+ " ayez vaincu le Boss maitre du Donjon. \n");
	}
	/**
	 * set la variable end a true pour terminer la partie.
	 */
	private void fin() {
		this.end = true;
	}
	
	/**
	 * @author louis & justin & philemon
	 */
	private class ReadInput implements Runnable{
		//int i = 1;
		//int playerTurn = 1;
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
					
					//var de test
					//jControl.jeu.setDonjonNum(5);
					
					affiche("---------- Votre partie de Beat The Donjon va commencer... ----------");
					afficheTuto();
					
					while (jControl.jeu.getEnVie() > 0 && jControl.jeu.getDonjonNum() <= 5 ) { // boucle des donjons
						jControl.creationDonjons(); // affiche("---------- Création des donjons ... ----------");
													// affiche("---------- Création des vagues d'ennemi ... ----------");
						
						Donjon d = jControl.jeu.getDonj();						
						int vagueNum = 1;
						boolean boss = false;
						/*
						 * variable test direct boss
						int vagueNum = 3;
						boolean boss = true;*/
						
						if (d.getBoss() != null) {
							boss = true;
						}
						while(vagueNum < 3) { // boucle des vagues 1-2
							vague(vagueNum, playerTurn);
							gestionLoot();
							vagueNum++;
						}
						if (!boss) { //vague 3
							vague(vagueNum, playerTurn);
							gestionLoot();
							vagueNum++;
							//jControl.jeu.incDonjonNum();
						}
						else { //boss
							int choixMenuBoss = 1;
							boolean finVague = false;
							while (!finVague && jControl.jeu.getEnVie() != 0 && jControl.jeu.getDonj().getBoss().getEtat().compareTo("vivant") == 0) {
								if (jControl.jeu.getJoueur().get(playerTurn-1).getEtat().compareTo("vivant") == 0 ) {
									afficheTourJoueur(playerTurn);
									jControl.afficheChoixBoss();
									choixMenuBoss = scan.nextInt(); 
									while (!correctEntree(choixMenuBoss, 0)) { 
										choixMenuBoss = scan.nextInt();
									}
									finVague = TourJoueur(0, choixMenuBoss, playerTurn);
								}
								if (playerTurn == 2) { // si tour jour 2 passe => alors tour boss
										tourBoss();
								}
								playerTurn = upTour(playerTurn);
							}
							//jControl.jeu.incDonjonNum();
						}
						
						//gerer loot 
						
						// jControl.gestionLoot un truc dans le genre
						
						//jControl.jeu.setEnVie(0);
						if (jControl.jeu.getEnVie() <= 0) {
							affiche("Vous avez succomber aux forces du Donjon. Vous avez perdu !\n");
						}
						else {
							if(jControl.jeu.getDonjonNum() == 5) {
								gestionLoot();
								affiche("Vous avez suplante les forces du Donjon. Vous avez gagner !\n");
							}
							jControl.jeu.incDonjonNum(); // sortie de boucle des donjons
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
					fin();
				}
				catch(InputMismatchException e){
					affiche("Format d'input incorrect");
					printHelpException();
					System.exit(0);
				}
			}
		}
	}
	
	/**
	 * verifie que le choix existe.
	 * @param i choix du joueur
	 * @param vagueNum determine le nombre de choix
	 * @return true si le choix est valide, false sinon
	 */
	private boolean correctEntree(int i, int vagueNum) {
		if (vagueNum == 0) {  // vagueNum = 0  == menu0 et boss
			if (i < 0 || i > 1) {
				affiche("Choix non disponnible. Faites un nouveau choix.");
				return false;
			}
			return true;
		}
		if (vagueNum == 1) {
			if ((i < 0 || i > 2) || (!jControl.jeu.attaquantEnVie(i, vagueNum))) {
				affiche("Choix non disponnible. Faites un nouveau choix.");
				return false;
			}
			return true;
		}
		if (vagueNum == 2) {
			if (i < 0 || i > 3 || (!jControl.jeu.attaquantEnVie(i, vagueNum))) {
				affiche("Choix non disponnible. Faites un nouveau choix.");
				return false;
			}
			return true;
		}
		if (vagueNum == 3) {
			if (i < 0 || i > 5 || (!jControl.jeu.attaquantEnVie(i, vagueNum))) {
				affiche("Choix non disponnible. Faites un nouveau choix.");
				return false;
			}
			return true;
		}
		if (vagueNum == 4) {  // vagueNum = 4 == choix des personnages
			if (i < 0 || i > 4) {
				affiche("Choix non disponnible. Faites un nouveau choix.");
				return false;
			}
			return true;
		}
		else {
			if (i < 0 || i > 9) {
				affiche("Choix non disponnible. Faites un nouveau choix.");
				return false;
			}
			return true;
		}
	}
	/**
	 * lance l affichage du menu de demarage.
	 */
	private void gestion0() {
		affiche("Voulez-vous vraiment quitter ? y or n");
		String c = scan.next();
		if (c.length() != 1) {
			affiche("Format d'input incorrect");
		}
		switch(c) {
		case "y" :
			fin();
			System.exit(0);
			break;
		/*case "n" :
			System.out.println("Faites un nouveau choix :");
			i = scan.nextInt();
			break;*/
		default :
		}
	}
	/**
	 * gere l entree 9 pour demander la feuille de personnage.
	 */
	private void gestion9() {
		System.out.println("---------- Affichage de feuille de personnage ----------");
		System.out.println("1 : Feuille personnage joueur 1");
		System.out.println("2 : Feuille personnage joueur 2");
		int choix = scan.nextInt();
		while (choix != 1 && choix != 2) {
			System.out.println("Choix indisponible, resaisissez votre choix :");
			choix = scan.nextInt();
		}
		jControl.afficheFeuillePersonnages(choix);
	}
	/**
	 * gere le menu de demarage.
	 * @param i etape du jeu.
	 */
	private void gestionMenu0(int i) {
		while (!correctEntree(i, 0)) {
			i = scan.nextInt();
		}
		if (i == 0) {
			gestion0();
		}
		jControl.menu(i,1);
		i++;
		/*if (i == 1) {
			jControl.menu(i,1);
			i++;
		}*/
	}
	/**
	 * gere l affichage du choix de personnage joueur 1
	 * @param i etape du jeu
	 */
	private void gestionMenu1(int i) {
		while (!correctEntree(i, 4)) {
			i = scan.nextInt();
		}
		if (i == 0) {
			gestion0();
			jControl.printTextMenu(2,1);
			i = scan.nextInt();
		}
		//jControl.printTextMenu(2,1);	
		jControl.choixPersonnage(i);
		/*else {
			jControl.choixPersonnage(i);
		}*/
		jControl.printTextMenu(2,2);
		i++;
	}
	/**
	 * gere l affichage du choix de personnage joueur 2
	 * @param i etape du jeu
	 */
	private void gestionMenu2(int i) {
		while (!correctEntree(i, 4)) {
			i = scan.nextInt();
		}
		if (i == 0) {
			gestion0();
			jControl.printTextMenu(2,2);
			i = scan.nextInt();
		}
		/*else {
			jControl.choixPersonnage(i);
		}*/
		jControl.choixPersonnage(i);
		i++;
	}
	
	/**
	 * lance un vague d ennemi et le tour des joueurs.
	 * @param vagueNum vague actuelle.
	 * @param playerTurn numero du joueur courant.
	 */
	public void vague(int vagueNum, int playerTurn) {
		int choixMob = 1;
		boolean finVague = false;
		while (!finVague && jControl.jeu.getEnVie() != 0) {
			if (jControl.jeu.getJoueur().get(playerTurn-1).getEtat().compareTo("vivant") == 0 ) {
				afficheTourJoueur(playerTurn);
				jControl.afficheVague(vagueNum);
				choixMob = scan.nextInt();
				if (choixMob == 9) {gestion9();}
				if (choixMob == 0) {gestion0();}
				while (!correctEntree(choixMob, vagueNum)) {
					choixMob = scan.nextInt();
				}
				finVague = TourJoueur(vagueNum, choixMob, playerTurn);
			}
			if (playerTurn == 2) { // si tour jour 2 passe => alors tour mob
				tourMob(vagueNum);
			}
			playerTurn = upTour(playerTurn);
		}
	}
	/**
	 * resoud le combat.
	 * @param vagueNum > 0 && <= 3
	 * @param choixMob
	 * @param joueurNum 1 || 2
	 * @return
	 */
	private boolean TourJoueur(int vagueNum, int choixMob, int joueurNum) {
		if (choixMob == 9) {gestion9();}
		if (choixMob == 0) {gestion0();}
		jControl.combat(vagueNum, choixMob,  joueurNum);
		if (vagueNum != 0) {
			if (jControl.jeu.checkVagueClean(vagueNum)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			if (jControl.jeu.getDonj().getBoss().getEtat().compareTo("mort") == 0) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	/**
	 * update le tour du joueur.
	 * @param t joueur actuel.
	 * @return le numero du prochain joueur a jouer.
	 */
	private int upTour(int t) {
		if (t == 2) {return 1;}
		if (t == 1) {return 2;}
		else {return 1;}
	}
	/**
	 * affiche le joueur devant jouer.
	 * @param jTour numero du joueur.
	 */
	private void afficheTourJoueur(int jTour) {
		affiche("-- JOUEUR " + jTour + " : A vous d'attaquer --");
	}
	/**
	 * lance le tour de l ennemi.
	 * @param vague actuelle de l ennemi.
	 */
	private void tourMob(int vague) {
		jControl.tourMob(vague);
	}
	/**
	 * lanc le tour du boss.
	 */
	private void tourBoss() {
		jControl.tourBoss();
	}
	
	public void gestionLoot() {
		jControl.gestionLoot();
	}

	@Override
	public void affiche(String string) {
		System.out.println(string);
		
	}

}
