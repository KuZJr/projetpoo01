package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import projetpoo01.gestionachats.Commande;

public class TestCommande {
	private Commande oc;
	private final Date odate = new Date();
	private final String ointitule = "Chaise";
	private final String oquantite = "3";
	
	private final Date setdate = new Date(1515115151);
	private final String setintitule = "";
	private final String setquantite = "";
	
	@Before
	public void init() {
		oc = new Commande(odate, ointitule, oquantite);
	}

	@Test
	public void testAchat() {
		assertNotNull(oc);
	}

	@Test
	public void testGetDate() {
		assertEquals(odate, oc.getDate());
		this.testSetDate();
	}

	@Test
	public void testSetDate() {
		oc.setDate(setdate);
		assertEquals(setdate, oc.getDate());
	}

	@Test
	public void testGetIntitule() {
		assertEquals(ointitule, oc.getIntitule());
		this.testSetIntitule();
	}

	@Test
	public void testSetIntitule() {
		oc.setIntitule(setintitule);
		assertEquals(setintitule, oc.getIntitule());
	}

	@Test
	public void testGetQuantite() {
		assertEquals(oquantite, oc.getQuantite());
		this.testSetQuantite();
	}

	@Test
	public void testSetQuantite() {
		oc.setQuantite(setquantite);
		assertEquals(setquantite, oc.getQuantite());
	}

}
