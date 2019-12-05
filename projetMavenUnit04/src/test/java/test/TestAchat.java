package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import projetpoo01.gestionachats.Achat;

public class TestAchat {
	private Achat oa;
	private final Date odate = new Date();
	private final String ointitule = "Chaise";
	private final String oquantite = "3";
	
	private final Date setdate = new Date(1515115151);
	private final String setintitule = "";
	private final String setquantite = "";
	
	@Before
	public void init() {
		oa = new Achat(odate, ointitule, oquantite);
	}

	@Test
	public void testAchat() {
		assertNotNull(oa);
	}

	@Test
	public void testGetDate() {
		assertEquals(odate, oa.getDate());
		this.testSetDate();
	}

	@Test
	public void testSetDate() {
		oa.setDate(setdate);
		assertEquals(setdate, oa.getDate());
	}

	@Test
	public void testGetIntitule() {
		assertEquals(ointitule, oa.getIntitule());
		this.testSetIntitule();
	}

	@Test
	public void testSetIntitule() {
		oa.setIntitule(setintitule);
		assertEquals(setintitule, oa.getIntitule());
	}

	@Test
	public void testGetQuantite() {
		assertEquals(oquantite, oa.getQuantite());
		this.testSetQuantite();
	}

	@Test
	public void testSetQuantite() {
		oa.setQuantite(setquantite);
		assertEquals(setquantite, oa.getQuantite());
	}

}
