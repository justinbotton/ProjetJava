package info;

import java.awt.*;
import java.awt.event.*;
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
	JFrame plateauCommande = new JFrame();
	JLabel label = new JLabel("");
	JLabel perso = new JLabel("");
	JLabel joueur = new JLabel("");
	Font font1 = new Font("Algerian", Font.BOLD, 100);
	Font font2 = new Font("Algerian", Font.BOLD, 50);
	int tourJoueur = 1;

	public JeuVueGUI(Jeu model, JeuController jControl) {
		
		super(model, jControl);
		//update(null, null);
		
		//Construction de la fenêtre
		jeuJFrame = new JFrame(" ");
		jeuJFrame.setTitle("Beat the Dungeon");
		jeuJFrame.setSize(1600, 800);
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
		perso.setText("Vous avez choisis : " + jControl.jeu.getJoueur().get(0).getClasse());
		if(tourJoueur != 2) {
			afficheChoixPerso(2);
			tourJoueur++;
		}
		else {
			perso.setText("La partie va commencer");
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
	public void affichePlateau() {
		ImageIcon icone = new ImageIcon("C:/Users/Philemon/Pictures/Donjon/map3.png");
		JLabel image = new JLabel(icone);
	    jeuJFrame.add(image);
	    jeuJFrame.setVisible(true);
		
				
	}
}
