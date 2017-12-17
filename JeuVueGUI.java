	package info;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;

public class JeuVueGUI extends JeuVue implements ActionListener, Observer {

	ImageIcon jouerBimg = new ImageIcon("C:/Users/Philemon/Documents/2TI 2017-2018/Beat the Dungeon/img/jouerB.png");
	ImageIcon chargerBimg = new ImageIcon("C:/Users/Philemon/Documents/2TI 2017-2018/Beat the Dungeon/img/chargerB.png");
	ImageIcon quitterBimg = new ImageIcon("C:/Users/Philemon/Documents/2TI 2017-2018/Beat the Dungeon/img/quitterB.png");
	ImageIcon elfeBimg = new ImageIcon("C:/Users/Philemon/Documents/2TI 2017-2018/Beat the Dungeon/img/elfeB.png");
	ImageIcon nainBimg = new ImageIcon("C:/Users/Philemon/Documents/2TI 2017-2018/Beat the Dungeon/img/nainB.png");
	ImageIcon orqueBimg = new ImageIcon("C:/Users/Philemon/Documents/2TI 2017-2018/Beat the Dungeon/img/orqueB.png");
	ImageIcon humainBimg = new ImageIcon("C:/Users/Philemon/Documents/2TI 2017-2018/Beat the Dungeon/img/humainB.png");
	ImageIcon perso1Bimg = new ImageIcon("C:/Users/Philemon/Documents/2TI 2017-2018/Beat the Dungeon/img/perso1B.png");
	ImageIcon perso2Bimg = new ImageIcon("C:/Users/Philemon/Documents/2TI 2017-2018/Beat the Dungeon/img/perso2B.png");
	/*ImageIcon ennemi1Bimg = new ImageIcon("C:/Users/Philemon/Documents/2TI 2017-2018/Beat the Dungeon/img/quitterB.png");
	ImageIcon ennemi2Bimg = new ImageIcon("C:/Users/Philemon/Documents/2TI 2017-2018/Beat the Dungeon/img/quitterB.png");
	ImageIcon ennemi3Bimg = new ImageIcon("C:/Users/Philemon/Documents/2TI 2017-2018/Beat the Dungeon/img/quitterB.png");
	ImageIcon ennemi4Bimg = new ImageIcon("C:/Users/Philemon/Documents/2TI 2017-2018/Beat the Dungeon/img/quitterB.png");
	ImageIcon ennemi5Bimg = new ImageIcon("C:/Users/Philemon/Documents/2TI 2017-2018/Beat the Dungeon/img/quitterB.png");*/
	
	
	private JFrame jeuJFrame;
	JFrame fiche;
	JButton jouerB = new JButton(jouerBimg);
	JButton chargerB = new JButton(chargerBimg);
	JButton quitterB = new JButton(quitterBimg);
	JButton elfeB = new JButton(elfeBimg);
	JButton nainB = new JButton(nainBimg);
	JButton orqueB = new JButton(orqueBimg);
	JButton humainB = new JButton(humainBimg);
	JButton joueur1B = new JButton("J1");
	JButton joueur2B = new JButton("J2");
	JButton ennemi1B = new JButton("E1");
	JButton ennemi2B = new JButton("E2");
	JButton ennemi3B = new JButton("E3");
	JButton ennemi4B = new JButton("E4");
	JButton ennemi5B = new JButton("E5");
	JButton perso1B = new JButton(perso1Bimg);
	JButton perso2B = new JButton(perso2Bimg);
	//JButton persoB = new JButton("feuilles J");
	ArrayList<JButton> ennemiList = new ArrayList<JButton>();
	JButton bossB = new JButton("BOSS");
	//JPanel panelFiche = new JPanel();
	JLabel labelFiche = new JLabel("");
	JPanel menuFiche = new JPanel();
	JLabel label = new JLabel("");
	JLabel perso = new JLabel("");
	//JLabel joueur = new JLabel("");
	Font font1 = new Font("Algerian", Font.BOLD, 100);
	Font font2 = new Font("Algerian", Font.BOLD, 50);
	Font font3 = new Font("Algerian", Font.BOLD, 25);
	Box race;
	private JTable table;
	int tourJoueur = 1;
	int vagueNum = 1;
	Donjon d;

