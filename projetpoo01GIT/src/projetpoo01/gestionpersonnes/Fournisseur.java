package projetpoo01.gestionpersonnes;

import java.util.List;

import projetpoo01.exceptions.ErreurSaisie;
import projetpoo01.gestionachats.Achat;
import projetpoo01.gestionachats.Commande;

public class Fournisseur extends Personne implements IClient,IFournisseur {
	private String numFournisseur;

	public Fournisseur(String nom, String prenom, String adresse, String ville, String codepostal, String numfournisseur, boolean nclient) {
		super(nom, prenom, adresse, ville, codepostal);
		this.numFournisseur = numfournisseur;
		client = nclient;
	}
	

	public String getNumFournisseur() {
		return numFournisseur;
	}


	public void setNumFournisseur(String numFournisseur) {
		this.numFournisseur = numFournisseur;
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
		return client;
	}


	@Override
	public boolean estFournisseur() {
		return true;
	}
	
	public static void verifNumFour(List<String> numclientList, List<Personne> lp, String numclient)  throws ErreurSaisie {
		if (!lp.isEmpty()) {
			for (Personne p:lp) {
				if (p instanceof IFournisseur) {
					Fournisseur c = (Fournisseur) p;
					if (!numclientList.contains(numclient))
						numclientList.add(c.getNumFournisseur());
				}
			}
			
			if (numclientList.contains(numclient)) {
				throw new ErreurSaisie("Ce numéro existe déjà ! Réinsérez :");
			}
		}
	}

}
