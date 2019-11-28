package projetpoo01.gestionpersonnes;

import java.util.List;

import projetpoo01.gestionachats.Achat;

public class Salarie extends Personne implements IClient {
	private String numSecu;
	private String salaire;
	private boolean client;
	
	public Salarie(String nom, String prenom, String adresse, String ville, String codepostal, String numsecu, String salaire) {
		super(nom, prenom, adresse, ville, codepostal);
		this.numSecu = numsecu;
		this.salaire = salaire;
		// TODO Auto-generated constructor stub
	}


	public String getNumSecu() {
		return numSecu;
	}


	public void setNumSecu(String numSecu) {
		this.numSecu = numSecu;
	}


	public String getSalaire() {
		return salaire;
	}

	
	public void setSalaire(String salaire) {
		this.salaire = salaire;
	}
	

	public boolean isClient() {
		return client;
	}


	public void setClient(boolean client) {
		this.client = client;
	}


	@Override
	public String toString() {
		return super.toString()+"[numsecu="+this.numSecu+", salaire="+this.salaire+"]";
	}


	@Override
	public void acheter(List<Achat> a) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean payer() {
		return false;

	}

	@Override
	public boolean estClient() {
		// TODO Auto-generated method stub
		return false;
	}

}
