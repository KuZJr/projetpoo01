package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import projetpoo01.gestionachats.Achat;
import projetpoo01.gestionachats.Commande;
import projetpoo01.gestionpersonnes.Personne;

public class TestPersonne {
	private Personne op;
	private final String onom = "Galland";
	private final String oprenom = "Maxence";
	private final String oadresse = "Rue";
	private final String oville = "AM";
	private final String ocodepostal = "30220";
	private final List<Achat> oachats = new ArrayList<Achat>();
	private final List<Commande> ocommandes = new ArrayList<Commande>();
	
	private final String setnom = "";
	private final String setprenom = "";
	private final String setadresse = "";
	private final String setville = "";
	private final String setcodepostal = "";
	private final List<Achat> setachats = new ArrayList<Achat>();
	private final List<Commande> setcommandes = new ArrayList<Commande>();
	
	@Before
	public void init() {
		op = new Personne(onom, oprenom, oadresse, oville, ocodepostal);
		oachats.add(new Achat(new Date(), "Chaise", "1"));
		ocommandes.add(new Commande(new Date(), "Table", "3"));
		op.setAchats(oachats);
		op.setCommandes(ocommandes);
	}

	@Test
	public void testPersonne() {
		assertNotNull(op);
	}

	@Test
	public void testGetNom() {
		assertEquals(onom, op.getNom());
		this.testSetNom();
	}

	@Test
	public void testSetNom() {
		op.setNom(setnom);
		assertEquals(setnom, op.getNom());
	}

	@Test
	public void testGetPrenom() {
		assertEquals(oprenom, op.getPrenom());
		this.testSetPrenom();
	}

	@Test
	public void testSetPrenom() {
		op.setPrenom(setprenom);
		assertEquals(setprenom, op.getPrenom());
	}

	@Test
	public void testGetAdresse() {
		assertEquals(oadresse, op.getAdresse());
		this.testSetAdresse();
	}

	@Test
	public void testSetAdresse() {
		op.setAdresse(setadresse);
		assertEquals(setadresse, op.getAdresse());
	}

	@Test
	public void testGetVille() {
		assertEquals(oville, op.getVille());
		this.testSetVille();
	}

	@Test
	public void testSetVille() {
		op.setVille(setville);
		assertEquals(setville, op.getVille());
	}

	@Test
	public void testGetCodepostal() {
		assertEquals(ocodepostal, op.getCodepostal());
		this.testSetCodepostal();
	}

	@Test
	public void testSetCodepostal() {
		op.setCodepostal(setcodepostal);
		assertEquals(setcodepostal, op.getCodepostal());
	}

	@Test
	public void testGetAchats() {
		assertEquals(oachats, op.getAchats());
		this.testSetAchats();
	}

	@Test
	public void testSetAchats() {
		op.setAchats(setachats);
		assertEquals(setachats, op.getAchats());
	}

	@Test
	public void testGetCommandes() {
		assertEquals(ocommandes, op.getCommandes());
		this.testSetCommandes();
	}

	@Test
	public void testSetCommandes() {
		op.setCommandes(setcommandes);
		assertEquals(setcommandes, op.getCommandes());
	}

}
