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
					System.out.println(".......... La partie va commencer ..........");
					
					System.out.println(".......... La partie est finie ! ..........");
					ended();
				}
				catch(InputMismatchException e){
					affiche("Format d'input incorrect");
					printHelp();
				}
			}
		}
	}
	private void correctInput(int i) {
		if (i < 0 || i > 9) {
			affiche("entree incorrect (choisissez entre 0-9)");
		}
	}
	private void gestion0(int i) {
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
