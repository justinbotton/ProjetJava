package info;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.border.Border;
/**
 * 
 * @author louis & justin & philemon
 *
 */
public class JeuVueGUI extends JeuVue implements ActionListener, Observer {

	ImageIcon jouerBimg = new ImageIcon("src/info/img/jouerB.png");
	ImageIcon jouerB2img = new ImageIcon("src/info/img/jouerB2.png");
	ImageIcon chargerBimg = new ImageIcon("src/info/img/chargerB.png");
	ImageIcon chargerB2img = new ImageIcon("src/info/img/chargerB2.png");
	ImageIcon quitterBimg = new ImageIcon("src/info/img/quitterB.png");
	ImageIcon quitterB2img = new ImageIcon("src/info/img/quitterB2.png");
	ImageIcon quitter2Bimg = new ImageIcon("src/info/img/quitter2B.png");
	ImageIcon quitter2B2img = new ImageIcon("src/info/img/quitter2B2.png");
	ImageIcon elfeBimg = new ImageIcon("src/info/img/elfeB.png");
	ImageIcon elfeB2img = new ImageIcon("src/info/img/elfeB2.png");
	ImageIcon nainBimg = new ImageIcon("src/info/img/nainB.png");
	ImageIcon nainB2img = new ImageIcon("src/info/img/nainB2.png");
	ImageIcon orqueBimg = new ImageIcon("src/info/img/orqueB.png");
	ImageIcon orqueB2img = new ImageIcon("src/info/img/orqueB2.png");
	ImageIcon humainBimg = new ImageIcon("src/info/img/humainB.png");
	ImageIcon humainB2img = new ImageIcon("src/info/img/humainB2.png");
	ImageIcon perso1Bimg = new ImageIcon("src/info/img/perso1B.png");
	ImageIcon perso1B2img = new ImageIcon("src/info/img/perso1B1.png");
	ImageIcon perso2Bimg = new ImageIcon("src/info/img/perso2B.png");
	ImageIcon perso2B2img = new ImageIcon("src/info/img/perso2B2.png");
	ImageIcon gobelinBimg = new ImageIcon("src/info/img/gobelinB.png");
	ImageIcon gobelinB2img = new ImageIcon("src/info/img/gobelinB2.png");
	ImageIcon lootBimg = new ImageIcon("src/info/img/gobelinB.png");
	ImageIcon lootB2img = new ImageIcon("src/info/img/gobelinB2.png");
	
	private JFrame jeuJFrame;
	JFrame fiche;
	Button jouerB = new Button(jouerBimg, jouerB2img);
	Button chargerB = new Button(chargerBimg, chargerB2img);
	Button quitterB = new Button(quitterBimg, quitterB2img);
	Button quitter2B = new Button(quitter2Bimg, quitter2B2img);
	Button elfeB = new Button(elfeBimg, elfeB2img);
	Button nainB = new Button(nainBimg, nainB2img);
	Button orqueB = new Button(orqueBimg, orqueB2img);
	Button humainB = new Button(humainBimg, humainB2img);
	Button ennemi1B = new Button(gobelinBimg, gobelinB2img);
	Button ennemi2B = new Button(gobelinBimg, gobelinB2img);
	Button ennemi3B = new Button(gobelinBimg, gobelinB2img);
	Button ennemi4B = new Button(gobelinBimg, gobelinB2img);
	Button ennemi5B = new Button(gobelinBimg, gobelinB2img);
	Button perso1B = new Button(perso1Bimg, perso1B2img);
	Button perso2B = new Button(perso2Bimg, perso2B2img);
	Button lootB = new Button(gobelinBimg, gobelinB2img);
	ArrayList<JButton> ennemiList = new ArrayList<JButton>();
	Button bossB = new Button(gobelinBimg, gobelinBimg);
	JLabel labelFiche = new JLabel("");
	JLabel label = new JLabel("");
	JLabel image;
	JLabel perso = new JLabel("");
	Font font1 = new Font("Algerian", Font.BOLD, 100);
	Font font2 = new Font("Algerian", Font.BOLD, 50);
	Font font3 = new Font("Algerian", Font.BOLD, 25);
	Font font4 = new Font("Algerian", Font.BOLD, 20);
	JTextField southBar;
	Box race;
	Box menuFiche;
	Box menuEnnemi;
	private JTable table;
	private volatile int tourJoueur = 1;
	private volatile int vagueNum = 1;
	private Donjon d;
	private final static String espace = "                                                                           ";
	private boolean first = true;

