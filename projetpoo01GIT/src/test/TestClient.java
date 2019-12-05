package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import projetpoo01.exceptions.ErreurSaisie;
import projetpoo01.gestionpersonnes.Client;
import projetpoo01.gestionpersonnes.Personne;

public class TestClient {
	private Client oc;
	private final String onumclient = "1";
	List<String> lnumclient = new ArrayList<String>();
	List<Personne> lp = new ArrayList<Personne>();
	
	private final String setnumclient = "";
	
	@Before
	public void init() {
		oc = new Client("", "", "", "", "", onumclient, false);
		lnumclient.add("1");
		lnumclient.add("2");
		lp.add(new Client("", "", "", "", "", "1", false));
		lp.add(new Client("", "", "", "", "", "2", false));
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
	
	@Test
	public void testVerifNumClient() {
		try {
			Client.verifNumClient(lnumclient, lp, "3");
			Client.verifNumClient(lnumclient, lp, "1");
		} catch (ErreurSaisie e) {
			assertThat(e.getMessage(), is("Ce numéro existe déjà ! Réinsérez :"));
		}
	}

}
