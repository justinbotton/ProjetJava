/**
 * 
 */
package info;

/**
 * @author Louis & Justin & Philemon
 *
 */
public class HeroEvolue extends Hero{
	
	private String armeGauche;
	/**
	 * 
	 */
	public HeroEvolue() { }
	
	/**
	 * 
	 * @param selectHero = hero choisi par le player
	 */
	public HeroEvolue(String selectHero) {
		super(selectHero);
		switch(selectHero)
		{
			case "Elfe" : 
				System.out.print("Et je viens d'évoluer en Elfe des forêts noires !! ");
				System.out.println("Je gagne +3 en force, +2 en endurance "
						+ "et je peux tirer deux fois plus vite.");
				super.setForce(super.getForce() + 3);
				super.setEndurance(super.getEndurance() + 2);
				super.setVitesseAttaque(getVitesseAttaque() * 2);
				System.out.println("new endurance = " + super.getEndurance() + " !");
				System.out.println("new force = " + super.getForce() + " !");
				System.out.println("new vitesse d'attaque = " + super.getVitesseAttaque() + " !");
				break;
			case "Nain" : 
				System.out.print("Et je viens d'évoluer en Nain des montagnes !! ");
				System.out.println("Je gagne +2 en force, +4 en endurance "
						+ "et je peux porter deux fois plus d'objets/armes.");
				super.setForce(super.getForce() + 2);
				super.setEndurance(super.getEndurance() + 4);
				super.setTailleInventaireArme(getTailleInventaireArme() * 2);
				System.out.println("new endurance = " + super.getEndurance() + " !");
				System.out.println("new force = " + super.getForce() + " !");
				System.out.println("new capacité inventaire = " + super.getTailleInventaireArme() + " !");
				break;
			case "Orque" : 
				this.armeGauche = "masse";
				break;
			case "Humain" : 
				this.armeGauche = "epee";
				
				break;
			default : 
				this.armeGauche = "epee";
				break;
		}
		
	}

	/**
	 * @param args .
	 */
	public static void main(String[] args) {
		HeroEvolue champion = new HeroEvolue("Nain");
		System.out.println(champion.attaque());
		//System.out.println(champion.getClasse());

	}

}
