/**
 * 
 */
package info;

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

	public void methode1(int numLivre) {
		// TODO
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
