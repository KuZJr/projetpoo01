package projetpoo01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import projetpoo01.gestionpersonnes.IClient;
import projetpoo01.gestionpersonnes.Personne;
import projetpoo01.gestionpersonnes.Salarie;
import projetpoo01.exceptions.ErreurSaisie;
import projetpoo01.gestionpersonnes.Client;
import projetpoo01.gestionpersonnes.Fournisseur;

public class Programme {
	static List<Personne> lp = new ArrayList<Personne>();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {		
		Programme.saisirSalaries();
		Programme.saisirClients();
		Programme.saisirFournisseur();
		Programme.afficherPersonnes(lp);
		sc.close();
	}
	
	public static void gererclient(IClient client) {
		client.acheter(null);
		client.payer();
	}
	
	public static void saisirSalaries() {
		System.out.println("-------------------------------------------------");
		System.out.println("Saisir 5 salariés");
		for (int i=0;i<1;i++) {
			System.out.println("Salarié n°"+(i+1));
			System.out.println("Nom :");
			String nom = sc.nextLine();
			System.out.println("Prénom :");
			String prenom = sc.nextLine();
			System.out.println("Adresse :");
			String adresse = sc.nextLine();
			System.out.println("Ville :");
			String ville = sc.nextLine();
			System.out.println("Code postal :");
			String codepostal = sc.nextLine();
			System.out.println("Numéro de Sécurité Sociale (13 chiffres) :");
			boolean erreursaisie = true;
			String secu = null;
			while (erreursaisie) {
				try {
					secu = sc.nextLine();
					if (!secu.matches("\\d{13}")) {
						throw new ErreurSaisie("Mauvais format ! Réinsérez : ");
					}
					erreursaisie = false;
				} catch (ErreurSaisie e) {
					System.out.println(e.getMessage());
				}
			}			
			System.out.println("Salaire (au format 'XXXX.XX€') :");
			erreursaisie = true;
			String salaire = null;
			while (erreursaisie) {
				try {
					salaire = sc.nextLine();
					if (!salaire.matches("\\d{1,9}+\\.\\d{2}€")) {
						throw new ErreurSaisie("Mauvais format ! Réinsérez : ");
					}
					erreursaisie = false;
				} catch (ErreurSaisie e) {
					System.out.println(e.getMessage());
				}
			}
			Personne personne = new Salarie(nom, prenom, adresse, ville, codepostal, secu, salaire);
			lp.add(personne);
		}
	}
	
	public static void afficherPersonnes(List<Personne> lp) {
		for (Personne p:lp) {
			System.out.println(p.toString());
		}
	}
	
	public static void saisirClients() {
		System.out.println("-------------------------------------------------");
		System.out.println("Saisir 4 clients");
		for (int i=0;i<2;i++) {
			System.out.println("Client n°"+(i+1));
			System.out.println("Nom :");
			String nom = sc.nextLine();
			System.out.println("Prénom :");
			String prenom = sc.nextLine();
			System.out.println("Adresse :");
			String adresse = sc.nextLine();
			System.out.println("Ville :");
			String ville = sc.nextLine();
			System.out.println("Code postal :");
			String codepostal = sc.nextLine();
			System.out.println("Numéro client (doit être unique) :");
			String numclient = null;
			List<String> numclientList = new ArrayList<String>();
			boolean erreursaisie = true;
			while (erreursaisie) {
				try {
					numclient = sc.nextLine();
					if (!lp.isEmpty()) {
						for (Personne p:lp) {
							if ((p.getClass().getSimpleName()).equals("Client")) {
								Client c = (Client) p;
								if (!numclientList.contains(numclient))
									numclientList.add(c.getNumClient());
							}
						}
						
						if (numclientList.contains(numclient)) {
							throw new ErreurSaisie("Ce numéro existe déjà ! Réinsérez :");
						}
					}
					erreursaisie = false;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			Personne personne = new Client(nom, prenom, adresse, ville, codepostal, numclient);
			lp.add(personne);
		}
	}
	
	public static void saisirFournisseur() {
		System.out.println("-------------------------------------------------");
		System.out.println("Saisir 3 fournisseurs");
		for (int i=0;i<2;i++) {
			System.out.println("Fournisseur n°"+(i+1));
			System.out.println("Nom :");
			String nom = sc.nextLine();
			System.out.println("Prénom :");
			String prenom = sc.nextLine();
			System.out.println("Adresse :");
			String adresse = sc.nextLine();
			System.out.println("Ville :");
			String ville = sc.nextLine();
			System.out.println("Code postal :");
			String codepostal = sc.nextLine();
			System.out.println("Numéro fournisseur (doit être unique) :");
			String numclient = null;
			List<String> numclientList = new ArrayList<String>();
			boolean erreursaisie = true;
			while (erreursaisie) {
				try {
					numclient = sc.nextLine();
					if (!lp.isEmpty()) {
						for (Personne p:lp) {
							if ((p.getClass().getSimpleName()).equals("Fournisseur")) {
								Fournisseur c = (Fournisseur) p;
								if (!numclientList.contains(numclient))
									numclientList.add(c.getNumFournisseur());
							}
						}
						
						if (numclientList.contains(numclient)) {
							throw new ErreurSaisie("Ce numéro existe déjà ! Réinsérez :");
						}
					}
					erreursaisie = false;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			
			Personne personne = new Fournisseur(nom, prenom, adresse, ville, codepostal, numclient);
			lp.add(personne);
		}
	}
}