	/**
	 * constructeur de la GUI en mode MVC.
	 * @param model modele du jeu
	 * @param jControl controlleur du jeu
	 */
	public JeuVueGUI(Jeu model, JeuController jControl) {
		
		super(model, jControl);
		
		//Construction de la fenetre
		jeuJFrame = new JFrame(" ");
		jeuJFrame.setSize(1600, 800);
		jeuJFrame.setPreferredSize(new Dimension(1600,800));
		jeuJFrame.setTitle("Beat the Dungeon");
		
		//jeuJFrame.setResizable(false);
		jeuJFrame.setLocationRelativeTo(null);
		jeuJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    label.setPreferredSize(new Dimension(1600, 100));
	    label.setText("Beat the Dungeon");
	    label.setHorizontalAlignment(JLabel.CENTER);
	    label.setVerticalAlignment(JLabel.CENTER);
	    label.setFont(font1);
	    
	    perso.setPreferredSize(new Dimension(1600, 100));
	    perso.setHorizontalAlignment(JLabel.CENTER);
	    perso.setVerticalAlignment(JLabel.TOP);
	    perso.setFont(font3);
	    
	    jeuJFrame.add(label);
	       
	    menuDemarrer();
	    fiche();		
	    createMenuFiche();
	    createMenuEnnemi();
	    
		
		jeuJFrame.setVisible(true);
		jeuJFrame.setResizable(false);
		
		jouerB.addActionListener(this);
		chargerB.addActionListener(this);
		quitterB.addActionListener(this);
		quitter2B.addActionListener(this);
		elfeB.addActionListener(this);
		nainB.addActionListener(this);
		orqueB.addActionListener(this);
		humainB.addActionListener(this);
		ennemi1B.addActionListener(this);
		ennemi2B.addActionListener(this);
		ennemi3B.addActionListener(this);
		ennemi4B.addActionListener(this);
		ennemi5B.addActionListener(this);
		bossB.addActionListener(this);
		perso1B.addActionListener(this);
		perso2B.addActionListener(this);
		lootB.addActionListener(this);
		
	}
	/**
	 * classe privee pour redefinir un bouton avec image.
	 * @author louis & philemen & justin
	 *
	 */
	private class Button extends JButton {
		private static final long serialVersionUID = 1L;
		
		public Button(ImageIcon icone, ImageIcon clicIcone) {
			super();
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
			this.setFocusPainted(false);
			this.setIcon(icone);
			this.setRolloverIcon(clicIcone);
		}
		public void setImage(ImageIcon icone, ImageIcon clicIcone) {
			this.setIcon(icone);
			this.setRolloverIcon(clicIcone);
		}
	}
	