	public JeuVueGUI(Jeu model, JeuController jControl) {
		
		super(model, jControl);
		//update(null, null);
		
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
		
		menuFiche.add(perso1B);
		menuFiche.add(perso2B);
		jeuJFrame.add(menuFiche, BorderLayout.WEST);
		menuFiche.setVisible(false);
		jeuJFrame.setVisible(true);
		
		jouerB.addActionListener(this);
		chargerB.addActionListener(this);
		quitterB.addActionListener(this);
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
		//persoB.addActionListener(this);
		
		//jeuJFrame.setContentPane(new Panneau());
		/*textContent.setLayout(new BoxLayout(textContent, BoxLayout.Y_AXIS));
		
		jeuJFrame.add(textContent, BorderLayout.NORTH);
		
		JPanel fieldZone = new JPanel();
		fieldZone.setLayout(new BoxLayout(fieldZone, BoxLayout.X_AXIS));
		jeuJFrame.add(fieldZone, BorderLayout.CENTER);*/
		
	}
	/**
	 * affichage du menu jouer/charger/quitter
	 */
	public void menuDemarrer() {
		//------------  BOUTON JOUER/QUITTER  ------------
	    jouerB.setPreferredSize(new Dimension(300,120)); 
	    jouerB.setSize(300,120);
	    chargerB.setPreferredSize(new Dimension(300,120)); 
	    chargerB.setSize(300,120);
	    quitterB.setPreferredSize(new Dimension(300,120)); 
	    quitterB.setSize(300,120);
	    //On cr�e des conteneurs avec gestion horizontale
	    Box b1 = Box.createHorizontalBox();
	    Box b2 = Box.createHorizontalBox();
	    Box b3 = Box.createHorizontalBox();
	    b2.add(chargerB);
	    b1.add(jouerB);
	    b3.add(quitterB);
	    //On cr�e un conteneur avec gestion verticale
	    Box b4 = Box.createVerticalBox();
	    b4.add(b1);
	    b4.add(b2);
	    b4.add(b3);
	    jeuJFrame.add(b4, BorderLayout.SOUTH);
	    jeuJFrame.setVisible(true);
	    //------------  FIN BOUTONS JOUER/QUITTER ------------
	}
	
