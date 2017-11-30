package info;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

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
	 * Assignation des variables
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		p1 = new Personnage();
		a1 = new Arme("arc", 3);
		p1.setUpPersonnage("Elfe", 40, 80, 4, a1, 1);
		p2 = new Personnage();
		a2 = new Arme("hachette", 3);
		p2.setUpPersonnage("Nain", 60, 120, 3, a2, 1);
		p3 = new Personnage();
		a3 = new Arme("masse", 3);
		p3.setUpPersonnage("Orque", 80, 160, 1, a3, 1);
		p4 = new Personnage();
		a4 = new Arme("epee", 3);
		p4.setUpPersonnage("Humain", 30, 60, 5, a4, 1);
		p5 = new Personnage();
		a5 = new Arme("fourchette", 1);
		p5.setUpPersonnage("je suis un...heu...je n ai pas choisi !!", 30, 60, 5, a5, 1);
	}

	/**
	 * Test getter
	 */
	@Test
	public void testGetter() {
		assertEquals(p1.getNiveau(), 1);
		assertEquals(p2.getNiveau(), 1);
		assertEquals(p3.getNiveau(), 1);
		assertEquals(p4.getNiveau(), 1);
		assertEquals(p5.getNiveau(), 1);
		assertEquals(p1.getVie(), 80);
		assertEquals(p2.getVie(), 120);
		assertEquals(p3.getVie(), 160);
		assertEquals(p4.getVie(), 60);
		assertEquals(p5.getVie(), 60);
	}

}
