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

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		e = new Ennemi();
		e2 = new Ennemi(1,1);
		e3 = new Ennemi(2,1);
		e4 = new Ennemi(3,1);
		e5 = new Ennemi(4,1);
		e6 = new Ennemi(991,1);
		e7 = new Ennemi(992,1);
	}
	/**
	 * teste le constructeur vide.
	 */
	@Test 
	public void testConstructeurVide() {
		//fail("Not yet implemented");
		assertNotNull(e);
		assertEquals("gobelin", e.getClasse());
		assertEquals("hachette", e.getArmeDroite());
		assertEquals("mob", e.getType());
		assertEquals(2, e.getForce());
		assertEquals(10, e.getEndurance());
		assertEquals(20, e.getVie());
		assertEquals(1, e.getVitesseAttaque());
		assertEquals(1, e.getNiveau());
		assertEquals("vivant", e.getEtat());
	}
	
	/**
	 * teste le constructeur int int (gobelin).
	 */
	@Test
	public void testGobelin() {
		//fail("Not yet implemented");
		assertNotNull(e2);
		assertEquals("gobelin", e2.getClasse());
		assertEquals("hachette", e2.getArmeDroite());
		assertEquals("mob", e2.getType());
		assertEquals(2, e2.getForce());
		assertEquals(10, e2.getEndurance());
		assertEquals(20, e2.getVie());
		assertEquals(1, e2.getVitesseAttaque());
		assertEquals(1, e2.getNiveau());
		assertEquals("vivant", e2.getEtat());
	}
	
	
	/**
	 * teste le constructeur String int.
	 */
	@Test
	public void testConstructeurStringInt() {
		//fail("Not yet implemented");
		assertEquals("gobelin", e.getClasse());
		assertEquals("hachette", e.getArmeDroite());
		assertEquals("mob", e.getType());
		assertEquals(2, e.getForce());
		assertEquals(10, e.getEndurance());
		assertEquals(20, e.getVie());
		assertEquals(1, e.getVitesseAttaque());
		assertEquals(1, e.getNiveau());
		assertEquals("vivant", e.getEtat());
	}

}
