/**
 * 
 */
package info;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author louis
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
		d2 = new Donjon("samourai", 10)
	}

	@Test
	public void testPremierDonjon() {
		assertEqualsNotNull(d1);
		assertEquals(2, getVague1().length);
		assertEquals(3, getVague2().length);
		assertEquals(5, getVague3().length);
		for(int i = 0; i < d1.getVague1().length; i++) {
			if(d1.getVague1()[i] instanceof Ennemi) {
				assertTrue();
			}
			else {
				fail();
			}
		}
		for(int i = 0; i < d1.getVague2().length; i++) {
			if(d1.getVague2()[i] instanceof Ennemi) {
				assertTrue();
			}
			else {
				fail();
			}
		}
		for(int i = 0; i < d1.getVague3().length; i++) {
			if(d1.getVague3()[i] instanceof Ennemi) {
				assertTrue();
			}
			else {
				fail();
			}
		}
	public void testDeuxiemeDonjon() {
		assertEqualsNotNull(d2);
		assertEquals(2, getVague1().length);
		assertEquals(3, getVague2().length);
		assertEquals(1, getBoss().length);
		for(int i = 0; i < d2.getVague1().length; i++) {
			if(d2.getVague1()[i] instanceof Ennemi) {
				assertTrue();
			}
			else {
				fail();
			}
		}
		for(int i = 0; i < d2.getVague2().length; i++) {
			if(d2.getVague2()[i] instanceof Ennemi) {
				assertTrue();
			}
			else {
				fail();
			}
		}
		for(int i = 0; i < d2.getBoss().length; i++) {
			if(d2.getBoss()[i] instanceof Ennemi) {
				assertTrue();
			}
			else {
				fail();
			}
		}
	}

}
