package info;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author louis
 *
 */
public class EnnemiTest {
	Ennemi e;
	Ennemi e2;
	Ennemi e3;
	Ennemi e4;
	Ennemi e5;
	Ennemi e6;
	Ennemi e7;
	Ennemi e8;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		e = new Ennemi();
		e2 = new Ennemi("gobelin",1);
		e3 = new Ennemi("troll",1);
		e4 = new Ennemi("groupe gobelin",1);
		e5 = new Ennemi("magicien noir",1);
		e6 = new Ennemi("samourai",1);
		e7 = new Ennemi("grand mage",1);
		e8 = new Ennemi();
		
	}
	/**
	 * teste le constructeur vide.
	 */
	@Test 
	public void testConstructeurVide() {
		//fail("Not yet implemented");
		assertNotNull(e);
		assertEquals("gobelin", e.getClasse());
		Arme a = e.getArmeDroite();
		assertEquals("hachette", a.getNom());
		assertEquals(3, a.getDegat());
		assertEquals("mob", e.getType());
		assertEquals(2, e.getForce());
		assertEquals(10, e.getEndurance());
		assertEquals(20, e.getVie());
		assertEquals(1, e.getVitesseAttaque());
		assertEquals(1, e.getNiveau());
		assertEquals("vivant", e.getEtat());
		
	}	
	/**
	 * teste le constructeur (gobelin).
	 */
	@Test
	public void testGobelin() {
		//fail("Not yet implemented");
		assertNotNull(e2);
		assertEquals("gobelin", e2.getClasse());
		Arme a = e2.getArmeDroite();
		assertEquals("hachette", a.getNom());
		assertEquals(3, a.getDegat());
		assertEquals("mob", e2.getType());
		assertEquals(2, e2.getForce());
		assertEquals(10, e2.getEndurance());
		assertEquals(20, e2.getVie());
		assertEquals(1, e2.getVitesseAttaque());
		assertEquals(1, e2.getNiveau());
		assertEquals("vivant", e2.getEtat());
	}	
	/**
	 * teste le constructeur (troll).
	 */
	@Test
	public void testTroll() {
		//fail("Not yet implemented");
		assertNotNull(e3);
		assertEquals("troll", e3.getClasse());
		Arme a = e3.getArmeDroite();
		assertEquals("masse", a.getNom());
		assertEquals(3, a.getDegat());
		assertEquals("mob", e3.getType());
		assertEquals(2, e3.getForce());
		assertEquals(20, e3.getEndurance());
		assertEquals(40, e3.getVie());
		assertEquals(1, e3.getVitesseAttaque());
		assertEquals(1, e3.getNiveau());
		assertEquals("vivant", e3.getEtat());
	}
	/**
	 * teste le constructeur (groupe gobelin).
	 */
	@Test
	public void testGroupeGobelin() {
		//fail("Not yet implemented");
		assertNotNull(e4);
		assertEquals("groupe gobelin", e4.getClasse());
		Arme a = e4.getArmeDroite();
		assertEquals("hachette", a.getNom());
		assertEquals(3, a.getDegat());
		assertEquals("mob", e4.getType());
		assertEquals(2, e4.getForce());
		assertEquals(30, e4.getEndurance());
		assertEquals(60, e4.getVie());
		assertEquals(1, e4.getVitesseAttaque());
		assertEquals(1, e4.getNiveau());
		assertEquals("vivant", e4.getEtat());
	}
	/**
	 * teste le constructeur (magicien noir).
	 */
	@Test
	public void testMagicienNoir() {
		//fail("Not yet implemented");
		assertNotNull(e5);
		assertEquals("magicien noir", e5.getClasse());
		Arme a = e5.getArmeDroite();
		assertEquals("baton", a.getNom());
		assertEquals(3, a.getDegat());
		assertEquals("mob", e5.getType());
		assertEquals(3, e5.getForce());
		assertEquals(15, e5.getEndurance());
		assertEquals(30, e5.getVie());
		assertEquals(1, e5.getVitesseAttaque());
		assertEquals(1, e5.getNiveau());
		assertEquals("vivant", e5.getEtat());
	}
	/**
	 * teste le constructeur (samourai).
	 */
	@Test
	public void testSamourai() {
		//fail("Not yet implemented");
		assertNotNull(e6);
		assertEquals("samourai", e6.getClasse());
		Arme a = e6.getArmeDroite();
		assertEquals("katana", a.getNom());
		assertEquals(5, a.getDegat());
		assertEquals("boss", e6.getType());
		assertEquals(8, e6.getForce());
		assertEquals(40, e6.getEndurance());
		assertEquals(80, e6.getVie());
		assertEquals(1, e6.getVitesseAttaque());
		assertEquals(1, e6.getNiveau());
		assertEquals("vivant", e6.getEtat());
	}
	/**
	 * teste le constructeur (grand mage).
	 */
	@Test
	public void testGrandMage() {
		//fail("Not yet implemented");
		assertNotNull(e7);
		assertEquals("grand mage", e7.getClasse());
		Arme a = e7.getArmeDroite();
		assertEquals("baton", a.getNom());
		assertEquals(4, a.getDegat());
		assertEquals("boss", e7.getType());
		assertEquals(5, e7.getForce());
		assertEquals(50, e7.getEndurance());
		assertEquals(100, e7.getVie());
		assertEquals(1, e7.getVitesseAttaque());
		assertEquals(1, e7.getNiveau());
		assertEquals("vivant", e7.getEtat());
	}
	/**
	 * teste la mort et les degats.
	 */
	@Test
	public void testDegatEnnemi() {
		e2.setDegat(10);
		assertEquals(10, e2.getVie());
		e2.setDegat(10);
		assertEquals(0, e2.getVie());
		assertEquals("mort", e2.getEtat());
		e7.setDegat(37);
		assertEquals(63, e7.getVie());
		e7.setDegat(70);
		assertEquals(0, e7.getVie());
		assertEquals("mort", e7.getEtat());
	}

	/**
	 * teste les set.
	 */
	@Test
	public void testSets() {
		assertNotNull(e8);
		e8.setArmeDroite(new Arme("epee", 5));
		e8.setClasse("troll");
		e8.setNiveau(5);
		e8.setEndurance(5);
		e8.setVie(5);
		e8.setForce(5);
		e8.setEtat("mort");
		e8.setType("mob");
		e8.setVitesseAttaque(5);
		assertEquals("troll", e8.getClasse());
		Arme a = e8.getArmeDroite();
		assertEquals("epee", a.getNom());
		assertEquals(5, a.getDegat());
		assertEquals("mob", e8.getType());
		assertEquals(5, e8.getForce());
		assertEquals(5, e8.getEndurance());
		assertEquals(5, e8.getVie());
		assertEquals(5, e8.getVitesseAttaque());
		assertEquals(5, e8.getNiveau());
		assertEquals("mort", e8.getEtat());
	}
	
	/**
	 * teste attaque.
	 */
	@Test
	public void testAttaque() {
		e3.attaque(e4);
		assertEquals(54, e4.getVie());
	}

}
