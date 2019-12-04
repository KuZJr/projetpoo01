package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import projetpoo01.gestionpersonnes.Fournisseur;

public class TestFournisseur {
	private Fournisseur of;
	private final String onumfourn = "1";
	
	private final String setnumfourn = "";
	
	@Before
	public void init() {
		of = new Fournisseur("", "", "", "", "", onumfourn, false);
	}

	@Test
	public void testFournisseur() {
		assertNotNull(of);
	}

	@Test
	public void testGetNumFournisseur() {
		assertEquals(onumfourn, of.getNumFournisseur());
		this.testSetNumFournisseur();
	}

	@Test
	public void testSetNumFournisseur() {
		of.setNumFournisseur(setnumfourn);
		assertEquals(setnumfourn, of.getNumFournisseur());
	}

}
