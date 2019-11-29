package projetpoo01.gestionpersonnes;

public class Patron extends Salarie implements IPatron {

	public Patron(String nom, String prenom, String adresse, String ville, String codepostal, String numsecu,
			String salaire, boolean nclient) {
		super(nom, prenom, adresse, ville, codepostal, numsecu, salaire, nclient);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void embaucher() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void licencier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean payerSalarie() {
		// TODO Auto-generated method stub
		return false;
	}

}
