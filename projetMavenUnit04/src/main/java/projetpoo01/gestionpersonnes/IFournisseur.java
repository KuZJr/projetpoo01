package projetpoo01.gestionpersonnes;

import java.util.List;

import projetpoo01.gestionachats.Commande;

public interface IFournisseur {
	
	public void commander(List<Commande> c);
	public boolean livrer();
	public boolean estFournisseur();
}