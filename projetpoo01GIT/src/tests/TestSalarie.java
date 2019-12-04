package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import projetpoo01.gestionpersonnes.Salarie;

public class TestSalarie {
	private Salarie os;
	private final String onumsecu = "01234567890123";
	private final String osalaire = "1234.56€";
	private final boolean oclient = true;
	
	private final String setnumsecu = "";
	private final String setsalaire = "";
	private final boolean setclient = false;
	
	@Before
	public void init() {
		os = new Salarie("", "", "", "", "", onumsecu, osalaire, oclient);
	}

	@Test
	public void testSalarie() {
		assertNotNull(os);
	}

	@Test
	public void testGetNumSecu() {
		assertEquals(onumsecu, os.getNumSecu());
		this.testSetNumSecu();
	}

	@Test
	public void testSetNumSecu() {
		os.setNumSecu(setnumsecu);
		assertEquals(setnumsecu, os.getNumSecu());
	}

	@Test
	public void testGetSalaire() {
		assertEquals(osalaire, os.getSalaire());
		this.testSetSalaire();
	}
	
	@Test
	public void testSetSalaire() {
		os.setSalaire(setsalaire);
		assertEquals(setsalaire, os.getSalaire());
	}

	@Test
	public void testIsClient() {
		assertEquals(oclient, os.isClient());
		this.testSetClient();
	}
	
	@Test
	public void testSetClient() {
		os.setClient(setclient);
		assertEquals(setclient, os.isClient());
	}

}
