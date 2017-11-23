/**
 * 
 */
package info;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author philemon
 *
 */
public class DonjonTest {
	Donjon d1;
	Donjon d2;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		d1 = new Donjon(7);
		d2 = new Donjon("samourai", 10);
	}

	@Test
	public void testPremierDonjon() {
		assertNotNull(d1);
		assertEquals(2, d1.getVague1().length);
		assertEquals(3, d1.getVague2().length);
		assertEquals(5, d1.getVague3().length);
		for (int i = 0; i < d1.getVague1().length; i++) {
			if (d1.getVague1()[i] instanceof Ennemi) {
				assertTrue(true);
			}
			else {
				fail();
			}
		}
		for (int i = 0; i < d1.getVague2().length; i++) {
			if (d1.getVague2()[i] instanceof Ennemi) {
				assertTrue(true);
			}
			else {
				fail();
			}
		}
		for(int i = 0; i < d1.getVague3().length; i++) {
			if(d1.getVague3()[i] instanceof Ennemi) {
				assertTrue(true);
			}
			else {
				fail();
			}
		}
	}
	
	@Test
	public void testDeuxiemeDonjon() {
		assertNotNull(d2);
		assertEquals(2, d2.getVague1().length);
		assertEquals(3, d2.getVague2().length);
		assertNotNull(d2.getBoss());
		for (int i = 0; i < d2.getVague1().length; i++) {
			if (d2.getVague1()[i] instanceof Ennemi) {
				assertTrue(true);
			}
			else {
				fail();
			}
		}
		for (int i = 0; i < d2.getVague2().length; i++) {
			if (d2.getVague2()[i] instanceof Ennemi) {
				assertTrue(true);
			}
			else {
				fail();
			}
		}
		
		if (d2.getBoss() instanceof Ennemi) {
			assertTrue(true);
		}
		else {
			fail();
		}
		
	}
	@Test
	public void testLootDonjon() {
		d1.lootDonjon(2,2);
		assertEquals(5, d1.getloot().size());
		assertNotNull(d1.getloot());
		assertEquals("epee", d1.getloot().get(0));
		assertEquals("epee", d1.getloot().get(1));
		assertEquals("epee", d1.getloot().get(2));
		assertEquals("epee", d1.getloot().get(3));
		assertEquals("carte", d1.getloot().get(4));
	}

	@Test
	public void testNombreEnnemi() {
		int mage=0;
		int troll=0;
		int mage2=0;
		int troll2=0;
		for(int i = 0; i < d1.getVague2().length; i++){
			if (d1.getVague2()[0].getClass().equals("troll")) {
				troll++;
			}
			if (d1.getVague2()[0].getClass().equals("magicien noir")) {
				mage ++;
			}
		}
		for(int i = 0; i < d1.getVague3().length; i++){
			if (d1.getVague3()[0].getClass().equals("troll")) {
				troll2++;
			}
			if (d1.getVague3()[0].getClass().equals("magicien noir")) {
				mage2 ++;
			}
			
		}
		if(mage > 2 || troll > 2) {
			fail();
		}
		if(mage > 2 || troll > 2) {
			fail();
		}
		else {
			assertTrue(true);
		}
	}

}
