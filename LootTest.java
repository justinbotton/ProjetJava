/**
 * 
 */
package info;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

/**
 * @author Louis & Justin & Philemon
 *
 */
public class LootTest {

	/**
	 * variables du constructeur sans argument
	 */
	Loot a1 = new Loot();
	
	/**
	 * variables du constructeur avec arguments
	 */
	Loot b1 = new Loot("epee cassee", 25);
	Loot b2 = new Loot("fourchette pliee", 5);
	Loot b3 = new Loot("katana use", 100);
	
	/**
	 * assignation des variables
	 * @throws java.lang.Exception
	 */
	/*@Before
	public void setUp() throws Exception {
		a1 = new Loot();
		b1 = new Loot("epee cassee", 25);			//WTF ?!!?!
		b2 = new Loot("fourchette pliee", 5);
		b3 = new Loot("katana use", 100);
	}*/

	/**
	 * test des getter
	 */
	@Test
	public void testGetter() {
		assertTrue(a1.getNom().equals("gourde"));
		assertTrue(a1.getXp() == 20);
		assertTrue(b1.getNom().equals("epee cassee"));
		assertTrue(b1.getXp() == 25);
		assertTrue(b2.getNom().equals("fourchette pliee"));
		assertTrue(b2.getXp() == 5);
		assertTrue(b3.getNom().equals("katana use"));
		assertTrue(b3.getXp() == 100);
	}
	
	/**
	 * test constructeur sans argument
	 */
	@Test
	public void testConstructeurSansArgument() {
		assertEquals(a1.getNom(), "gourde");
		assertEquals(a1.getXp(), 20);
	}
	
	/**
	 * test constructeur avec arguments
	 */
	@Test
	public void testConstructeurAvecArguments() {
		assertEquals(b1.getNom(), "epee cassee");
		assertEquals(b1.getXp(), 25);
		assertEquals(b2.getNom(), "fourchette pliee");
		assertEquals(b2.getXp(), 5);
		assertEquals(b3.getNom(), "katana use");
		assertEquals(b3.getXp(), 100);
	}
	
	/**
	 * test des setter
	 */
	@Test
	public void testSetter() {
		a1.setNom("sac");
		assertEquals(a1.getNom(), "sac");
		a1.setXp(40);
		assertEquals(a1.getXp(), 40);
		b1.setNom("tissu");
		assertEquals(b1.getNom(), "tissu");
		b1.setXp(1);
		assertEquals(b1.getXp(), 1);
		b2.setNom("cuillere");
		assertEquals(b2.getNom(), "cuillere");
		b2.setXp(78);
		assertEquals(b2.getXp(), 78);
		b3.setNom("glaive");
		assertEquals(b3.getNom(), "glaive");
		b3.setXp(1000);
		assertEquals(b3.getXp(), 1000);
	}
}
