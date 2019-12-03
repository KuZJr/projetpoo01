package projetpoo01.gestionachats;

import java.io.Serializable;
import java.util.Date;

public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date date;
	private String intitule;
	private String quantite;
	
	public Commande(Date date, String intitule, String quantite) {
		super();
		this.date = date;
		this.intitule = intitule;
		this.quantite = quantite;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getIntitule() {
		return intitule;
	}
	
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	
	public String getQuantite() {
		return quantite;
	}
	
	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}
	
	@Override
	public String toString() {
		return "Commande [Date=" + getDate() + ", Intitulé=" + getIntitule() + ", Quantité="
				+ getQuantite() + "]";
	}
	
}
