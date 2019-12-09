/**
 * Classe principale du programme
 * 
 * @version 1.0
 * 
 * @author GALLAND Maxence
 */
package projetpoo01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import projetpoo01.affichages.Affichage;
import projetpoo01.affichages.Menu;
import projetpoo01.gestionpersonnes.IClient;
import projetpoo01.gestionpersonnes.Patron;
import projetpoo01.gestionpersonnes.Personne;
import projetpoo01.saisies.Saisie;

public class Programme {
	static List<Personne> lp = new ArrayList<Personne>();
	static Scanner sc = new Scanner(System.in);
	static Patron patron;
	/**
	 * Programme principal.
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Menu.lp = lp;
		Menu.sc = sc;
		Saisie.lp = lp;
		Saisie.sc = sc;
		Affichage.lp = lp;
		
		try {
			FileInputStream fis = new FileInputStream("lpers.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			lp = (ArrayList<Personne>)ois.readObject();
			ois.close();
		} catch (IOException e) {
			System.out.println("Cr�ation d'un fichier de sauvegarde...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Menu.menuPrincipal();
		sc.close();
		
		try {
			FileOutputStream fos = new FileOutputStream("lpers.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(lp);
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void gererclient(IClient client) {
		client.acheter(null);
		client.payer();
	}
	
}
