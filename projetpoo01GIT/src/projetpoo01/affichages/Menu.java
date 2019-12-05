package projetpoo01.affichages;

import java.util.List;
import java.util.Scanner;

import projetpoo01.gestionpersonnes.Client;
import projetpoo01.gestionpersonnes.Fournisseur;
import projetpoo01.gestionpersonnes.Personne;
import projetpoo01.saisies.Saisie;

public class Menu {
	public static List<Personne> lp = null;
	public static Scanner sc = null;
	
	public static void menuPrincipal() {
		String action = null;
		do {
			System.out.println("-------------------------------------------------");
			System.out.println("Menu principal");
			System.out.println("-------------------------------------------------");
			System.out.println("Sélectionnez une action");
			System.out.println("\t 1. Saisir des personnes");
			System.out.println("\t 2. Afficher les personnes saisies");
			System.out.println("Appuyez sur Entrée pour quitter.");
			
			do {
				action = sc.nextLine();
				if (!action.equals("1") && !action.equals("2") && !action.equals("")) {
					System.out.println("Entrez une action valide !");
				}
			} while (!action.equals("1") && !action.equals("2") && !action.equals(""));
			
			switch (action) {
			case "1":
				menuSaisie();
				break;
			
			case "2":
				menuAfficher();
				break;
	
			case "":
				return;
			}
			
		} while (!action.equals(""));
	}
	
	public static void menuSaisie() {
		String action = null;
		do {
			System.out.println("-------------------------------------------------");
			System.out.println("Menu Saisie");
			System.out.println("-------------------------------------------------");
			System.out.println("Sélectionnez une action");
			System.out.println("\t 1. Saisir des salariés");
			System.out.println("\t 2. Saisir des clients");
			System.out.println("\t 3. Saisir des fournisseurs");
			System.out.println("\t 4. Saisir un patron");
			System.out.println("Appuyez sur Entrée pour revenir en arrière.");
			
			do {
				action = sc.nextLine();
				if (!action.equals("1") && !action.equals("2") && !action.equals("3") && !action.equals("4") && !action.equals("")) {
					System.out.println("Entrez une action valide !");
				}
			} while (!action.equals("1") && !action.equals("2") && !action.equals("3") && !action.equals("4") && !action.equals(""));
			
			switch (action) {
			case "1":
				Saisie.saisirSalaries();
				break;
				
			case "2":
				Saisie.saisirClients();
				break;
				
			case "3":
				Saisie.saisirFournisseurs();
				break;
				
			case "4":
				Saisie.saisirPatron();
				break;
				
			case "":
				menuPrincipal();
				break;
			}
		} while (!action.equals(""));
	}
	
	public static void menuAfficher() {
		String action = null;
		do {
			System.out.println("-------------------------------------------------");
			System.out.println("Menu Afficher");
			System.out.println("-------------------------------------------------");
			System.out.println("Sélectionnez une action");
			System.out.println("\t 1. Choisir un client");
			System.out.println("\t 2. Choisir un fournisseur");
			System.out.println("\t 3. Afficher toutes les personnes saisies");
			System.out.println("Appuyez sur Entrée pour revenir en arrière.");
			
			do {
				action = sc.nextLine();
				if (!action.equals("1") && !action.equals("2") && !action.equals("3") && !action.equals("")) {
					System.out.println("Entrez une action valide !");
				}
			} while (!action.equals("1") && !action.equals("2") && !action.equals("3") && !action.equals(""));
			
			switch (action) {
			case "1":
				choisirClient();
				break;
				
			case "2":
				choisirFourn();
				break;
				
			case "3":
				Affichage.afficherPersonnes(lp);
				break;
				
			case "":
				menuPrincipal();
				break;
			}
		} while (!action.equals(""));
	}
	
	private static void choisirClient() {
		String action = null;
		do {
			System.out.println("-------------------------------------------------");
			System.out.println("Menu Sélection Client");
			System.out.println("-------------------------------------------------");
			System.out.println("Sélectionnez un client en saisissant son numéro client :");
			Affichage.afficherClients();
			System.out.println("Appuyez sur Entrée pour revenir en arrière.");
			action = sc.nextLine();
			if (action.equals("")) {
				menuAfficher();
			}
			
			for (Personne p:lp) {
				if (p.estClient()) {
					Client c = (Client) p;
					if (c.getNumClient().equals(action)) {
						Saisie.saisirAchatsClient(c);
					}
				}
			}
		} while (!action.equals(""));
	}
	
	private static void choisirFourn() {
		String action = null;
		do {
			System.out.println("-------------------------------------------------");
			System.out.println("Menu Sélection Fournisseur");
			System.out.println("-------------------------------------------------");
			System.out.println("Sélectionnez un fournisseur en saisissant son numéro fournisseur :");
			Affichage.afficherFourn();
			System.out.println("Appuyez sur Entrée pour revenir en arrière :");
			action = sc.nextLine();
			if (action.equals("")) {
				menuAfficher();
			}
			
			for (Personne p:lp) {
				if (p.estFournisseur()) {
					Fournisseur f = (Fournisseur) p;
					if (f.getNumFournisseur().equals(action)) {
						Saisie.saisirCommandesFournisseur(f);
					}
				}
			}
		} while (!action.equals(""));
	}
	
}
