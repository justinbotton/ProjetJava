/**
 * 
 */
package info;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author justin
 * 17/11/2017
 * @version 0.1
 *
 */
public class HeroTest {
	
	Hero h1;
	Hero elfe;
	Hero nain;
	Hero orque;
	Hero humain;
	Hero defaut;
	Loot l1;
	Loot l2;
	Loot l3;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		 h1 = new Hero();
		 elfe = new Hero("Elfe");
		 nain = new Hero("Nain");
		 orque = new Hero("Orque");
		 humain = new Hero("Humain");
		 defaut = new Hero(" ");
		 l1 = new Loot("gourde", 20);
		 l2 = new Loot("katana use", 100);
		 l3 = new Loot("katana", 200);
	}

	/**
	 * Test du constructeur vide
	 */
	@Test
	public void testConstructeurVide() {
		assertEquals("fourchette", h1.getArmeDroite().getNom());
		assertEquals(1, h1.getArmeDroite().getDegat());
		assertEquals("euh... je n ai pas choisi de classe moi !!", h1.getClasse());
		assertEquals(30, h1.getEndurance());
		assertEquals(60, h1.getVie());
		assertEquals(5, h1.getForce());
		assertEquals(1, h1.getVitesseAttaque());
		assertEquals(1, h1.getNiveau());
		assertEquals(0, h1.getXp());
		assertEquals("vivant", h1.getEtat());
	}
	
	/**
	 * Test du constructeur avec argument
	 */
	@Test
	public void testConctructeurAvecArgument() {
		//test de l etat
		assertEquals("vivant", elfe.getEtat());
		assertEquals("vivant", nain.getEtat());
		assertEquals("vivant", orque.getEtat());
		assertEquals("vivant", humain.getEtat());
		assertEquals("vivant", defaut.getEtat());
		
		//test du niveau
		assertEquals(1, elfe.getNiveau());
		assertEquals(1, nain.getNiveau());
		assertEquals(1, orque.getNiveau());
		assertEquals(1, humain.getNiveau());
		assertEquals(1, defaut.getNiveau());
		
		//test de l xp
		assertEquals(0, elfe.getXp());
		assertEquals(0, nain.getXp());
		assertEquals(0, orque.getXp());
		assertEquals(0, humain.getXp());
		assertEquals(0, defaut.getXp());
		
		//test de la classe
		assertEquals("Elfe", elfe.getClasse());
		assertEquals("Nain", nain.getClasse());
		assertEquals("Orque", orque.getClasse());
		assertEquals("Humain", humain.getClasse());
		assertEquals("je suis un...heu...je n ai pas choisi !!", defaut.getClasse());
		
		//test du nom de l arme
		assertEquals("arc", elfe.getArmeDroite().getNom());
		assertEquals("hachette", nain.getArmeDroite().getNom());
		assertEquals("masse", orque.getArmeDroite().getNom());
		assertEquals("epee", humain.getArmeDroite().getNom());
		assertEquals("fourchette", defaut.getArmeDroite().getNom());
		
		//test des degats de l arme
		assertEquals(3, elfe.getArmeDroite().getDegat());
		assertEquals(3, nain.getArmeDroite().getDegat());
		assertEquals(3, orque.getArmeDroite().getDegat());
		assertEquals(3, humain.getArmeDroite().getDegat());
		assertEquals(1, defaut.getArmeDroite().getDegat());
		
		//test de l endurance
		assertEquals(40, elfe.getEndurance());
		assertEquals(60, nain.getEndurance());
		assertEquals(80, orque.getEndurance());
		assertEquals(30, humain.getEndurance());
		assertEquals(30, defaut.getEndurance());
		
		//test de la vie
		assertEquals(80, elfe.getVie());
		assertEquals(120, nain.getVie());
		assertEquals(160, orque.getVie());
		assertEquals(60, humain.getVie());
		assertEquals(60, defaut.getVie());
		
		//test de la force
		assertEquals(4, elfe.getForce());
		assertEquals(3, nain.getForce());
		assertEquals(1, orque.getForce());
		assertEquals(5, humain.getForce());
		assertEquals(5, defaut.getForce());
		
		//test de la vitesse d attaque
		assertEquals(1, elfe.getVitesseAttaque());
		assertEquals(1, nain.getVitesseAttaque());
		assertEquals(1, orque.getVitesseAttaque());
		assertEquals(1, humain.getVitesseAttaque());
		assertEquals(1, defaut.getVitesseAttaque());
	}
	
	/**
	 * test capLevel()
	 */
	@Test
	public void capLevel() {
		assertEquals(500, elfe.capLevel());
		assertEquals(500, nain.capLevel());
		assertEquals(500, orque.capLevel());
		assertEquals(500, humain.capLevel());
		assertEquals(500, defaut.capLevel());
		elfe.setNiveau(4);
		assertEquals(2000, elfe.capLevel());
		elfe.setNiveau(1);
	}
	/**
	 * test methode ajoutXp
	 */
	@Test
	public void testAjoutXp() {
		
		//test sans saut de niveau
		elfe.ajoutXp(20);
		assertEquals(20, elfe.getXp());
		assertEquals(1, elfe.getNiveau());
		elfe.setXp(0);
		nain.ajoutXp(40);
		assertEquals(40, nain.getXp());
		assertEquals(1, nain.getNiveau());
		nain.setXp(0);
		
		//test avec saut de niveau
		orque.ajoutXp(500);
		assertEquals(0, orque.getXp());
		assertEquals(2, orque.getNiveau());
		orque.setXp(0);
		orque.setNiveau(1);
		humain.ajoutXp(1000);
		assertEquals(500, humain.getXp());
		assertEquals(2, humain.getNiveau());
		humain.setXp(0);
		humain.setNiveau(1);
	}
	
	/**
	 * test methode ramasser
	 */
	@Test
	public void testRamasser() {
		ArrayList<Loot> array = new ArrayList<Loot>();
		array.add(l1);
		array.add(l2);
		array.add(l3);
		
		//Avec l1 ajout de 20 Xp
		elfe.ramasser(array, 0);
		assertEquals(20, elfe.getXp());
		elfe.setXp(0);
		elfe.setNiveau(1);
		array.remove(l1);
		
		//Avec l2 ajout de 100Xp
		orque.ramasser(array, 1);
		assertEquals(100, orque.getXp());
		orque.setXp(0);
		orque.setNiveau(1);
		array.remove(l2);
		
		//Avec l3 changement d'arme
		nain.ramasser(array, 2);
		assertEquals("katana", nain.getArmeDroite().getNom());
		assertEquals(5, nain.getArmeDroite().getDegat());
		nain.setXp(0);
		nain.setNiveau(1);
		array.remove(l3);
	}
}

