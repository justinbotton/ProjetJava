package info;
import java.util.*;
import java.lang.*;
import java.io.*;

public class JeuVueConsole extends JeuVue implements Observer {
	protected Scanner scan;
	
	public JeuVueConsole(Jeu j, JeuController jControl) {
		super(j, jControl);
		update(null, null);
		scan = new Scanner(System.in);
		new Thread (new ReadInput()).start();	
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println(j);
		printHelp();
		
	}
	

	private void printHelp(){
		affiche("toto");
		//affiche("Pour emprunter : E + numero de livre.");
		//affiche("Pour rendre : R + numero de livre.");
	}
	
	private class ReadInput implements Runnable{
		public void run() {
			while(true){
				try{
					String c = scan.next();
					if(c.length()!=1){
						affiche("Format d'input incorrect");
						printHelp();
					}
						
					int i = scan.nextInt();
					if(i<0 || i> 9){
						affiche("Numero du livre incorrect");
						printHelp(); 
					}
					switch(c){
						case "R" :
							//jControl.methode(i);
							break;
						case "E" : 
							//jControl.methode(i);
							break;
						default : 
							affiche("Operation incorrecte");
							printHelp();
					}
				}
				catch(InputMismatchException e){
					affiche("Format d'input incorrect");
					printHelp();
				}
			}
		}
	}


	@Override
	public void affiche(String string) {
		System.out.println(string);
		
	}

}
