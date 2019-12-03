package projetpoo01.gestionpersonnes;

import java.util.List;

import projetpoo01.exceptions.ErreurSaisie;
import projetpoo01.gestionachats.Achat;
import projetpoo01.gestionachats.Commande;

public class Client extends Personne implements IFournisseur, IClient {
	private static final long serialVersionUID = 1L;
	private String numClient;

	public Client(String nom, String prenom, String adresse, String ville, String codepostal, String numclient, boolean nfournisseur) {
		super(nom, prenom, adresse, ville, codepostal);
		this.numClient = numclient;
		client = true;
		fournisseur = nfournisseur;
	}
		

	public String getNumClient() {
		return numClient;
	}


	public void setNumClient(String numClient) {
		this.numClient = numClient;
	}


	@Override
	public boolean livrer() {
		return false;

	}

	@Override
	public void commander(List<Commande> c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void acheter(List<Achat> a) {
		System.out.println("Le client achète les éléments suivants :");
		for (Achat achat:a) {
			System.out.println(achat.toString());
		}
	}

	@Override
	public boolean payer() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String toString() {
		return super.toString()+"[numClient="+this.numClient+"]";
	}

	@Override
	public boolean estClient() {
		return true;
	}
	
	@Override
	public boolean estFournisseur() {
		return fournisseur;
	}
	
	public static void verifNumClient(List<String> numclientList, List<Personne> lp, String numclient)  throws ErreurSaisie {
		if (!lp.isEmpty()) {
			for (Personne p:lp) {
				if (p instanceof IClient) {
					if (p.estClient()) {
						Client c = (Client) p;
						if (!numclientList.contains(numclient))
							numclientList.add(c.getNumClient());
					}
				}
			}
			
			if (numclientList.contains(numclient)) {
				throw new ErreurSaisie("Ce numéro existe déjà ! Réinsérez :");
			}
		}
	}
}
