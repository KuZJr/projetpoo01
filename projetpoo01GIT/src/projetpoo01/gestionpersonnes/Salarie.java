package projetpoo01.gestionpersonnes;

import java.util.List;

import projetpoo01.exceptions.ErreurSaisie;
import projetpoo01.gestionachats.Achat;

public class Salarie extends Personne implements IClient {
	private static final long serialVersionUID = 1L;
	private String numSecu;
	private String salaire;
	
	public Salarie(String nom, String prenom, String adresse, String ville, String codepostal, String numsecu, String salaire, boolean nclient) {
		super(nom, prenom, adresse, ville, codepostal);
		this.numSecu = numsecu;
		this.salaire = salaire;
		client = nclient;
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

	}

	@Override
	public boolean payer() {
		return false;
	}

	@Override
	public boolean estClient() {
		return false;
	}
	
	public static void verifNumSecu(String secu) throws ErreurSaisie {
		if (!secu.matches("\\d{13}")) {
			throw new ErreurSaisie("Mauvais format ! Réinsérez : ");
		}
	}
	
	public static void verifSalaire(String salaire) throws ErreurSaisie {
		if (!salaire.matches("\\d{1,9}+\\.\\d{2}€")) {
			throw new ErreurSaisie("Mauvais format ! Réinsérez : ");
		}
	}

}
