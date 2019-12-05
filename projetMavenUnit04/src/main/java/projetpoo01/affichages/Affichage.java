/**
 * Classe comportant les méthodes d'affichage du programme.
 * 
 * @version 1.0
 * 
 * @author GALLAND Maxence
 */
package projetpoo01.affichages;

import java.util.List;

import projetpoo01.gestionpersonnes.Personne;

public class Affichage {
	public static List<Personne> lp = null;
	/**
	 * Méthode d'affichage des personnes enregistrées.
	 */
	public static void afficherPersonnes() {
		for (Personne p:lp) {
			System.out.println(p.toString());
		}
	}
	/**
	 * Méthode d'affichage des clients seulement parmi la liste des personnes enregistrées.
	 */
	public static void afficherClients() {
		for (Personne p:lp) {
			if (p.estClient())
				System.out.println(p.toString());
		}
	}
	/**
	 * Méthode d'affichage des fournisseurs seulement parmi la liste des personnes enregistrées.
	 */
	public static void afficherFourn() {
		for (Personne p:lp) {
			if (p.estFournisseur())
				System.out.println(p.toString());
		}
	}
}
