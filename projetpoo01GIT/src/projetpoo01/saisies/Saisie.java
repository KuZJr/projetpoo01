package projetpoo01.saisies;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import projetpoo01.exceptions.ErreurSaisie;
import projetpoo01.gestionachats.Achat;
import projetpoo01.gestionachats.Commande;
import projetpoo01.gestionpersonnes.Client;
import projetpoo01.gestionpersonnes.Fournisseur;
import projetpoo01.gestionpersonnes.Patron;
import projetpoo01.gestionpersonnes.Personne;
import projetpoo01.gestionpersonnes.Salarie;

public class Saisie {
	public static List<Personne> lp = null;
	public static Scanner sc = null;
	public static Patron patron = null;
	
	public static void saisirAchatsClient(Client c) {
		System.out.println("-------------------------------------------------");
		System.out.println("Combien d'achats voulez-vous saisir ?");
		int nbAchats = 0;
		boolean erreursaisie = true;
		while (erreursaisie) {
			try {
				nbAchats = sc.nextInt(); sc.nextLine();
				erreursaisie = false;
			} catch (Exception e) {
				System.out.println("Entrez uniquement un nombre !");
			}
		}
		List<Achat> achats = new ArrayList<Achat>();
		erreursaisie = true;
		for (int i=0;i<nbAchats;i++) {
			System.out.println("Date d'achat (dd-MM-yyyy) :");
			String date = null;
			Date nDate = null;
			while (erreursaisie) {
				date = sc.nextLine();
				try {
					nDate = ControleSaisie.verifDate(date);
					erreursaisie = false;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			System.out.println("Intitulé :");
			String intitule = sc.nextLine();
			System.out.println("Quantité :");
			String quantite = sc.nextLine();
			
			Achat achat = new Achat(nDate, intitule, quantite);
			achats.add(achat);
		}
		c.acheter(achats);
		c.setAchats(achats);
	}
	
	public static void saisirCommandesFournisseur(Fournisseur f) {
		System.out.println("-------------------------------------------------");
		System.out.println("Combien de commandes voulez-vous saisir ?");
		int nbCommandes = 0;
		boolean erreursaisie = true;
		while (erreursaisie) {
			try {
				nbCommandes = sc.nextInt(); sc.nextLine();
				erreursaisie = false;
			} catch (Exception e) {
				System.out.println("Entrez uniquement un nombre !");
			}
		}
		List<Commande> commandes = new ArrayList<Commande>();
		erreursaisie = true;
		for (int i=0;i<nbCommandes;i++) {
			System.out.println("Date de commande (dd-MM-yyyy) :");
			String date = null;
			Date nDate = null;
			while (erreursaisie) {
				date = sc.nextLine();
				try {
					nDate = ControleSaisie.verifDate(date);
					erreursaisie = true;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			
			System.out.println("Intitulé :");
			String intitule = sc.nextLine();
			System.out.println("Quantité :");
			String quantite = sc.nextLine();
			
			Commande commande = new Commande(nDate, intitule, quantite);
			commandes.add(commande);
		}
		f.commander(commandes);
		f.setCommandes(commandes);
	}
	
	public static void saisirSalaries() {
		System.out.println("-------------------------------------------------");
		System.out.println("Combien de salariés voulez-vous saisir ?");
		int nbSalaries = 0;
		boolean erreursaisie = true;
		while (erreursaisie) {
			try {
				nbSalaries = sc.nextInt(); sc.nextLine();
				erreursaisie = false;
			} catch (Exception e) {
				System.out.println("Entrez uniquement un nombre !");
			}
		}
		
		for (int i=0;i<nbSalaries;i++) {
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
			erreursaisie = true;
			String secu = null;
			while (erreursaisie) {
				try {
					secu = sc.nextLine();
					Salarie.verifNumSecu(secu);
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
					Salarie.verifSalaire(salaire);
					erreursaisie = false;
				} catch (ErreurSaisie e) {
					System.out.println(e.getMessage());
				}
			}
			System.out.println("Le salarié est-il aussi client ? Répondre par oui ou non : ");
			String reponse;
			boolean nclient = false;
			erreursaisie = true;
			while (erreursaisie) {
				try {
					reponse = sc.nextLine();
					nclient = ControleSaisie.verifReponse(reponse);
					erreursaisie = false;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			Salarie salarie = new Salarie(nom, prenom, adresse, ville, codepostal, secu, salaire, nclient);
			lp.add(salarie);
		}
	}
	
	public static void saisirClients() {
		System.out.println("-------------------------------------------------");
		System.out.println("Combien de clients voulez-vous saisir ?");
		int nbClients = 0;
		boolean erreursaisie = true;
		while (erreursaisie) {
			try {
				nbClients = sc.nextInt(); sc.nextLine();
				erreursaisie = false;
			} catch (Exception e) {
				System.out.println("Entrez uniquement un nombre !");
			}
		}
		
		for (int i=0;i<nbClients;i++) {
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
			erreursaisie = true;
			while (erreursaisie) {
				try {
					numclient = sc.nextLine();
					Client.verifNumClient(numclientList, lp, numclient);
					erreursaisie = false;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			System.out.println("Le client est-il aussi fournisseur ? Répondre par oui ou non : ");
			String reponse;
			boolean nfournisseur = false;
			erreursaisie = true;
			while (erreursaisie) {
				try {
					reponse = sc.nextLine();
					nfournisseur = ControleSaisie.verifReponse(reponse);
					erreursaisie = false;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			Client client = new Client(nom, prenom, adresse, ville, codepostal, numclient, nfournisseur);
			lp.add(client);
		}
	}

	public static void saisirFournisseurs() {
		System.out.println("-------------------------------------------------");
		System.out.println("Combien de fournisseurs voulez-vous saisir ?");
		int nbFourn = 0;
		boolean erreursaisie = true;
		while (erreursaisie) {
			try {
				nbFourn = sc.nextInt(); sc.nextLine();
				erreursaisie = false;
			} catch (Exception e) {
				System.out.println("Entrez uniquement un nombre !");
			}
		}
		
		for (int i=0;i<nbFourn;i++) {
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
			erreursaisie = true;
			while (erreursaisie) {
				try {
					numclient = sc.nextLine();
					Fournisseur.verifNumFour(numclientList, lp, numclient);
					erreursaisie = false;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			System.out.println("Le fournisseur est-il aussi client ? Répondre par oui ou non : ");
			String reponse;
			boolean nclient = false;
			erreursaisie = true;
			while (erreursaisie) {
				try {
					reponse = sc.nextLine();
					nclient = ControleSaisie.verifReponse(reponse);
					erreursaisie = false;
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			Fournisseur fournisseur = new Fournisseur(nom, prenom, adresse, ville, codepostal, numclient, nclient);
			lp.add(fournisseur);
		}
	}
	
	public static void saisirPatron() {
		System.out.println("-------------------------------------------------");
		System.out.println("/!\\ ATTENTION : Si vous avez déjà saisi un patron, celui-ci sera écrasé ! /!\\");
		System.out.println("Saisir un patron : ");
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
				Salarie.verifNumSecu(secu);
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
				Salarie.verifSalaire(salaire);
				erreursaisie = false;
			} catch (ErreurSaisie e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("Le patron est-il aussi client ? Répondre par oui ou non : ");
		String reponse;
		boolean nclient = false;
		erreursaisie = true;
		while (erreursaisie) {
			try {
				reponse = sc.nextLine();
				nclient = ControleSaisie.verifReponse(reponse);
				erreursaisie = false;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		lp.remove(patron);
		patron = new Patron(nom, prenom, adresse, ville, codepostal, secu, salaire, nclient);
		lp.add(patron);
	}

}
