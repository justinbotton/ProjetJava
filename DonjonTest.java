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
	Donjon d3;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		d1 = new Donjon(7);
		d2 = new Donjon(16);
		d3 = new Donjon("samourai", 10)
	}

	@Test
	public void testPremierDonjon() {
		assertEqualsNotNull(d1);
		assertEquals(2, getVague1().length);
		assertEquals(3, getVague2().length);
		assertEquals(5, getVague3().length);
		Ennemi e = d1.getVague1[0];
		switch(selectEnnemi) {
			case "gobelin" : 
				assertEquals(3, e.getNiveau());
				assertEquals(13, e.getEndurance());
				assertEquals(26, e.getVie());
				break;
			case "troll" : 
				assertEquals(2, sommeNiveau);
				break;
			case "groupe gobelin" : 
				assertEquals(3, sommeNiveau);
				break;
			case "magicien noir" : 
				assertEquals(4, sommeNiveau);
				break;
			default : 
				new Ennemi(1, sommeNiveau);
				break;
		}
	public void testDeuxiemeDonjon() {
		assertEqualsNotNull(d2);
		assertEquals(2, getVague1().length);
		assertEquals(3, getVague2().length);
		assertEquals(5, getVague3().length);
	}
	public void testTroisiemeDonjon() {
		assertEqualsNotNull(d3);
		assertEquals(2, getVague1().length);
		assertEquals(3, getVague2().length);
		assertEquals(1, getBoss().length);
	}

}
