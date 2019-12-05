package projetpoo01.gestionpersonnes;

import java.io.Serializable;
import java.util.List;

import projetpoo01.gestionachats.Achat;
import projetpoo01.gestionachats.Commande;

/**
 * 
 * @author GALLAND Maxence
 * @version 1.0
 * <br/><b> Java Doc projet POO 01 </b>
 *
 */

public class Personne implements IClient, IFournisseur, Serializable {
	private static final long serialVersionUID = 1L;
	private String nom;
	private String prenom;
	private String adresse;
	private String ville;
	private String codepostal;
	protected boolean client;
	private List<Achat> achats;
	protected boolean fournisseur;
	private List<Commande> commandes;

	/**
	 * 
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param ville
	 * @param codepostal
	 */
	public Personne(String nom, String prenom, String adresse, String ville, String codepostal) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.codepostal = codepostal;
	}
	

	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", ville=" + ville
				+ ", codepostal=" + codepostal + ", client=" + client + ", achats=" + achats + ", fournisseur="
				+ fournisseur + ", commandes=" + commandes + "]";
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	public List<Achat> getAchats() {
		return achats;
	}

	public void setAchats(List<Achat> achats) {
		this.achats = achats;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	@Override
	public void commander(List<Commande> c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean livrer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estFournisseur() {
		// TODO Auto-generated method stub
		return fournisseur;
	}

	@Override
	public void acheter(List<Achat> a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean payer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estClient() {
		// TODO Auto-generated method stub
		return client;
	}
	
	
}
