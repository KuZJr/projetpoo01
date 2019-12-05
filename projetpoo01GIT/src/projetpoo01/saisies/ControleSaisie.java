package projetpoo01.saisies;

import java.text.SimpleDateFormat;
import java.util.Date;

import projetpoo01.exceptions.ErreurSaisie;

public class ControleSaisie {
	public static Date verifDate(String date) throws ErreurSaisie {
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("dd/MM/yyyy");
		format.setLenient(false);
		try {
			Date nDate = format.parse(date);
			return nDate;
		} catch (Exception e) {
			throw new ErreurSaisie("Mauvais format de date ! Réinsérez :");
		}
	}

	public static boolean verifReponse(String reponse) throws ErreurSaisie {
		if (reponse.equals("oui")) {
			return true;
		}
		else if (reponse.equals("non")){
			return false;
		}
		else {
			throw new ErreurSaisie("Répondre uniquement par oui ou non !");
		}
	}

}
