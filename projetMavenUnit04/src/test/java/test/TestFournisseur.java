package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import projetpoo01.exceptions.ErreurSaisie;
import projetpoo01.gestionpersonnes.Client;
import projetpoo01.gestionpersonnes.Fournisseur;
import projetpoo01.gestionpersonnes.Personne;

public class TestFournisseur {
	private Fournisseur of;
	private final String onumfourn = "1";
	List<String> lnumfour = new ArrayList<String>();
	List<Personne> lp = new ArrayList<Personne>();
	
	private final String setnumfourn = "";
	
	@Before
	public void init() {
		of = new Fournisseur("", "", "", "", "", onumfourn, false);
		lnumfour.add("1");
		lnumfour.add("2");
		lp.add(new Client("", "", "", "", "", "1", false));
		lp.add(new Client("", "", "", "", "", "2", false));
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
	
	@Test
	public void testVerifNumFour() {
		try {
			Fournisseur.verifNumFour(lnumfour, lp, "3");
			Fournisseur.verifNumFour(lnumfour, lp, "1");
		} catch (ErreurSaisie e) {
			assertThat(e.getMessage(), is("Ce numéro existe déjà ! Réinsérez :"));
		}
	}

}
