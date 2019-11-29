package projetpoo01.gestionachats;

public class Achat {
	private String date;
	private String intitule;
	private String quantite;
	
	public Achat(String date, String intitule, String quantite) {
		super();
		this.date = date;
		this.intitule = intitule;
		this.quantite = quantite;
	}

	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
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
		return "Achat [Date=" + getDate() + ", Intitulé=" + getIntitule() + ", Quantité=" + getQuantite()
				+ "]";
	}
	
}
