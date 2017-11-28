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
		printHelp();
		
	}
	

	private void printHelp(){
		//affiche("toto");
		//affiche("Pour emprunter : E + numero de livre.");
		//affiche("Pour rendre : R + numero de livre.");
	}
	/*private void printTextMenu(int i){
		if (i == 0) {
			System.out.println("1 : Jouer");
			System.out.println("2 : Quitter");
		}
		else if (i == 1) {
			System.out.println("choix personnage joueur 1 : ");
			System.out.println("1 : Elfe");
			System.out.println("2 : Nain");
			System.out.println("3 : Orque");
			System.out.println("4 : Humain");
		}
	}*/
	private void menu(int i, int j) {
		switch(i){
			case 0 : 
				//demander si quitter ou pas
				System.out.println("Voulez-vous vraiment quitter ? y or n");
				String c = scan.next();
				if(c.length()!=1){
					affiche("Format d'input incorrect");
					printHelp();
				}
				switch(c){
					case "y" :
						System.exit(0);
						break;
					case "n" :
						break;
				}
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
				affiche("Operation incorrecte");
				//printHelp();
		}
	}
	private void choixPersonnage(int i,int k) {
		switch(i){
			case 0 : 
				System.out.println("Voulez-vous vraiment quitter ? y or n");
				String c = scan.next();
				if(c.length()!=1){
					affiche("Format d'input incorrect");
					printHelp();
				}
				switch(c){
					case "y" :
						System.exit(0);
						break;
					case "n" :
						break;
				}
				break;
			case 1 :
				//jControl.methode(i);
				Hero elfe = new Hero("elfe");
				j.ajoutJoueur(elfe);
				System.out.println("elfe");
				break;
			case 2 : 
				Hero nain = new Hero("nain");
				j.ajoutJoueur(nain);
				System.out.println("nain");
				//jControl.methode(i);
				break;
			case 3 : 
				Hero orque = new Hero("nain");
				j.ajoutJoueur(orque);
				System.out.println("orque");
				//jControl.methode(i);
				break;
			case 4 : 
				Hero humain = new Hero("nain");
				j.ajoutJoueur(humain);
				System.out.println("humain");
				//jControl.methode(i);
				break;
			default :
				Hero humain2 = new Hero("nain");
				j.ajoutJoueur(humain2);
				affiche("Operation incorrecte : vous etes par defaut un humain.");
				//printHelp();
		}
	}
	private void ended() {
		this.end = true;
	}
	int i = 1;
	private class ReadInput implements Runnable{
		public void run() {
			while(!end){
				try {
					jControl.printTextMenu(i);
					/*String c = scan.next();
					if(c.length()!=1){
						affiche("Format d'input incorrect");
						printHelp();
					}*/
					
					i = scan.nextInt();
					if (i < 0 || i > 9) {
						affiche("entree incorrect");
						printHelp();
						continue;
					}
					if (i == 0) {
						System.out.println("Voulez-vous vraiment quitter ? y or n");
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
							continue;
						default :
							continue;
						}
					}
					if (i == 1) {
						jControl.menu(i);
						i++;
						//continue;
					}
					i = scan.nextInt();
					if (i == 2) {
						System.out.println("choix effectue joueur 1 : ");
						jControl.choixPersonnage(i);
						i++;
					}
					i = scan.nextInt();
					if (i == 3) {
						System.out.println("choix effectue joueur 2 : ");
						jControl.choixPersonnage(i);
						i++;
						//System.out.println("choix personnage joueur 1 : ");
						//choixPersonnage(i);
						continue;
					}
					
					/*
					switch(i){
						case 0 : 
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
							affiche("Operation incorrecte");
							printHelp();
					}*/
				}
				catch(InputMismatchException e){
					affiche("Format d'input incorrect");
					printHelp();
				}
				i++;
			}
		}
	}


	@Override
	public void affiche(String string) {
		System.out.println(string);
		
	}

}
