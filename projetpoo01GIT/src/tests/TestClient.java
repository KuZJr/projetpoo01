package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import projetpoo01.gestionpersonnes.Client;

public class TestClient {
	private Client oc;
	private final String onumclient = "1";
	
	private final String setnumclient = "";
	
	@Before
	public void init() {
		oc = new Client("", "", "", "", "", onumclient, false);
	}

	@Test
	public void testClient() {
		assertNotNull(oc);
	}

	@Test
	public void testGetNumClient() {
		assertEquals(onumclient, oc.getNumClient());
		this.testSetNumClient();
	}

	@Test
	public void testSetNumClient() {
		oc.setNumClient(setnumclient);
		assertEquals(setnumclient, oc.getNumClient());
	}

}
