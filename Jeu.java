/**
 * 
 */
package info;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.JOptionPane;

//import org.postgresql.util.PSQLException;

/**
 * @author louis & justin & philemon
 *
 */
public class Jeu extends Observable {
	private Scanner scan;
	private int enVie;
	private int nombreJoueur;
	private ArrayList<Hero> joueur;
	private boolean inGame = false;
	//private ArrayList<Donjon> donjons14;
	private Donjon donj;
	private int joueurMort;
	int donjonNum = 1;
	boolean sauvegarde = false;
	boolean charger = false;

	/**
	 *  constructeur de jeu
	 */
	public Jeu() {
		/*Hero h = new Hero();
		String[] args = null;
		h.main(args);*/
		joueur = new ArrayList<Hero>();
		/*if(sauvegarde) {
			chargerTbJeuModele();
			chargerTbJoueur();
		} else {*/
			this.enVie = 2;
			this.nombreJoueur = 2;
			
			//donjons14 = new ArrayList<Donjon>();
		//}
		
	}

	public int getEnVie() {
		return enVie;
	}
	public void setEnVie(int enVie) {
		this.enVie = enVie;
	}
	public int getNombreJoueur() {
		return nombreJoueur;
	}
	public void setNombreJoueur(int nombreJoueur) {
		this.nombreJoueur = nombreJoueur;
	}
	public ArrayList<Hero> getJoueur() {
		return joueur;
	}
	public void setJoueur(ArrayList<Hero> joueur) {
		this.joueur = joueur;
	}
	public void ajoutJoueur(Hero h) {
		this.joueur.add(h);
	}
	public Donjon getDonj() {
		return donj;
	}
	public void setDonj(Donjon donj) {
		this.donj = donj;
	}
	public int getDonjonNum() {
		return donjonNum;
	}
	public void setDonjonNum(int donjonNum) {
		this.donjonNum = donjonNum;
	}
	public boolean isInGame() {
		return inGame;
	}
	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}
	public int getJoueurMort() {
		return joueurMort;
	}
	public void setJoueurMort(int joueurMort) {
		this.joueurMort = joueurMort;
	}
	
	/**
	 * charge elements table tbJeuModele
	 */
	public void chargerTbJeuModele() {
		Connection connection = null;
  		Statement select = null;
  		ResultSet query = null;
  		try {
  			Class.forName("org.postgresql.Driver");
  			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjetJava", "postgres", "sql");
  			select = connection.createStatement();
			query = select.executeQuery("SELECT * FROM tbJeuModele");
			int jeuEnVie = 0;
			int jeuNombreJoueur = 0;
			boolean jeuInGame = false;
			int jeuJoueurMort = 0;
			int jeuDonjonNum = 0;
			while(query.next()) {
				jeuEnVie = query.getInt("jeuEnVie");
				jeuNombreJoueur = query.getInt("jeuNombreJoueur");
				jeuInGame = query.getBoolean("jeuInGame");
				jeuJoueurMort = query.getInt("jeuJoueurMort");
				jeuDonjonNum = query.getInt("jeuDonjonNum");
			}
		    this.setEnVie(jeuEnVie);
		    this.setNombreJoueur(jeuNombreJoueur);
		    this.setInGame(jeuInGame);
		    this.setJoueurMort(jeuJoueurMort);
		    this.setDonjonNum(jeuDonjonNum);
		    query.close();
		    select.close();
		    connection.close();
   		} catch (Exception e) {
		    e.printStackTrace();
		    System.err.println(e.getClass().getName()+" : "+e.getMessage());
   		}
	}
	
	/**
	 * charger elements tbJoueur1 et 2
	 */
	public void chargerTbJoueur() {
		Connection connection = null;
  		Statement select = null;
  		ResultSet query = null;
  		try {
  			Class.forName("org.postgresql.Driver");
  			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjetJava", "postgres", "sql");
  			select = connection.createStatement();
  			for(int i = 1 ; i < 3 ; i++) {
				query = select.executeQuery("SELECT * FROM tbJoueur WHERE joueurNum = "+i);
				int joueurNum = 0;
				String joueurClasse = null;
				int joueurVie = 0;
				int joueurForce = 0;
				int joueurEndurance = 0;
				int joueurNiveau = 0;
				Arme arme = null;
				int joueurVitesseAttaque = 0;
				String joueurEtat = null;
				int joueurXp = 0;
				int joueurVieMax = 0;
				while(query.next()) {
					joueurNum = query.getInt("joueurNum");
					joueurClasse = query.getString("joueurClasse");
					joueurVie = query.getInt("joueurVie");
					joueurForce = query.getInt("joueurForce");
					joueurEndurance = query.getInt("joueurEndurance");
					joueurNiveau = query.getInt("joueurNiveau");
					arme = new Arme(query.getString("joueurArmeDroiteNom"), query.getInt("joueurArmeDroiteDegat"));
					joueurVitesseAttaque = query.getInt("joueurVitesseAttaque");
					joueurEtat = query.getString("joueurEtat");
					joueurXp = query.getInt("joueurXp");
					joueurVieMax = query.getInt("joueurVieMax");
				}
			    Hero hero = new Hero(joueurClasse);
			    hero.setNiveau(joueurNiveau);
			    hero.setVie(joueurVie);
			    hero.setForce(joueurForce);
			    hero.setEndurance(joueurEndurance);
			    hero.setArmeDroite(arme);
			    hero.setVitesseAttaque(joueurVitesseAttaque);
			    hero.setEtat(joueurEtat);
			    hero.setXp(joueurXp);
			    hero.setVieMax(joueurVieMax);
			    joueur.add(hero);
  			}
  			query.close();
		    select.close();
		    connection.close();
   		} catch (Exception e) {
		    e.printStackTrace();
		    System.err.println(e.getClass().getName()+" : "+e.getMessage());
   		}
	}
	
	/**
	 * sauvegarde de l etat des joueurs
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void sauvegarderJoueurs(){
		sauvegarde = true;
		Connection connection = null;
  		PreparedStatement update = null;
  		try {
  			Class.forName("org.postgresql.Driver");
  			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjetJava", "postgres", "sql");
  			Iterator<Hero> iter = joueur.iterator();
  			int i = 1;
  			while(iter.hasNext()) {
  				Hero hero = joueur.get(i-1);
  				int joueurNum = i;
  				String joueurClasse = hero.getClasse();
  				int joueurVie = hero.getVie();
  				int joueurForce = hero.getForce();
  				int joueurEndurance = hero.getEndurance();
  				int joueurNiveau = hero.getNiveau();
  				Arme arme = hero.getArmeDroite();
  				int joueurVitesseAttaque = hero.getVitesseAttaque();
  				String joueurEtat = hero.getEtat();
  				int joueurXp = hero.getXp();
  				int joueurVieMax = hero.getVieMax();
  				String query = "UPDATE tbJoueur SET joueurNum = ?, joueurClasse = ?, joueurVie = ?, joueurForce = ?, "
  						+ "joueurEndurance = ?, joueurNiveau = ?, joueurArmeDroiteNom = ?, joueurArmeDroiteDegat = ?, joueurVitesseAttaque = ?, "
  						+ "joueurEtat = ?, joueurXp = ?, joueurVieMax = ? WHERE joueurNum = "+i;
  				update = connection.prepareStatement(query);
  				update.setInt(1, joueurNum);
  				update.setString(2, joueurClasse);
  				update.setInt(3, joueurVie);
  				update.setInt(4, joueurForce);
  				update.setInt(5, joueurEndurance);
  				update.setInt(6, joueurNiveau);
  				update.setString(7, arme.getNom());
  				update.setInt(8, arme.getDegat());
  				update.setInt(9, joueurVitesseAttaque);
  				update.setString(10, joueurEtat);
  				update.setInt(11, joueurXp);
  				update.setInt(12, joueurVieMax);
  				update.executeUpdate();
  				i++;
  				iter.next();
  			}
			i = 1;
			update.close();
		    connection.close();
  		}catch (Exception e) {
		    e.printStackTrace();
		    System.err.println(e.getClass().getName()+" : "+e.getMessage());
   		}
	}
	
	/**
	 * sauvegarde du modele
	 */
	public void sauvegarderJeuModele() {
		Connection connection = null;
  		PreparedStatement update = null;
  		try {
  			Class.forName("org.postgresql.Driver");
  			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjetJava", "postgres", "sql");
			int jeuEnVie = this.getEnVie();
			int jeuNombreJoueur = this.getNombreJoueur();
			boolean jeuInGame = this.isInGame();
			int jeuJoueurMort = this.getJoueurMort();
			int jeuDonjonNum = this.getDonjonNum();
			String query  = "UPDATE tbJeuModele SET jeuEnVie = ?, jeuNombreJoueur = ?, jeuInGame = ?, jeuJoueurMort = ?, jeuDonjonNum = ?";
			update = connection.prepareStatement(query);
			update.setInt(1, jeuEnVie);
			update.setInt(2, jeuNombreJoueur);
			update.setBoolean(3, jeuInGame);
			update.setInt(4,  jeuJoueurMort);
			update.setInt(5, jeuDonjonNum);
  			update.executeUpdate();
		    update.close();
		    connection.close();
   		} catch (Exception e) {
		    e.printStackTrace();
		    System.err.println(e.getClass().getName()+" : "+e.getMessage());
   		}
	}
	
	/**
	 * decremente la variable enVie lorsque qu un joueur meurt.
	 */
	public void mortDUnJoueur() {
		this.enVie = this.enVie - 1;
		setChanged();
        notifyObservers();
	}
	/**
	 * incremente le numero de donjon.
	 */
	public void incDonjonNum() {
		this.donjonNum = this.donjonNum + 1;
		setChanged();
        notifyObservers();
	}

	/**
	 * ajout le choix de personnage du joueur a la liste des joueurs.
	 * @param i appartient [1,2,3,4]
	 */
	public void choixPerso(int i) {
		switch(i){
			case 1 :
				Hero elfe = new Hero("Elfe");
				this.ajoutJoueur(elfe);
				setChanged();
		        notifyObservers();
				break;
			case 2 : 
				Hero nain = new Hero("Nain");
				this.ajoutJoueur(nain);
				setChanged();
		        notifyObservers();
				break;
			case 3 : 
				Hero orque = new Hero("Orque");
				this.ajoutJoueur(orque);
				setChanged();
		        notifyObservers();
				break;
			case 4 : 
				Hero humain = new Hero("Humain");
				this.ajoutJoueur(humain);
				setChanged();
		        notifyObservers();
				break;
			default :
				Hero humain2 = new Hero("Humain");
				this.ajoutJoueur(humain2);
				setChanged();
		        notifyObservers();
		        break;
		}
	}

	/**
	 * affiche a l ecran console le menu de lancement et change la variable inGame a true si i = 1.
	 * affiche a l ecran le choix de personnage pour les joueurs, sinon.
	 * @param i variable de séquence du jeu
	 * @param joueur  = numero du joueur 
	 */
	public void printMenuText(int i, int joueur){
		if (i == 1 && !inGame) {
			System.out.println("1 : Jouer");
			System.out.println("2 : Charger partie");
			System.out.println("0 : Quitter");
			System.out.println("Pour quitter a tout moment, appuyer sur 0.");
			inGame = true;
			
		}
		else if (i == 2) {
			if (joueur == 1) {
				System.out.println("---------- Création des joueurs ---------- \n");
			}
			System.out.println("Selection du personnage du joueur "+ joueur + ": ");
			System.out.println("1 : Elfe");
			System.out.println("2 : Nain");
			System.out.println("3 : Orque");
			System.out.println("4 : Humain");
		}
	}
	/**
	 * cree les donjon 1 a 4.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void creationDonjons(){
		int sumNiv = 0;
		for (Hero h : this.getJoueur()) {
			sumNiv += h.getNiveau();
		}
		if (donjonNum < 5 && this.getEnVie() > 0) {
			/*Donjon d = new Donjon(sumNiv);
			donjons14.add(d);*/
			donj = new Donjon(sumNiv);
			//donjonNum++;
			setChanged();
	        notifyObservers();
		}
		if (donjonNum == 5) {
			donj = new Donjon("boss", sumNiv);
			setChanged();
	        notifyObservers();
		}
		//sauvegarderJoueurs();
		//sauvegarderJeuModele();
	}
	
	/**
	 * @param vagueNum > 0 & <=3.
	 * @param choixMob >0 & <= 2 pour vague1, <= 3 pour vague2, <= 5 pour vague3
	 * @param joueurNum est le numero du joueur 1 || 2
	 */
	public String combat(int vagueNum,int choixMob, int joueurNum) {
		if (vagueNum == 0) {
			this.joueur.get(joueurNum-1).attaque(donj.getBoss());
			setChanged();
	        notifyObservers();
	        return donj.getBoss().getEtat();
		}
		if (vagueNum <= 3){
			//Hero he = this.joueur.get(joueurNum-1);
			//Ennemi e = donj.getVague1()[choixMob - 1];
			this.joueur.get(joueurNum-1).attaque(donj.getPopVague(vagueNum)[choixMob - 1]);
			setChanged();
	        notifyObservers();
	        return donj.getPopVague(vagueNum)[choixMob - 1].getEtat();
		}
		return "mauvais numéro de vague";
	}
	
	/**
	 *  check si il reste des ennemis en vie.
	 * @param vagueNum numero de la vague d ennemi courante.
	 * @return true si il n y a plus d ennemi en vie dans la vague, false sinon.
	 */
	public boolean checkVagueClean(int vagueNum) {
		for (Ennemi en : this.getDonj().getPopVague(vagueNum)) {
			if (en.getEtat().compareTo("vivant") == 0) {return false;}
		}
		return true;
	}
	
	/**
	 *  affiche les ennemis presents selon le numero de vague.
	 * @param vagueNum = le numero de vague courant.
	 */
	public void afficheVague(int vagueNum) {
		if (vagueNum == 1) {
			Ennemi[] vag = this.getDonj().getVague1();
			if (vag[0].getEtat().compareTo("vivant") == 0) {System.out.println("1 : " + vag[0].getClasse());}
			if (vag[1].getEtat().compareTo("vivant") == 0) {System.out.println("2 : " + vag[1].getClasse());}
			if (vag[0].getEtat().compareTo("mort") == 0 && (vag[1].getEtat().compareTo("mort") == 0)) {
				System.out.println("vague terminee !");
			}
		}
		if (vagueNum == 2) {
			Ennemi[] vag = this.getDonj().getVague2();
			if (vag[0].getEtat().compareTo("vivant") == 0) {System.out.println("1 : " + vag[0].getClasse());}
			if (vag[1].getEtat().compareTo("vivant") == 0) {System.out.println("2 : " + vag[1].getClasse());}
			if (vag[2].getEtat().compareTo("vivant") == 0) {System.out.println("3 : " + vag[2].getClasse());}
			if (vag[0].getEtat().compareTo("mort") == 0 && (vag[1].getEtat().compareTo("mort") == 0) 
					&& (vag[2].getEtat().compareTo("mort") == 0)) {
				System.out.println("vague terminee !");
			}
		}
		if (vagueNum == 3) {
			Ennemi[] vag = this.getDonj().getVague3();
			if (vag[0].getEtat().compareTo("vivant") == 0) {System.out.println("1 : " + vag[0].getClasse());}
			if (vag[1].getEtat().compareTo("vivant") == 0) {System.out.println("2 : " + vag[1].getClasse());}
			if (vag[2].getEtat().compareTo("vivant") == 0) {System.out.println("3 : " + vag[2].getClasse());}
			if (vag[3].getEtat().compareTo("vivant") == 0) {System.out.println("4 : " + vag[3].getClasse());}
			if (vag[4].getEtat().compareTo("vivant") == 0) {System.out.println("5 : " + vag[4].getClasse());}
			if (vag[0].getEtat().compareTo("mort") == 0 && (vag[1].getEtat().compareTo("mort") == 0) 
				&& (vag[2].getEtat().compareTo("mort")) == 0 && (vag[3].getEtat().compareTo("mort") == 0)
				&& (vag[4].getEtat().compareTo("mort") == 0)) {
				System.out.println("vague terminee !");
			}
		}
	}
	/**
	 * affiche le boss du dernier donjon.
	 */
	public void afficheChoixBoss() {
		Ennemi boss = this.getDonj().getBoss();
		if (boss.getEtat().compareTo("vivant") == 0) {System.out.println("1 : " + boss.getClasse());}
		else {
			System.out.println("Vous avez vaincu le boss de ces Donjons ! La gloire est votre !");
		}
	}
	
	/**
	 * @param x = nombre entier.
	 * @return un nombre aleatoire entre 0 et x
	 */
	public int nbrAlea(int x) {
		double rand = (Math.random() * x) + 1;
		return (int) rand;
	}
	/**
	 * @param vague numero de vague.
	 * @return l etat du joueur attaque 
	 */
	public String combatMob(int vague) {
		int joueurAttaque = nbrAlea(2);
		// change le joueur cible si joueur random deja mort 
		if (joueur.get(joueurAttaque-1).getEtat().compareTo("mort") == 0) {
			if (joueurAttaque == 1) {
				joueurAttaque = 2;
			}
			else {
				joueurAttaque = 1;
			}
		}
		if (vague == 1) {
			int attaquant = nbrAlea(2);
			Ennemi e = donj.getVague1()[attaquant - 1];
			if (attaquantEnVie(attaquant, vague)) {
				String s =  mobAttaque(e, joueurAttaque);
				checkMort(s,  joueurAttaque);
				return s;
			}
			else {
				Ennemi e2 = new Ennemi();
				if (attaquant == 1) {
					e2 = donj.getVague1()[attaquant - 1 + 1]; // mob 1 de la liste
				}
				if (attaquant == 2) {
					e2 = donj.getVague1()[attaquant - 1 - 1]; // mob 0 de la liste
				}
				String s =  mobAttaque(e2, joueurAttaque);
				checkMort(s,  joueurAttaque);
				return s;
			}
		}
		if (vague == 2) {
			int attaquant = nbrAlea(3);
			while (!attaquantEnVie(attaquant, vague)) {
				attaquant = nbrAlea(3);
			}
			Ennemi e = donj.getVague2()[attaquant - 1];
			String s =  mobAttaque(e, joueurAttaque);
			checkMort(s,  joueurAttaque);
			return s;
		}
		if (vague == 3) {
			int attaquant = nbrAlea(5);
			while (!attaquantEnVie(attaquant, vague)) {
				attaquant = nbrAlea(5);
			}
			Ennemi e = donj.getVague3()[attaquant - 1];
			String s =  mobAttaque(e, joueurAttaque);
			checkMort(s,  joueurAttaque);
			return s;
		}
		return "fail combat";
	}
	/**
	 *  tour d attaque des ennemis.
	 * @param e ennemi qui joue
	 * @param joueurAttaque joueur cible par l ennemi
	 * @return l etat du joueur : "mort" || "vivant"
	 */
	public String mobAttaque(Ennemi e, int joueurAttaque) {
		Hero h = joueur.get(joueurAttaque - 1);
		if (h.getEtat().compareTo("mort") == 0) {
			h = getAutre(joueurAttaque - 1);
		}
		int vieAvant = h.getVie();
		System.out.println("-- ENNEMI : " + e.getClasse() + " attaque joueur "+ joueurAttaque + " ! --");
		e.attaque(h);
		int degatDonne = vieAvant - h.getVie();
		System.out.println("Il vous a fait perdre : " + degatDonne + " points de vie ! Il vous reste donc " + h.getVie() +" points de vie.\n");
		setChanged();
        notifyObservers();
        return joueur.get(joueurAttaque - 1).getEtat();
	}
	
	/**
	 * check si l ennemi choisi peut attaquer.
	 * @param attaquant numero de l ennemi qui va jouer
	 * @param vague vague a laquelle l ennemi appartient
	 * @return true si l ennemi concerner est en vie, false sinon.
	 */
	public boolean attaquantEnVie(int attaquant, int vague) {
		if (attaquant > 0) {
			Ennemi att = this.donj.getPopVague(vague)[attaquant - 1];
			return (att.getEtat().compareTo("vivant") == 0);
		}
		else {
			return false;
		}
	}
	public void checkMort(String s, int joueur) {
		if (s.compareTo("mort") == 0) {
			this.joueurMort = joueur;
			setChanged();
	        notifyObservers();
		}
	}
	public Hero getAutre(int h) {
		if (h == 0) {return joueur.get(1);}
		else {return joueur.get(0);}
	}
	public String combatBoss() {
		int joueurAttaque = nbrAlea(2);
		// change le joueur cible si joueur random deja mort 
		if (joueur.get(joueurAttaque-1).getEtat().compareTo("mort") == 0) {
			if (joueurAttaque == 1) {
				joueurAttaque = 2;
			}
			else {
				joueurAttaque = 1;
			}
		}
			Ennemi boss = donj.getBoss();
			if (boss.getEtat().compareTo("vivant") == 0) {
				String s =  mobAttaque(boss, joueurAttaque);
				checkMort(s,  joueurAttaque);
				return s;
			}
			else {
				//System.out.println("Vous avez vaincu le maitre des lieux !");
				String s =  "mort";
				return s;
			}
	}
	
	/**
	 * ajoute l xp d un mob vaincu aux joueurs
	 * @param vagueNum numero de la vague de l ennemi vaincu
	 * @param choixMob numero de l ennemi dans la vague
	 * @return le nombre de points d experiences gagne
	 */
	public int xpRecu(int vagueNum,int choixMob) {
		int xpGagne = 0;
		Donjon d = this.getDonj();
		if (vagueNum == 0) {xpGagne = d.getBoss().getXpMob();}
		else {xpGagne = d.getPopVague(vagueNum)[choixMob - 1].getXpMob();}
		for (Hero h : this.joueur) {
			h.ajoutXp(xpGagne);
		}
		setChanged();
        notifyObservers();
		return xpGagne;
	}

	public void gestionLoot() {
		ArrayList<Loot> drop = donj.lootDonjon(donjonNum);
		int z = nbrAlea(2);
		for(int i = 0 ; i < joueur.size(); i++) {
			int k = 1;
			for(Loot l : drop) {
				System.out.println(k+" : "+l.getNom());
				k++;
			}
			System.out.println("Choisissez votre loot : Joueur "+z);
			scan = new Scanner(System.in);
			int entree = scan.nextInt();
			while(entree>drop.size() || entree<=0) {
				System.out.println("Mauvais numero de loot : choisissez a nouveau");
				entree = scan.nextInt();
			}
			joueur.get(z-1).ramasser(drop, entree);
			if(z==1) {
				z=2;
			}else {
				z=1;
			}
		}
		drop.removeAll(drop);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Jeu();
	}

}
