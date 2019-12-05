package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import projetpoo01.gestionpersonnes.Patron;

public class TestPatron {
	private Patron op;
	
	@Before
	public void init() {
		op = new Patron("", "", "", "", "", "", "", false);
	}

	@Test
	public void testPatron() {
		assertNotNull(op);
	}

}