	/**
	 * affichage du menu jouer/charger/quitter
	 */
	public void menuDemarrer() {
		//------------  BOUTON JOUER/QUITTER  ------------
	    jouerB.setPreferredSize(new Dimension(300,150)); 
	    chargerB.setPreferredSize(new Dimension(300,150)); 
	    quitterB.setPreferredSize(new Dimension(300,150)); 
	    //On cree des conteneurs avec gestion horizontale
	    Box b1 = Box.createHorizontalBox();
	    Box b2 = Box.createHorizontalBox();
	    Box b3 = Box.createHorizontalBox();
	    b2.add(chargerB);
	    b1.add(jouerB);
	    b3.add(quitterB);
	    //On cree un conteneur avec gestion verticale
	    Box b4 = Box.createVerticalBox();
	    b4.add(b1);
	    b4.add(b2);
	    b4.add(b3);
	    jeuJFrame.add(b4, BorderLayout.SOUTH);
	    jeuJFrame.setVisible(true);
	    //------------  FIN BOUTONS JOUER/QUITTER ------------
	}
	/**
	 * cree le menu de gauche contenant les feuilles de personnages et un bouton quitter.
	 */
	public void createMenuFiche() {
		//On cree des conteneurs avec gestion horizontale
	    Box b1 = Box.createHorizontalBox();
	    Box b2 = Box.createHorizontalBox();
	    Box b3 = Box.createHorizontalBox();
	    b1.add(perso1B);
	    b2.add(perso2B);
	    b3.add(quitter2B);
	    quitter2B.setVisible(false);
	    //On cree un conteneur avec gestion verticale
	    menuFiche = Box.createVerticalBox();
	    menuFiche.add(b1);
	    menuFiche.add(b2);
	    menuFiche.add(b3);
	    jeuJFrame.add(menuFiche, BorderLayout.WEST);
	}
	/**
	 * cree le menu de droite contenant les ennemis a affonter.
	 */
	public void createMenuEnnemi() {
		//On cree des conteneurs avec gestion horizontale
		Box e1 = Box.createHorizontalBox();
	    Box e2 = Box.createHorizontalBox();
	    Box e3 = Box.createHorizontalBox();
	    Box e4 = Box.createHorizontalBox();
	    Box e5 = Box.createHorizontalBox();
	    Box e6 = Box.createHorizontalBox();
	    Box e7 = Box.createHorizontalBox();
	    e1.add(ennemi1B);
	    e2.add(ennemi2B);
	    e3.add(ennemi3B);
	    e4.add(ennemi4B);
	    e5.add(ennemi5B);
	    e6.add(bossB);
	    e7.add(lootB);	    
	    //On cree un conteneur avec gestion verticale
	    menuEnnemi = Box.createVerticalBox();
	    menuEnnemi.add(e1);
	    menuEnnemi.add(e2);
	    menuEnnemi.add(e3);
	    menuEnnemi.add(e4);
	    menuEnnemi.add(e5);
	    menuEnnemi.add(e6);
	    menuEnnemi.add(e7);
	    menuEnnemi.setVisible(false);
	    jeuJFrame.add(menuEnnemi, BorderLayout.EAST);
	}
	
