/**
 * 
 */
package info;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author louis & justin & philemon
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

	/**
	 * test du donjon d1
	 */
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
	
	/**
	 * test du donjon d2
	 */
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
	
	/**
	 * test du loot
	 */
	@Test
	public void testLootDonjon() {
		d1.lootDonjon(2);
		assertNotNull(d1.getLoot());
		assertEquals(4, d1.getLoot().size());
		d2.lootDonjon(5);
		assertNotNull(d2.getLoot());
		assertEquals(10, d2.getLoot().size());
	}

	/**
	 * test nombre ennemi par vagues
	 */
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
