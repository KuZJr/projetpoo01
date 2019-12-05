package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestClient.class, TestFournisseur.class, TestControles.class })
public class TestsClassesGestion {

}
