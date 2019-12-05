package projetpoo01.affichages;

import java.util.List;

import projetpoo01.gestionpersonnes.Personne;

public class Affichage {
	public static List<Personne> lp = null;
	
	public static void afficherPersonnes(List<Personne> lp) {
		for (Personne p:lp) {
			System.out.println(p.toString());
		}
	}

	public static void afficherClients() {
		for (Personne p:lp) {
			if (p.estClient())
				System.out.println(p.toString());
		}
	}
	
	public static void afficherFourn() {
		for (Personne p:lp) {
			if (p.estFournisseur())
				System.out.println(p.toString());
		}
	}
}
