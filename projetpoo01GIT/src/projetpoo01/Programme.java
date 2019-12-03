package projetpoo01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import projetpoo01.exceptions.ErreurSaisie;
import projetpoo01.gestionachats.Achat;
import projetpoo01.gestionachats.Commande;
import projetpoo01.gestionpersonnes.Client;
import projetpoo01.gestionpersonnes.Fournisseur;
import projetpoo01.gestionpersonnes.IClient;
import projetpoo01.gestionpersonnes.Patron;
import projetpoo01.gestionpersonnes.Personne;
import projetpoo01.gestionpersonnes.Salarie;

public class Programme {
	static List<Personne> lp = new ArrayList<Personne>();
	static Scanner sc = new Scanner(System.in);
	static Patron patron;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("lpers.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			lp = (ArrayList<Personne>)ois.readObject();
			ois.close();
		} catch (IOException e) {
			System.out.println("Création d'un fichier de sauvegarde...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Programme.menuPrincipal();
		sc.close();
		
		try {
			FileOutputStream fos = new FileOutputStream("lpers.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(lp);
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
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
				Programme.menuSaisie();
				break;
			
			case "2":
				Programme.menuAfficher();
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
				Programme.saisirSalaries();
				break;
				
			case "2":
				Programme.saisirClients();
				break;
				
			case "3":
				Programme.saisirFournisseurs();
				break;
				
			case "4":
				Programme.saisirPatron();
				break;
				
			case "":
				Programme.menuPrincipal();
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
				Programme.choisirClient();
				break;
				
			case "2":
				Programme.choisirFourn();
				break;
				
			case "3":
				Programme.afficherPersonnes(lp);
				break;
				
			case "":
				Programme.menuPrincipal();
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
			Programme.afficherClients();
			System.out.println("Appuyez sur Entrée pour revenir en arrière.");
			action = sc.nextLine();
			if (action.equals("")) {
				Programme.menuAfficher();
			}
			
			for (Personne p:lp) {
				if (p.estClient()) {
					Client c = (Client) p;
					if (c.getNumClient().equals(action)) {
						Programme.saisirAchatsClient(c);
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
			Programme.afficherFourn();
			System.out.println("Appuyez sur Entrée pour revenir en arrière :");
			action = sc.nextLine();
			if (action.equals("")) {
				Programme.menuAfficher();
			}
			
			for (Personne p:lp) {
				if (p.estFournisseur()) {
					Fournisseur f = (Fournisseur) p;
					if (f.getNumFournisseur().equals(action)) {
						Programme.saisirCommandesFournisseur(f);
					}
				}
			}
		} while (!action.equals(""));
	}

	private static void saisirAchatsClient(Client c) {
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
					nDate = Programme.verifDate(date);
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
	
	private static void saisirCommandesFournisseur(Fournisseur f) {
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
					nDate = Programme.verifDate(date);
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

	public static void gererclient(IClient client) {
		client.acheter(null);
		client.payer();
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
					nclient = Programme.verifReponse(reponse);
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
					nfournisseur = Programme.verifReponse(reponse);
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
					nclient = Programme.verifReponse(reponse);
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
				nclient = Programme.verifReponse(reponse);
				erreursaisie = false;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		lp.remove(patron);
		patron = new Patron(nom, prenom, adresse, ville, codepostal, secu, salaire, nclient);
		lp.add(patron);
	}
	
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
	
	private static boolean verifReponse(String reponse) throws ErreurSaisie {
		if (reponse.equals("oui")) {
			return true;
		}
		else if (reponse.equals("non")){
			return false;
		}
		else {
			throw new ErreurSaisie("Répondre uniquement par oui ou non !");
		}
	}
	

	private static Date verifDate(String date) throws ErreurSaisie {
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("dd/MM/yyyy");
		format.setLenient(false);
		try {
			Date nDate = format.parse(date);
			return nDate;
		} catch (Exception e) {
			throw new ErreurSaisie("Mauvais format de date ! Réinsérez :");
		}
	}
}
