package test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import projetpoo01.Programme;
import projetpoo01.exceptions.ErreurSaisie;

public class TestControles {

	@Test
	public void testVerifReponse() {
		try {
			assertTrue(Programme.verifReponse("oui"));
			assertFalse(Programme.verifReponse("non"));
			Programme.verifReponse("");
		} catch (ErreurSaisie e) {
			assertThat(e.getMessage(), is("Répondre uniquement par oui ou non !"));
		}
		
	}

	@Test
	public void testVerifDate() {
		try {
			assertTrue((Programme.verifDate("10/12/2019") instanceof Date));
			Programme.verifDate("10-12-2019");
			Programme.verifDate("");
			
		} catch (ErreurSaisie e) {
			assertThat(e.getMessage(), is("Mauvais format de date ! Réinsérez :"));
		}
		
	}

}
