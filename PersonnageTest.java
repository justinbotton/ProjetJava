package info;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PersonnageTest {

	Personnage p1;
	Personnage p2;
	Personnage p3;
	Personnage p4;
	Personnage p5;
	Arme a1;
	Arme a2;
	Arme a3;
	Arme a4;
	Arme a5;
	
	/**
	 * Assignation des variables.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		//Personnage Elfe
		p1 = new Personnage();
		a1 = new Arme("arc", 3);
		p1.setUpPersonnage("Elfe", 40, 80, 4, a1, 1);
		p1.setNiveau(1);
		p1.setEtat("vivant");
		
		//Personnage Nain
		p2 = new Personnage();
		a2 = new Arme("hachette", 3);
		p2.setUpPersonnage("Nain", 60, 120, 3, a2, 1);
		p2.setNiveau(1);
		p2.setEtat("vivant");
		
		//Personnage Orque
		p3 = new Personnage();
		a3 = new Arme("masse", 3);
		p3.setUpPersonnage("Orque", 80, 160, 1, a3, 1);
		p3.setNiveau(1);
		p3.setEtat("vivant");
		
		//Personnage Humain
		p4 = new Personnage();
		a4 = new Arme("epee", 3);
		p4.setUpPersonnage("Humain", 30, 60, 5, a4, 1);
		p4.setNiveau(1);
		p4.setEtat("vivant");
		
		//Personnage defaut
		p5 = new Personnage();
		a5 = new Arme("fourchette", 1);
		p5.setUpPersonnage("je suis un...heu...je n ai pas choisi !!", 30, 60, 5, a5, 1);
		p5.setNiveau(1);
		p5.setEtat("vivant");
	}

	/**
	 * Test getter.
	 */
	@Test
	public void testGetter() {
		
		//getNiveau()
		assertEquals(p1.getNiveau(), 1);
		assertEquals(p2.getNiveau(), 1);
		assertEquals(p3.getNiveau(), 1);
		assertEquals(p4.getNiveau(), 1);
		assertEquals(p5.getNiveau(), 1);
		
		//getVie()
		assertEquals(p1.getVie(), 80);
		assertEquals(p2.getVie(), 120);
		assertEquals(p3.getVie(), 160);
		assertEquals(p4.getVie(), 60);
		assertEquals(p5.getVie(), 60);
		
		//getForce()
		assertEquals(p1.getForce(), 4);
		assertEquals(p2.getForce(), 3);
		assertEquals(p3.getForce(), 1);
		assertEquals(p4.getForce(), 5);
		assertEquals(p5.getForce(), 5);
		
		//getEndurance()
		assertEquals(p1.getEndurance(), 40);
		assertEquals(p2.getEndurance(), 60);
		assertEquals(p3.getEndurance(), 80);
		assertEquals(p4.getEndurance(), 30);
		assertEquals(p5.getEndurance(), 30);
		
		//getArmeDroite()
		assertEquals(p1.getArmeDroite(), a1);
		assertEquals(p2.getArmeDroite(), a2);
		assertEquals(p3.getArmeDroite(), a3);
		assertEquals(p4.getArmeDroite(), a4);
		assertEquals(p5.getArmeDroite(), a5);
		
		//getClasse() -> classe du personnage
		assertEquals(p1.getClasse(), "Elfe");
		assertEquals(p2.getClasse(), "Nain");
		assertEquals(p3.getClasse(), "Orque");
		assertEquals(p4.getClasse(), "Humain");
		assertEquals(p5.getClasse(), "je suis un...heu...je n ai pas choisi !!");
		
		//getVitesseAttaque()
		assertEquals(p1.getVitesseAttaque(), 1);
		assertEquals(p2.getVitesseAttaque(), 1);
		assertEquals(p3.getVitesseAttaque(), 1);
		assertEquals(p4.getVitesseAttaque(), 1);
		assertEquals(p5.getVitesseAttaque(), 1);
		
		//getEtat()
		assertEquals(p1.getEtat(), "vivant");
		assertEquals(p2.getEtat(), "vivant");
		assertEquals(p3.getEtat(), "vivant");
		assertEquals(p4.getEtat(), "vivant");
		assertEquals(p5.getEtat(), "vivant");
		
		//getType() -> voir EnnemiTest.java
	}
	
	/**
	 * Test methode setDegat(int).
	 */
	@Test
	public void testSetDegat() {
		p1.setDegat(10);
		assertEquals(p1.getVie(), 70);
		p1.setVie(80);
		p2.setDegat(100);
		assertEquals(p2.getVie(), 20);
		p2.setVie(120);
		p3.setDegat(200);
		assertEquals(p3.getVie(), 0);
		assertEquals(p3.getEtat(), "mort");
		p3.setVie(160);
		p3.setEtat("vivant");
		p4.setDegat(60);
		assertEquals(p4.getVie(), 0);
		assertEquals(p4.getEtat(), "mort");
		p4.setVie(60);
		p4.setEtat("vivant");
	}
	
	/**
	 * Test methode attaque(Personnage).
	 */
	@Test
	public void testAttaque() {
		p1.attaque(p2);
		assertEquals(p2.getVie(), 112);
		p2.attaque(p1);
		assertEquals(p1.getVie(), 73);
		p3.attaque(p4);
		assertEquals(p4.getVie(), 55);
		p4.attaque(p3);
		assertEquals(p3.getVie(), 151);
		p4.attaque(p5);
		assertEquals(p5.getVie(), 51);
	}
	
	/**
	 * Test setUpPersonnage(String, int, int, int, Arme, int).
	 */
	@Test
	public void testSetUpPersonnage() {
		Personnage pers = new Personnage();
		Arme arme = new Arme("arc", 3);
		pers.setUpPersonnage("Elfe", 40, 80, 4, arme, 1);
		pers.setNiveau(1);
		pers.setEtat("vivant");
		assertEquals(pers.getNiveau(), 1);
		assertEquals(pers.getVie(), 80);
		assertEquals(pers.getForce(), 4);
		assertEquals(pers.getEndurance(), 40);
		assertEquals(pers.getArmeDroite(), arme);
		assertEquals(pers.getClasse(), "Elfe");
		assertEquals(pers.getVitesseAttaque(), 1);
		assertEquals(pers.getEtat(), "vivant");
	}

	/**
	 * Test setter.
	 */
	@Test
	public void testSetter() {
		
		//setNiveau()
		p1.setNiveau(4);
		assertEquals(p1.getNiveau(), 4);
		p2.setNiveau(10);
		assertEquals(p2.getNiveau(), 10);
		p3.setNiveau(2);
		assertEquals(p3.getNiveau(), 2);
		p4.setNiveau(20);
		assertEquals(p4.getNiveau(), 20);
		p5.setNiveau(52);
		assertEquals(p5.getNiveau(), 52);
		
		//setVie()
		p1.setVie(10);
		assertEquals(p1.getVie(), 10);
		p2.setVie(100);
		assertEquals(p2.getVie(), 100);
		p3.setVie(1524);
		assertEquals(p3.getVie(), 1524);
		p4.setVie(0);
		assertEquals(p4.getVie(), 0);
		p5.setVie(1);
		assertEquals(p5.getVie(), 1);
		
		//setForce()
		p1.setForce(50);
		assertEquals(p1.getForce(), 50);
		p2.setForce(0);
		assertEquals(p2.getForce(), 0);
		p3.setForce(150);
		assertEquals(p3.getForce(), 150);
		p4.setForce(25);
		assertEquals(p4.getForce(), 25);
		p5.setForce(12);
		assertEquals(p5.getForce(), 12);
		
		//setEndurance()
		p1.setEndurance(10);
		assertEquals(p1.getEndurance(), 10);
		p2.setEndurance(100);
		assertEquals(p2.getEndurance(), 100);
		p3.setEndurance(2);
		assertEquals(p3.getEndurance(), 2);
		p4.setEndurance(180);
		assertEquals(p4.getEndurance(), 180);
		p5.setEndurance(90);
		assertEquals(p5.getEndurance(), 90);
		
		//setArmeDroite()
		p1.setArmeDroite(a2);
		assertEquals(p1.getArmeDroite(), a2);
		p2.setArmeDroite(a1);
		assertEquals(p2.getArmeDroite(), a1);
		p3.setArmeDroite(a4);
		assertEquals(p3.getArmeDroite(), a4);
		p4.setArmeDroite(a3);
		assertEquals(p4.getArmeDroite(), a3);
		p5.setArmeDroite(a1);
		assertEquals(p5.getArmeDroite(), a1);
		
		//setClasse()
		p1.setClasse("Nain");
		assertEquals(p1.getClasse(), "Nain");
		p2.setClasse("Elfe");
		assertEquals(p2.getClasse(), "Elfe");
		p3.setClasse("Humain");
		assertEquals(p3.getClasse(), "Humain");
		p4.setClasse("Orque");
		assertEquals(p4.getClasse(), "Orque");
		p5.setClasse("Elfe");
		assertEquals(p5.getClasse(), "Elfe");
		
		//setVitesseAttaque()
		p1.setVitesseAttaque(10);
		assertEquals(p1.getVitesseAttaque(), 10);
		p2.setVitesseAttaque(2);
		assertEquals(p2.getVitesseAttaque(), 2);
		p3.setVitesseAttaque(150);
		assertEquals(p3.getVitesseAttaque(), 150);
		p4.setVitesseAttaque(200);
		assertEquals(p4.getVitesseAttaque(), 200);
		p5.setVitesseAttaque(450);
		assertEquals(p5.getVitesseAttaque(), 450);
		
		//setEtat()
		p1.setEtat("mort");
		assertEquals(p1.getEtat(), "mort");
		p2.setEtat("vivant");
		assertEquals(p2.getEtat(), "vivant");
		p3.setEtat("mort");
		assertEquals(p3.getEtat(), "mort");
		p4.setEtat("vivant");
		assertEquals(p4.getEtat(), "vivant");
		p5.setEtat("mort");
		assertEquals(p5.getEtat(), "mort");
		
		//setType() -> voir EnnemiTest.java
	}
}
