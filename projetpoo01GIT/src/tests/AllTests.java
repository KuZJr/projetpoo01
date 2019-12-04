package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestClient.class, TestFournisseur.class, TestPatron.class, TestPersonne.class, TestSalarie.class,
		TestsClasseMere.class, TestsClassesGestion.class, TestsClassesSalarie.class })
public class AllTests {

}
