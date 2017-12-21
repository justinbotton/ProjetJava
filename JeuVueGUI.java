package info;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.border.Border;

public class JeuVueGUI extends JeuVue implements ActionListener, Observer {

	ImageIcon jouerBimg = new ImageIcon("src/info/img/jouerB.png");
	ImageIcon chargerBimg = new ImageIcon("src/info/img/chargerB.png");
	ImageIcon quitterBimg = new ImageIcon("src/info/img/quitterB.png");
	ImageIcon elfeBimg = new ImageIcon("src/info/img/elfeB.png");
	ImageIcon nainBimg = new ImageIcon("src/info/img/nainB.png");
	ImageIcon orqueBimg = new ImageIcon("src/info/img/orqueB.png");
	ImageIcon humainBimg = new ImageIcon("src/info/img/humainB.png");
	ImageIcon perso1Bimg = new ImageIcon("src/info/img/perso1B.png");
	ImageIcon perso2Bimg = new ImageIcon("src/info/img/perso2B.png");
	ImageIcon gobelinBimg = new ImageIcon("src/info/img/gobelinB.png");
	ImageIcon groupeBimg = new ImageIcon("src/info/img/groupegobelinB.png");
	ImageIcon magicienBimg = new ImageIcon("src/info/img/magicienB.png");
	ImageIcon trollBimg = new ImageIcon("src/info/img/trollB.png");
	ImageIcon grandmageBimg = new ImageIcon("src/info/img/grandmageB.png");
	ImageIcon samuraiBimg = new ImageIcon("src/info/img/samouraiB.png");
	
	private JFrame jeuJFrame;
	JFrame fiche;
	JButton jouerB = new Button(jouerBimg);
	JButton chargerB = new Button(chargerBimg);
	JButton quitterB = new Button(quitterBimg);
	JButton elfeB = new Button(elfeBimg);
	JButton nainB = new Button(nainBimg);
	JButton orqueB = new Button(orqueBimg);
	JButton humainB = new Button(humainBimg);
	JButton joueur1B = new JButton("J1");
	JButton joueur2B = new JButton("J2");
	JButton ennemi1B = new JButton("E1");
	JButton ennemi2B = new JButton("E2");
	JButton ennemi3B = new JButton("E3");
	JButton ennemi4B = new JButton("E4");
	JButton ennemi5B = new Button(perso1Bimg);
	JButton perso1B = new Button(perso1Bimg);
	JButton perso2B = new Button(perso2Bimg);
	ArrayList<JButton> ennemiList = new ArrayList<JButton>();
	JButton bossB = new JButton("BOSS");
	JLabel labelFiche = new JLabel("");
	JLabel label = new JLabel("");
	JLabel perso = new JLabel("");
	Font font1 = new Font("Algerian", Font.BOLD, 100);
	Font font2 = new Font("Algerian", Font.BOLD, 50);
	Font font3 = new Font("Algerian", Font.BOLD, 25);
	JTextField southBar;
	Box race;
	Box menuFiche;
	Box menuEnnemi;
	private JTable table;
	private volatile int tourJoueur = 1;
	private volatile int vagueNum = 1;
	private Donjon d;
	private final static String espace = "                                                                                 ";
	private boolean first = true;

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
	    /*southBar = new JTextField();
	    southBar.setText("Tour joueur : " + tourJoueur);
	    southBar.setFont(font3);
	    jeuJFrame.add(southBar, BorderLayout.SOUTH);
	    southBar.setVisible(false);*/
	    
		/*menuFiche.add(perso1B);
		menuFiche.add(perso2B);
		jeuJFrame.add(menuFiche, BorderLayout.WEST);
		menuFiche.setVisible(false);*/
	    createMenuFiche();
	    createMenuEnnemi();
	    
		
		jeuJFrame.setVisible(true);
		jeuJFrame.setResizable(false);
		
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
	
	private class Button extends JButton{
		private static final long serialVersionUID = 1L;

