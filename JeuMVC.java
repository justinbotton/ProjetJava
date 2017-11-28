/**
 * 
 */
package info;

/**
 * @author louis & philemon & justin
 * On a repris la struture vue au tp pour la structuration des modeles.
 */
public class JeuMVC {
	
	Jeu j;
	JeuController jControlGUI;
	JeuController jControlConsole;
	JeuVueConsole jConsole;
	JeuVueGUI jGUI;
	
	public JeuMVC() {
		//Creation du modele
		
		 j = new Jeu();
		 //j.setNombreJoueur(2);

		//Creation des controleurs : Un pour chaque vue
		//Chaque controleur doit avoir une reference vers le modele pour pouvoir le commander
		
		 jControlGUI = new JeuController(j);
		 jControlConsole = new JeuController(j);
				 
		//Creation des vues.
		//Chaque vue doit connaitre son controleur et avoir une reference vers le modele pour pouvoir l'observer
		
		 //jGUI = new JeuVueGUI(j, jControlGUI);
		 jConsole = new JeuVueConsole(j, jControlConsole);
		
		//On donne la reference à la vue pour chaque controleur
		
		 //jControlGUI.addView(jGUI);
		 jControlConsole.addView(jConsole);
		
		
	}
	
	public static void main(String args[]) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JeuMVC();
				//System.out.println("coucou2");
			}
		});
	}

}
