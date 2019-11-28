package projetpoo01.gestionpersonnes;

import java.util.List;

import projetpoo01.gestionachats.Achat;
import projetpoo01.gestionachats.Commande;

public class Fournisseur extends Personne implements IClient,IFournisseur {
	private String numFournisseur;
	private boolean client;
	private boolean fournisseur;

	public Fournisseur(String nom, String prenom, String adresse, String ville, String codepostal, String numfournisseur) {
		super(nom, prenom, adresse, ville, codepostal);
		this.numFournisseur = numfournisseur;
	}
	

	public String getNumFournisseur() {
		return numFournisseur;
	}


	public void setNumFournisseur(String numFournisseur) {
		this.numFournisseur = numFournisseur;
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
	public void acheter(List<Achat> a) {
		System.out.println("Fournisseur achète");
	}

	@Override
	public boolean payer() {
		return false;
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
	public String toString() {
		return super.toString()+"[numFournisseur="+this.numFournisseur+"]";
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
