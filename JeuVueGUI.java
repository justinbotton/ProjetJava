package info;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JeuVueGUI {
	public static class Fenetre extends JFrame{
		public Fenetre() {
			this.setTitle("Beat the dungeon");
			this.setSize(1600, 800);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setContentPane(new Panneau());
			
			this.setVisible(true);
		}
	}
	public static class Panneau extends JPanel{
		private static final ImageObserver Observer = null;

		public void paintComponent(Graphics g){
			g.fillRect(0, 0, 400, this.getHeight());
			
			Font font = new Font("Courier", Font.BOLD, 20);
		    g.setFont(font);
		    g.setColor(Color.WHITE);          
		    g.drawString("Bienvenue dans Beat The Dungeon", 10, 20);    
		    
		    try {
		        Image img = ImageIO.read(new File("C:/Users/Philemon/Pictures/Donjon/map3.png"));
		        g.drawImage(img, 400, 0, this.getWidth() - 400, this.getHeight(), this);
		    } 
		    catch (IOException e) {
		    	e.printStackTrace();
		    }
		  }             
	}
	
	public static void main(String[] args){
		Fenetre fen = new Fenetre();
	}       

}