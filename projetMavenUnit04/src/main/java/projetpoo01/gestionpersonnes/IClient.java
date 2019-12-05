package projetpoo01.gestionpersonnes;

import java.util.List;

import projetpoo01.gestionachats.Achat;

public interface IClient {
	
	public void acheter(List<Achat> a);
	public boolean payer();
	public boolean estClient();
}