		public Button(ImageIcon icone) {
			super();
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
			this.setFocusPainted(false);
			this.setIcon(icone);
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
	public void createMenuFiche() {
		//On cree des conteneurs avec gestion horizontale
	    Box b1 = Box.createHorizontalBox();
	    Box b2 = Box.createHorizontalBox();
	    b1.add(perso1B);
	    b2.add(perso2B);
	    //On cree un conteneur avec gestion verticale
	    menuFiche = Box.createVerticalBox();
	    menuFiche.add(b1);
	    menuFiche.add(b2);
	    jeuJFrame.add(menuFiche, BorderLayout.WEST);
	}
	public void createMenuEnnemi() {
		//On cree des conteneurs avec gestion horizontale
		Box e1 = Box.createHorizontalBox();
	    Box e2 = Box.createHorizontalBox();
	    Box e3 = Box.createHorizontalBox();
	    Box e4 = Box.createHorizontalBox();
	    Box e5 = Box.createHorizontalBox();
	    e1.add(ennemi1B);
	    e2.add(ennemi2B);
	    e3.add(ennemi3B);
	    e4.add(ennemi4B);
	    e5.add(ennemi5B);
	    //On cree un conteneur avec gestion verticale
	    menuEnnemi = Box.createVerticalBox();
	    menuEnnemi.add(e1);
	    menuEnnemi.add(e2);
	    menuEnnemi.add(e3);
	    menuEnnemi.add(e4);
	    menuEnnemi.add(e5);
	    menuEnnemi.setVisible(false);
	    jeuJFrame.add(menuEnnemi, BorderLayout.EAST);
	}
	
	@Override
	public void affiche(String string) {
		System.out.println(string);		
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
	     }
	     else if (source == perso2B) {
	    	 afficheStat(2);
	     }
	}
	public void fiche() {
		perso1B.setVisible(false);
		perso2B.setVisible(false);
		fiche = new JFrame(" ");
    	fiche.setSize(400,200);
    	fiche.setPreferredSize(new Dimension(400,200));
    	fiche.setTitle("Fiche de personnage");
    	fiche.setLocationRelativeTo(null);
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
		jControl.menu(1,1);
	}
	public void onClickCharger() {
		
	}
	public void onClickQuitter() {
		JDialog.setDefaultLookAndFeelDecorated(true);
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
	public void onClickPersonnage(int i) {
		if(tourJoueur == 1) {
			tourJoueur++;
			
			afficheChoixPerso(tourJoueur);
			jControl.choixPersonnage(i);
			jControl.printTextMenu(2,2);
		}
		else {
			jControl.choixPersonnage(i);
			race.setVisible(false);
			jeuBTD(1);
			menuFiche.setVisible(true);
			perso1B.setVisible(true);
			perso2B.setVisible(true);
			menuEnnemi.setVisible(true);
			tourJoueur = 1;
			southBar = new JTextField();
			southBar.setText("Tour joueur : " + jControl.jeu.getTourJ() + espace +"Vague n° : " + vagueNum 
		    		+ espace +"Donjon n° :" + jControl.jeu.getDonjonNum());
		    southBar.setFont(font3);
		    jeuJFrame.add(southBar, BorderLayout.SOUTH);
		    southBar.setEditable(false);
		    southBar.setVisible(true);    
		}
	}
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
	//affiche le plateau a chaque nouveau donjon
	public void affichePlateau(int num) {
		perso.setVisible(false);
		jeuJFrame.remove(race);
		ImageIcon icone = new ImageIcon("C:/Users/louis/eclipse-workspace/TP2/src/info/img/map" + num +".png");
		JLabel image = new JLabel(icone);
		image.setSize(new Dimension(1000, 500));
	    jeuJFrame.add(image, BorderLayout.CENTER);
	}
	public void onClickEnnemi(Object source, int numEnnemi) {
		afficheJoueurTour();
		//System.out.println("joueur avant clic : " + jControl.jeu.getTourJ());
		int ret = jControl.combat(vagueNum, numEnnemi, jControl.jeu.getTourJ());
		
		if (ret == 1) {
			JButton s = (JButton) source;
			s.setVisible(false);
		}
		if (jControl.jeu.checkVagueClean(vagueNum) && (jControl.jeu.getDonj().getBoss() == null)) {
			perso.setText("Vous avez vaincu cette vague ! Passez a la piece suivante.");
			perso.setVisible(true);
			incVague();			
			jeuBTD(vagueNum);
		}
		if (jControl.jeu.getTourJ() == 2) {
			jControl.tourMob(vagueNum);
		}
		jControl.jeu.incrTourJ();
		southBar.setText("Tour joueur : " + jControl.jeu.getTourJ() + espace +"Vague n° : " + vagueNum 
	    		+ espace +"Donjon n° :" + jControl.jeu.getDonjonNum());
	    southBar.setFont(font3);
	    southBar.setEditable(false);
		//System.out.println("joueur apres clic : " + jControl.jeu.getTourJ() + "\n");
	}
	
	// fait tourner la partie une fois les perso choisi
	public void jeuBTD(int vague) {
		if (vague == 1) {
			affichePlateau(jControl.jeu.getDonjonNum());
			jControl.creationDonjons();
			if (first == false) {jControl.incrDonjonNum();}
		}
		d = jControl.jeu.getDonj();
		if (d.getBoss() == null) {
			prepareVague(d);
		}
		else {
			prepareBoss(d);
		}
		//afficheJoueurTour();
		
		if (jControl.jeu.getEnVie() == 0){
			perso.setText("Vous avez perdu !");
			perso.setVisible(true);
			System.exit(0);
		}
		else if (jControl.jeu.getEnVie() > 0 && jControl.jeu.getDonjonNum() > 6 ){ //TODO remettre a 5 des que debug dans console
			perso.setText("Vous avez gagne !");
			perso.setVisible(true);
			System.exit(0);
		}
	}
	public void prepareVague(Donjon d) {
		ennemi1B.setText(d.getPopVague(vagueNum)[0].getClasse());
		ennemi2B.setText(d.getPopVague(vagueNum)[1].getClasse());
		ennemi1B.setVisible(true);
		ennemi2B.setVisible(true);
		if (vagueNum == 1) {
			ennemi3B.setVisible(false);
			ennemi4B.setVisible(false);
			ennemi5B.setVisible(false);
			//ennemi3B.setEnabled(false);
			//ennemi4B.setEnabled(false);
			//ennemi5B.setEnabled(false);
		}
		if (vagueNum >= 2) {
			ennemi3B.setText(d.getPopVague(vagueNum)[2].getClasse());
			ennemi3B.setVisible(true);
			//ennemi3B.setEnabled(true);
		}
		if (vagueNum == 3) {
			if (first) {first = false;}
			ennemi4B.setText(d.getPopVague(vagueNum)[3].getClasse());
			ennemi5B.setText(d.getPopVague(vagueNum)[4].getClasse());
			ennemi4B.setVisible(true);
			ennemi5B.setVisible(true);
			//ennemi4B.setEnabled(true);
			//ennemi5B.setEnabled(true);
		}
	}
	public void prepareBoss(Donjon d) {
		
	}
	public void incVague() {
		if (vagueNum == 1 || vagueNum == 2 || vagueNum == 3) {vagueNum ++;}
		if (vagueNum == 4) {vagueNum = 1;}
	}
	public void afficheJoueurTour() {
		perso.setFont(font3);
		//perso.setText("Joueur " + tourJoueur + ", a vous de jouer : ");
		perso.setVisible(true);
	}
}
