package info;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class JeuVueGUI extends JeuVue implements ActionListener, Observer {

	private JFrame jeuJFrame;
	private JTextField numeroLivre = new JTextField(3);
	JButton jouerB = new JButton("Jouer");
	JButton chargerB = new JButton("Charger");
	JButton quitterB = new JButton("Quitter");
	JButton elfeB = new JButton("Elfe");
	JButton nainB = new JButton("Nain");
	JButton orqueB = new JButton("Orque");
	JButton humainB = new JButton("Humain");
	JButton joueur1B = new JButton("J1");
	JButton joueur2B = new JButton("J2");
	JButton ennemi1B = new JButton("E1");
	JButton ennemi2B = new JButton("E2");
	JButton ennemi3B = new JButton("E3");
	JButton ennemi4B = new JButton("E4");
	JButton ennemi5B = new JButton("E5");
	ArrayList<JButton> ennemiList = new ArrayList<JButton>();
	JButton bossB = new JButton("BOSS");
	JLabel label = new JLabel("");
	JLabel perso = new JLabel("");
	JLabel joueur = new JLabel("");
	Font font1 = new Font("Algerian", Font.BOLD, 100);
	Font font2 = new Font("Algerian", Font.BOLD, 50);
	int tourJoueur = 1;

	public JeuVueGUI(Jeu model, JeuController jControl) {
		
		super(model, jControl);
		//update(null, null);
		ennemiList.add(ennemi1B);
		ennemiList.add(ennemi2B);
		ennemiList.add(ennemi3B);
		ennemiList.add(ennemi4B);
		ennemiList.add(ennemi5B);
		//Construction de la fenêtre
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
	    label.setVerticalAlignment(JLabel.TOP);
	    label.setFont(font1);
	    
	    perso.setPreferredSize(new Dimension(1600, 100));
	    perso.setHorizontalAlignment(JLabel.CENTER);
	    perso.setVerticalAlignment(JLabel.TOP);
	    perso.setFont(font2);
	    
	    jeuJFrame.add(label);

	    JPanel panelbuttons = new JPanel();
		panelbuttons.add(jouerB);
		panelbuttons.add(chargerB);
		panelbuttons.add(quitterB);
		
		jeuJFrame.add(panelbuttons, BorderLayout.SOUTH);
	    
		jeuJFrame.setVisible(true);
		
		jouerB.addActionListener(this);
		chargerB.addActionListener(this);
		quitterB.addActionListener(this);
		elfeB.addActionListener(this);
		nainB.addActionListener(this);
		orqueB.addActionListener(this);
		humainB.addActionListener(this);
		//jeuJFrame.setContentPane(new Panneau());
		/*textContent.setLayout(new BoxLayout(textContent, BoxLayout.Y_AXIS));
		
		
		
		jeuJFrame.add(textContent, BorderLayout.NORTH);
		
		JPanel fieldZone = new JPanel();
		fieldZone.setLayout(new BoxLayout(fieldZone, BoxLayout.X_AXIS));
		jeuJFrame.add(fieldZone, BorderLayout.CENTER);
		
		//Définition des actions sur les éléments de la GUI
		emprunteJButton.addActionListener(this);
		rendreJButton.addActionListener(this);
		jeuJFrame.pack();*/
		

		
		
	}

	public void affiche(String msg){
		
	}
	public void updateTable(){
		
	}
	@Override
	public void update(Observable o, Object arg) {
		updateTable();
		//textContent.remove(1);
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
	     /*else if (source == ennemi1B) {
	    	 onClickEnnemi(ennemi1B);
	     }
	     else if (source == ennemi2B) {
	    	 onClickEnnemi(ennemi2B);
	     }
	     else if (source == ennemi3B) {
	    	 onClickEnnemi(ennemi3B);
	     }
	     else if (source == ennemi4B) {
	    	 onClickEnnemi(ennemi4B);
	     }*/
	     else if (ennemiList.contains(source)) {
	    	 onClickEnnemi(source);
	     }
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
		//debug code
		//perso.setText("Vous avez choisis : " + jControl.jeu.getJoueur().get(0).getClasse());
		if(tourJoueur != 2) {
			afficheChoixPerso(2);
			tourJoueur++;
		}
		else {
			perso.setText("La partie va commencer...");
			jeuBTD();
			//affichePlateau();
		}
	}
	public void afficheChoixPerso(int i) {
		
		perso.setText("- Joueur " + i +" - choisissez votre personnage :");
	    perso.setVisible(true);
	    jeuJFrame.add(perso);
	    
		JPanel panelbuttons = new JPanel();
		panelbuttons.add(elfeB);
		panelbuttons.add(nainB);
		panelbuttons.add(orqueB);
		panelbuttons.add(humainB);
		elfeB.setVisible(true);
		humainB.setVisible(true);
		nainB.setVisible(true);
		orqueB.setVisible(true);
		jeuJFrame.add(panelbuttons, BorderLayout.SOUTH);
	}
	//affiche le plateau a chaque nouveau donjon
	public void affichePlateau(int num) {
		perso.setVisible(false);
		ImageIcon icone = new ImageIcon("C:/Users/louis/eclipse-workspace/TP2/src/info/map" + num +".png");
		JLabel image = new JLabel(icone);
		image.setSize(new Dimension(1400, 700));
	    jeuJFrame.add(image);
	    jeuJFrame.setVisible(true);
	    joueur1B.setBounds(10, 10, 10, 10); // (x,y,width, height)
	    joueur2B.setBounds(30, 10, 10, 10); 
	    joueur1B.setVisible(true);
	    joueur2B.setVisible(true);
	    JPanel panelJoueur = new JPanel();
	    panelJoueur.setAlignmentX(30);
	    panelJoueur.setAlignmentY(30);
	    panelJoueur.add(joueur1B);
	    panelJoueur.add(joueur2B);
	    jeuJFrame.add(panelJoueur);
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
	public void onClickEnnemi(Object source) {
		
	}
	
	// fait tourner la partie une fois les perso choisi
	public void jeuBTD() {
		affichePlateau(jControl.jeu.getDonjonNum());
		jControl.creationDonjons();
		Donjon d = jControl.jeu.getDonj();
		while (jControl.jeu.getEnVie() > 0 && jControl.jeu.getDonjonNum() <= 5 ) {
			if (jControl.jeu.getDonjonNum() == 1) {
				ennemi1B.setText(d.getVague1()[0].getClasse());
				ennemi2B.setText(d.getVague1()[1].getClasse());
				ennemi3B.setText(d.getVague1()[2].getClasse());
				ennemi1B.setVisible(true);
				ennemi2B.setVisible(true);
				ennemi3B.setVisible(true);
				JPanel panelEnnemi = new JPanel();
				panelEnnemi.add(ennemi1B);
				panelEnnemi.add(ennemi2B);
				panelEnnemi.add(ennemi3B);
				jeuJFrame.add(panelEnnemi);
			}
			jControl.jeu.setEnVie(0);
			jeuBTD();
		}
		if (jControl.jeu.getEnVie() == 0){
			perso.setText("Vous avez perdu !");
			perso.setVisible(true);
		}
		else {
			perso.setText("Vous avez gagn� !");
			perso.setVisible(true);
		}
	}
}