	@Override
	public void affiche(String string) {
		System.out.println(string);
		perso.setText(string);
		perso.setFont(font4);
	}
	@Override
	public void update(Observable o, Object arg) {
		jeuJFrame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 Object  source = e.getSource();
	     if  (source == jouerB){
	    	 onClickJouer();
	     }
	     else if (source == chargerB) {
	    	 onClickCharger();
	     }    
	     else if (source == quitterB) {
	    	 onClickQuitter();
	     }
	     else if (source == quitter2B) {
	    	 onClickQuitter();
	     }
	     else if (source == elfeB) {
	    	 onClickPersonnage(1);
	     }
	     else if (source == nainB) {
	    	 onClickPersonnage(2);
	     }
	     else if (source == orqueB) {
	    	 onClickPersonnage(3);
	     }
	     else if (source == humainB) {
	    	 onClickPersonnage(4);
	     }
	     else if (source == ennemi1B) {
	    	 onClickEnnemi(ennemi1B, 1);
	     }
	     else if (source == ennemi2B) {
	    	 onClickEnnemi(ennemi2B, 2);
	     }
	     else if (source == ennemi3B) {
	    	 onClickEnnemi(ennemi3B, 3);
	     }
	     else if (source == ennemi4B) {
	    	 onClickEnnemi(ennemi4B, 4);
	     }
	     else if (source == ennemi5B) {
	    	 onClickEnnemi(ennemi5B, 5);
	     }
	     else if (source == bossB) {
	    	 onClicBoss(bossB);
	     }
	     else if (source == perso1B) {
	    	 afficheStat(1);
	     }
	     else if (source == perso2B) {
	    	 afficheStat(2);
	     }
	     else if (source == lootB) {
	    	 lootTime();
	     }
	}
	/**
	 * rend le menu de gauche visible.
	 */
	public void fiche() {
		perso1B.setVisible(false);
		perso2B.setVisible(false);
		quitter2B.setVisible(true);
		fiche = new JFrame(" ");
    	fiche.setSize(400,200);
    	fiche.setPreferredSize(new Dimension(400,200));
    	fiche.setTitle("Fiche de personnage");
    	fiche.setLocationRelativeTo(null);
		labelFiche.setAlignmentX(0);
		labelFiche.setAlignmentY(0);
	}
	/**
	 * affiche la feuille du personnage numJoueur.
	 * @param numJoueur numero du joueur dont la feuille est affichee
	 */
	public void afficheStat(int numJoueur) {
		 jControl.afficheFeuillePersonnages(numJoueur);
		 table = null;
    	 labelFiche.setVisible(true);
    	 labelFiche.setText(" ");	
    	 Hero p  = jControl.jeu.getJoueur().get(numJoueur-1);
    	 Object [][] data = new Object[8][2];
    	 data[0][0] = "Classe"; 
    	 data[0][1] = p.getClasse();
    	 data[1][0] = "Niveau";
    	 data[1][1] = p.getNiveau();
    	 data[2][0] = "Force";
    	 data[2][1] = p.getForce();
    	 data[3][0] = "vie";
    	 data[3][1] = p.getVie();
    	 data[4][0] = "Endurance";
    	 data[4][1] = p.getEndurance();
    	 data[5][0] = "XP";
    	 data[5][1] = p.getXp();
    	 data[6][0] = "Arme";
    	 data[6][1] = p.getArmeDroite().getNom();
    	 data[7][0] = "Etat";
    	 data[7][1] = p.getEtat();
 		 String[] head = {"ELEMENT", "STAT"};
 		 table = new JTable(data, head);
 		 fiche.add(table);
 		 fiche.setVisible(true);
 		 //fiche.setResizable(false);
 		 //jeuJFrame.add(table,  BorderLayout.WEST);
	}
	/**
	 * gere le clic de jouer.
	 */
	public void onClickJouer() {
		jouerB.setVisible(false);
		quitterB.setVisible(false);
		chargerB.setVisible(false);
		label.setVisible(false);
		afficheChoixPerso(1);
		jControl.menu(1,1);
	}
	/**
	 * gere le clic de charger.
	 */
	public void onClickCharger() {
		jouerB.setVisible(false);
		quitterB.setVisible(false);
		chargerB.setVisible(false);
		label.setVisible(false);
		afficheChoixPerso(1); // sert a pouvoir sauter les etapes de choix perso
		jControl.menu(2, 1);
		afficheJeu();
	}
	/**
	 * gere le clic de quitter avec un pop up de confirmation.
	 */
	public void onClickQuitter() {
		JDialog.setDefaultLookAndFeelDecorated(false);
	    int response = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment quitter ?", "Quit",
	        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if (response == JOptionPane.NO_OPTION) {
	      System.out.println("Conituer jeu");
	    } else if (response == JOptionPane.YES_OPTION) {
	      System.out.println("Quitter jeu");
	      System.exit(0);
	    } else if (response == JOptionPane.CLOSED_OPTION) {
	      System.out.println("Quitter jeu");
	    }
	}
	/*
	 * gere le clic sur un choix de personnage.
	 */
	public void onClickPersonnage(int i) {
		if(tourJoueur == 1) {
			tourJoueur++;
			jControl.choixPersonnage(i);
			jControl.printTextMenu(2,2);
			afficheChoixPerso(tourJoueur);
		}
		else {
			jControl.choixPersonnage(i);
			afficheJeu();
		}
	}
	/**
	 * affiche des textes et boutons necessaire au jeu.
	 */
	public void afficheJeu() {
		race.setVisible(false);
		jeuBTD(1);
		menuFiche.setVisible(true);
		perso1B.setVisible(true);
		perso2B.setVisible(true);
		quitter2B.setVisible(true);
		menuEnnemi.setVisible(true);
		tourJoueur = 1;
		updateSouthBar();
	    perso.setVisible(true);
	    perso.setText("La partie commence !");
	    //jControl.afficheTour(jControl.jeu.getTourJ());
	}
	public void updateSouthBar() {
		southBar = new JTextField();
		southBar.setText("Tour joueur : " + jControl.jeu.getTourJ() + espace +"Vague n° : " + vagueNum 
	    		+ espace +"Donjon n° : " + jControl.jeu.getDonjonNum());
	    southBar.setFont(font3);
	    jeuJFrame.add(southBar, BorderLayout.SOUTH);
	    southBar.setEditable(false);
	    southBar.setVisible(true);
	}
	/**
	 * affiche le choix de personnage.
	 * @param i joueur concerne.
	 */
	public void afficheChoixPerso(int i) {
		perso.setFont(font2);
		perso.setText("- Joueur " + i +" - choisissez votre personnage :");
	    perso.setVisible(true);
	    jeuJFrame.add(perso, BorderLayout.NORTH);
		//------------  BOUTON RACE  ------------
		elfeB.setPreferredSize(new Dimension(300,150)); 
		humainB.setPreferredSize(new Dimension(300,150)); 
		nainB.setPreferredSize(new Dimension(300,150)); 
		orqueB.setPreferredSize(new Dimension(300,150));
	    //On cree des conteneurs avec gestion horizontale
	    Box b1 = Box.createHorizontalBox();
	    Box b2 = Box.createHorizontalBox();
	    Box b3 = Box.createHorizontalBox();
	    Box b4 = Box.createHorizontalBox();
	    b1.add(elfeB);
	    b2.add(nainB);
	    b3.add(orqueB);
	    b4.add(humainB);
	    //On cree un conteneur avec gestion verticale
	    race = Box.createVerticalBox();
	    race.add(b1);
	    race.add(b2);
	    race.add(b3);
	    race.add(b4);
	    jeuJFrame.add(race, BorderLayout.CENTER);
	    jeuJFrame.setVisible(true);
	    //------------  FIN BOUTONS RACE ------------
	}
	/**
	 * affiche le plateau de jeu.
	 * @param num numero du donjon
	 */
	public void affichePlateau(int num) {
		jeuJFrame.remove(race);
		ImageIcon icone = new ImageIcon("src/info/img/map" + num +".png");
		image = new JLabel(icone);
		image.setSize(new Dimension(1000, 500));
		jeuJFrame.add(image, BorderLayout.CENTER);

	}
	/**
	 * gere le clic sur un ennemi.
	 * @param source bouton concerne
	 * @param numEnnemi numero de l ennemi dans la vague
	 */
	public void onClickEnnemi(Object source, int numEnnemi) {
		Hero h = jControl.jeu.getJoueur().get(jControl.jeu.getTourJ() - 1);
		Hero h2 = jControl.jeu.getAutre(jControl.jeu.getTourJ() - 1);
		Ennemi b = jControl.jeu.getDonj().getBoss();
		if (h.getEtat().compareTo("vivant") == 0) {
			int ret = jControl.combat(vagueNum, numEnnemi, jControl.jeu.getTourJ());
			
			if (ret == 1) {
				JButton s = (JButton) source;
				s.setVisible(false);
			}
			if (jControl.jeu.checkVagueClean(vagueNum) && (b == null)) {
				incVague();		
				//lootTime();
				//jeuBTD(vagueNum);
				lootB.setVisible(true);
			}
			if (b != null) {
				if (vagueNum != 3 && jControl.jeu.checkVagueClean(vagueNum)) {
					incVague();
					//lootTime();
					//jeuBTD(vagueNum);
					lootB.setVisible(true);
				}
				else if (vagueNum == 3){
					incVague();	
					bossB.setVisible(true);
					jeuBTD(vagueNum);
				}
				
			}
			if (jControl.jeu.getTourJ() == 2 && b == null) {
				jControl.tourMob(vagueNum);
			}
			jControl.jeu.incrTourJ();
			southBar.setText("Tour joueur : " + jControl.jeu.getTourJ() + espace +"Vague n° : " + vagueNum 
		    		+ espace +"Donjon n° : " + jControl.jeu.getDonjonNum());
		    southBar.setFont(font3);
		    southBar.setEditable(false);
		}
		else {
			if (jControl.jeu.getTourJ() == 2 && b == null) {
				jControl.tourMob(vagueNum);
			}
			jControl.jeu.incrTourJ();
		}
		if (h.getEtat().compareTo("mort") == 0 && h2.getEtat().compareTo("mort") == 0) {
			bossB.setEnabled(false);
			affiche("Vous n'avez pas survécu au donjon... dommage...");
		}
	}
	
