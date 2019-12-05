package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import projetpoo01.exceptions.ErreurSaisie;
import projetpoo01.saisies.ControleSaisie;

public class TestControles {

	@Test
	public void testVerifReponse() {
		try {
			assertTrue(ControleSaisie.verifReponse("oui"));
			assertFalse(ControleSaisie.verifReponse("non"));
			ControleSaisie.verifReponse("");
		} catch (ErreurSaisie e) {
			assertThat(e.getMessage(), is("Répondre uniquement par oui ou non !"));
		}
		
	}

	@Test
	public void testVerifDate() {
		try {
			assertTrue((ControleSaisie.verifDate("10/12/2019") instanceof Date));
			ControleSaisie.verifDate("10-12-2019");
			ControleSaisie.verifDate("");
			
		} catch (ErreurSaisie e) {
			assertThat(e.getMessage(), is("Mauvais format de date ! Réinsérez :"));
		}
		
	}

}
