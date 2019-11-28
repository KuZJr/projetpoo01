package projetpoo01.gestionpersonnes;

import java.util.List;

import projetpoo01.gestionachats.Achat;
import projetpoo01.gestionachats.Commande;

public class Client extends Personne implements IFournisseur, IClient {
	private String numClient;
	private boolean client;
	private boolean fournisseur;

	public Client(String nom, String prenom, String adresse, String ville, String codepostal, String numclient) {
		super(nom, prenom, adresse, ville, codepostal);
		this.numClient = numclient;
	}
		

	public String getNumClient() {
		return numClient;
	}


	public void setNumClient(String numClient) {
		this.numClient = numClient;
	}

	public boolean isClient() {
		return client;
	}


	public void setClient(boolean client) {
		this.client = client;
	}
	

	public boolean isFournisseur() {
		return fournisseur;
	}


	public void setFournisseur(boolean fournisseur) {
		this.fournisseur = fournisseur;
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
		// TODO Auto-generated method stub
		System.out.println("Client achète");
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
		return isClient();
	}


	@Override
	public boolean estFournisseur() {
		// TODO Auto-generated method stub
		return isFournisseur();
	}
}