	/**
	 * gere le clic sur le bouton du boss.
	 * @param source bouton boss
	 */
	public void onClicBoss(Object source) {
		Hero h = jControl.jeu.getJoueur().get(jControl.jeu.getTourJ() - 1);
		Hero h2 = jControl.jeu.getAutre(jControl.jeu.getTourJ() - 1);
		int etatBoss = jControl.jeu.getDonj().getBoss().getEtat().compareTo("mort");
		if (h.getEtat().compareTo("vivant") == 0) {
			int ret = jControl.combat(0, 1, jControl.jeu.getTourJ());
			if (ret == 1) {
				JButton s = (JButton) source;
				s.setVisible(false);
			}
			if (etatBoss == 0) {
				perso.setText("Vous avez vaincu le maitre du donjon ! Felicitations, la partie est finie !");
				perso.setFont(font3);
				bossB.setVisible(true);
				bossB.setEnabled(false);
			}
			if (jControl.jeu.getTourJ() == 2 && etatBoss != 0) {
				jControl.tourBoss();
			}
			jControl.jeu.incrTourJ();
			southBar.setText("Tour joueur : " + jControl.jeu.getTourJ() + espace +"Vague n° : " + vagueNum 
		    		+ espace +"Donjon n° :" + jControl.jeu.getDonjonNum());
		    southBar.setFont(font3);
		    southBar.setEditable(false);
		}
		else {
			if (jControl.jeu.getTourJ() == 2 && etatBoss != 0) {
				jControl.tourBoss();
			}
			jControl.jeu.incrTourJ();
		}
		if (h.getEtat().compareTo("mort") == 0 && h2.getEtat().compareTo("mort") == 0) {
			bossB.setEnabled(false);
			affiche("Vous n'avez pas survécu au donjon... dommage...");
		}
	}
	