	public void affiche(String msg){
		
	}
	public void updateTable(){

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
	    	 
	     }    
	     else if (source == quitterB) {
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
	    	 //TODO
	     }
	     else if (source == perso1B) {
	    	 afficheStat(1);
	    	 perso1B.setVisible(true);
	     }
	     else if (source == perso2B) {
	    	 afficheStat(2);
			 perso2B.setVisible(true);
	     }
	     /*else if (source == persoB) {
	    	 persoB.setVisible(false);
	    	 //fiche.setVisible(true);
			 perso1B.setVisible(true);
			 perso2B.setVisible(true);
	     }*/
	}
	public void fiche() {
		perso1B.setVisible(false);
		perso2B.setVisible(false);
		menuFiche.add(perso1B);
		menuFiche.add(perso2B);
		fiche = new JFrame(" ");
    	fiche.setSize(400,200);
    	fiche.setPreferredSize(new Dimension(400,200));
    	fiche.setTitle("Fiche de personnage");
    	fiche.setLocationRelativeTo(null);
		fiche.add(menuFiche, BorderLayout.WEST);
		fiche.add(menuFiche);
		labelFiche.setAlignmentX(0);
		labelFiche.setAlignmentY(0);
	}
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
	
	public void onClickJouer() {
		jouerB.setVisible(false);
		quitterB.setVisible(false);
		chargerB.setVisible(false);
		label.setVisible(false);
		afficheChoixPerso(1);
	}
	public void onClickCharger() {
		
	}
	public void onClickQuitter() {
		System.exit(0);
	}
	public void onClickPersonnage(int i) {
		jControl.choixPersonnage(i);
		elfeB.setVisible(false);
		humainB.setVisible(false);
		nainB.setVisible(false);
		orqueB.setVisible(false);
		if(tourJoueur != 2) {
			afficheChoixPerso(2);
			tourJoueur++;
		}
		else {
			race.setVisible(false);
			perso.setText("La partie va commencer...");
			jeuBTD(1);
			menuFiche.setVisible(true);
			perso1B.setVisible(true);
			perso2B.setVisible(true);
			//affichePlateau();
		}
	}
	public void afficheChoixPerso(int i) {
		race = Box.createHorizontalBox();
		perso.setFont(font2);
		perso.setText("- Joueur " + i +" - choisissez votre personnage :");
	    perso.setVisible(true);
	    jeuJFrame.add(perso, BorderLayout.NORTH);
	    
		JPanel panelbuttons = new JPanel();
		//Box race = Box.createHorizontalBox();
		race.add(panelbuttons);
		GridLayout g = new GridLayout(2, 2);
		g.setHgap(10);
		g.setVgap(10);
		panelbuttons.setLayout(g);
		panelbuttons.add(elfeB);
		panelbuttons.add(nainB);
		panelbuttons.add(orqueB);
		panelbuttons.add(humainB);
		elfeB.setVisible(true);
		humainB.setVisible(true);
		nainB.setVisible(true);
		orqueB.setVisible(true);
		jeuJFrame.add(race, BorderLayout.CENTER);
	}
	//affiche le plateau a chaque nouveau donjon
	public void affichePlateau(int num) {
		perso.setVisible(false);
		jeuJFrame.remove(race);
		ImageIcon icone = new ImageIcon("C:/Users/louis/eclipse-workspace/TP2/src/info/map" + num +".png");
		JLabel image = new JLabel(icone);
		image.setSize(new Dimension(1000, 500));
	    jeuJFrame.add(image, BorderLayout.CENTER);
	    jeuJFrame.setVisible(true);
	}
	public void chargement() {
		JLabel charge = new JLabel("");
		charge.setPreferredSize(new Dimension(1600, 100));
		charge.setHorizontalAlignment(JLabel.CENTER);
		charge.setVerticalAlignment(JLabel.TOP);
		charge.setFont(font2);
		charge.setText("Initialisation du jeu ..............");
		charge.setVisible(true);
		jeuJFrame.add(charge);
	}
	public void onClickEnnemi(Object source, int numEnnemi) {
		afficheJoueurTour();
		int ret = jControl.combat(vagueNum, numEnnemi, tourJoueur);
		if (ret == 1) {
			JButton s = (JButton) source;
			s.setVisible(false);
		}
		if (jControl.jeu.checkVagueClean(vagueNum) && (jControl.jeu.getDonj().getBoss() == null)) {
			perso.setText("Vous avez vaincu cette vague ! Passez � la pi�ce suivante.");
			perso.setVisible(true);
			incVague(); 
			jeuBTD(vagueNum);
		}
	}
	
	// fait tourner la partie une fois les perso choisi
	public void jeuBTD(int vague) {
		if (vague == 1) {
			affichePlateau(jControl.jeu.getDonjonNum());
			perso.setText("donj num : " + jControl.jeu.getDonjonNum());
			jControl.creationDonjons();
		}
		d = jControl.jeu.getDonj();
		if (d.getBoss() == null) {
			prepareVague(d);
		}
		else {
			prepareBoss(d);
		}
		afficheJoueurTour();
		// pas utile a voir
		/*while (jControl.jeu.getEnVie() > 0 && jControl.jeu.getDonjonNum() <= 5 ) {
			if (jControl.jeu.getDonjonNum() == 1) {
				
				perso.setText("if");
				perso.setVisible(true);
			}
			jControl.jeu.setEnVie(0);
			jeuBTD();
		}*/
		if (jControl.jeu.getEnVie() == 0){
			perso.setText("Vous avez perdu !");
			perso.setVisible(true);
		}
		else if (jControl.jeu.getEnVie() > 0 && jControl.jeu.getDonjonNum() > 5 ){
			perso.setText("Vous avez gagn� !");
			perso.setVisible(true);
		}
	}
	public void prepareVague(Donjon d) {
		ennemi1B.setText(d.getPopVague(vagueNum)[0].getClasse());
		ennemi2B.setText(d.getPopVague(vagueNum)[1].getClasse());
		ennemi1B.setVisible(true);
		ennemi2B.setVisible(true);
		JPanel panelEnnemi = new JPanel();
		panelEnnemi.add(ennemi1B);
		panelEnnemi.add(ennemi2B);
		if (vagueNum >= 2) {
			ennemi3B.setText(d.getPopVague(vagueNum)[2].getClasse());
			ennemi3B.setVisible(true);
			panelEnnemi.add(ennemi3B);
		}
		if (vagueNum == 3) {
			ennemi4B.setText(d.getPopVague(vagueNum)[3].getClasse());
			ennemi5B.setText(d.getPopVague(vagueNum)[4].getClasse());
			ennemi4B.setVisible(true);
			ennemi5B.setVisible(true);
			panelEnnemi.add(ennemi4B);
			panelEnnemi.add(ennemi5B);
		}
		GridLayout g = new GridLayout(1, 5);
		g.setHgap(10);
		g.setVgap(10);
		panelEnnemi.setLayout(g);
		jeuJFrame.add(panelEnnemi, BorderLayout.SOUTH);
	}
	public void prepareBoss(Donjon d) {
		
	}
	public void incVague() {
		if (vagueNum == 1 || vagueNum == 2 || vagueNum == 3) {vagueNum ++;}
		if (vagueNum == 4) {vagueNum = 1;}
	}
	public void afficheJoueurTour() {
		perso.setFont(font3);
		incrementJoueur();
		//perso.setText("Joueur " + tourJoueur + ", a vous de jouer : ");
		perso.setVisible(true);
	}
	public void incrementJoueur() {
		if (tourJoueur == 1 ) {tourJoueur = 2;}
		if (tourJoueur == 2 ) {tourJoueur = 1;}
	}
}
