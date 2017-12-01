package info;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArmeTest {

	Arme a1;
	Arme a2;
	Arme a3;
	Arme a4;
	Arme a5;
	
	/**
	 * Assignation des variables
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		a1 = new Arme();
		a2 = new Arme("katana", 5);
		a3 = new Arme("arc", 3);
		a4 = new Arme("hachette", 3);
		a5 = new Arme("masse", 3);
	}

	/**
	 * Test Getter
	 */
	@Test
	public void testGetter() {
		
		//getNom()
		assertEquals(a1.getNom(), "epee");
		assertEquals(a2.getNom(), "katana");
		assertEquals(a3.getNom(), "arc");
		assertEquals(a4.getNom(), "hachette");
		assertEquals(a5.getNom(), "masse");
		
		//getDegat()
		assertEquals(a1.getDegat(), 3);
		assertEquals(a2.getDegat(), 5);
		assertEquals(a3.getDegat(), 3);
		assertEquals(a4.getDegat(), 3);
		assertEquals(a5.getDegat(), 3);
	}
	
	/**
	 * Test Setter
	 */
	@Test
	public void testSetter() {
		
		//setNom();
		a1.setNom("katana");
		assertEquals(a1.getNom(), "katana");
		a2.setNom("masse");
		assertEquals(a2.getNom(), "masse");
		a3.setNom("hachette");
		assertEquals(a3.getNom(), "hachette");
		a4.setNom("arc");
		assertEquals(a4.getNom(), "arc");
		a5.setNom("epee");
		assertEquals(a5.getNom(), "epee");
		
		//setDegat()
		a1.setDegat(4);
		assertEquals(a1.getDegat(), 4);
		a2.setDegat(8);
		assertEquals(a2.getDegat(), 8);
		a3.setDegat(10);
		assertEquals(a3.getDegat(), 10);
		a4.setDegat(40);
		assertEquals(a4.getDegat(), 40);
		a5.setDegat(1);
		assertEquals(a5.getDegat(), 1);
	}
}