	/**
	 * fait tourner la partie.
	 * @param vague numero de vague actuel
	 */
	public void jeuBTD(int vague) {
		if (vague == 1) {
			affichePlateau(jControl.jeu.getDonjonNum());
			if (first == false) {jControl.incrDonjonNum();}
			jControl.creationDonjons();
			jControl.histoire(jControl.jeu.getDonjonNum());
		}
		d = jControl.jeu.getDonj();
		
		prepareVague(d);
		
		if (jControl.jeu.getEnVie() == 0){
			perso.setText("Vous avez perdu !");
			perso.setVisible(true);
			System.exit(0);
		}
		else if (jControl.jeu.getEnVie() > 0 && jControl.jeu.getDonjonNum() > 5 ){
			perso.setText("Vous avez gagne !");
			perso.setVisible(true);
			System.exit(0);
		}
	}
	/**
	 * prepare la vague d ennemis.
	 * @param d donjon actuel.
	 */
	public void prepareVague(Donjon d) {
		lootB.setVisible(false);
		if (vagueNum !=3 || d.getBoss() == null) {
			ennemi1B.setImage(d.getPopVague(vagueNum)[0].getIcone1(), d.getPopVague(vagueNum)[0].getIcone2());
			ennemi2B.setImage(d.getPopVague(vagueNum)[1].getIcone1(), d.getPopVague(vagueNum)[1].getIcone2());
			ennemi1B.setVisible(true);
			ennemi2B.setVisible(true);
			bossB.setVisible(false);
		}
		if (vagueNum == 1) {
			ennemi3B.setVisible(false);
			ennemi4B.setVisible(false);
			ennemi5B.setVisible(false);
		}
		if (vagueNum >= 2 && (vagueNum !=3 || d.getBoss() == null)) {
			ennemi3B.setImage(d.getPopVague(vagueNum)[2].getIcone1(), d.getPopVague(vagueNum)[2].getIcone2());
			ennemi3B.setVisible(true);
		}
		if (vagueNum == 3 && d.getBoss() == null) {
			if (first) {first = false;}
			ennemi4B.setImage(d.getPopVague(vagueNum)[3].getIcone1(), d.getPopVague(vagueNum)[3].getIcone2());
			ennemi5B.setImage(d.getPopVague(vagueNum)[4].getIcone1(), d.getPopVague(vagueNum)[4].getIcone2());
			ennemi4B.setVisible(true);
			ennemi5B.setVisible(true);
		}
		if (vagueNum == 3 && d.getBoss() != null) {
			bossB.setImage(d.getBoss().getIcone1(), d.getBoss().getIcone2());
			bossB.setVisible(true);
		}
	}
	
	/**
	 * incremente le numero de vague.
	 */
	public void incVague() {
		if (vagueNum == 1 || vagueNum == 2 || vagueNum == 3) {vagueNum ++;}
		if (vagueNum == 4) {vagueNum = 1;}
	}
	
	/**
	 * gere le loot.
	 */
	public void lootTime() {
		jControl.gestionLoot(2);
		lootB.setVisible(false);
		jeuBTD(vagueNum);
	}
}
