package edu.esprit.test;

import edu.esprit.persistance.Chercheur;
import edu.esprit.persistance.Laboratoire;
import edu.esprit.services.LaboServiceRemote;
import edu.esprit.services.UtilisateurServiceRemote;
import edu.esprit.utils.Utils;

public class LaboServiceTest {

	public static void main(String[] args) {

		UtilisateurServiceRemote userRemote = (UtilisateurServiceRemote) 
				Utils.getProxy(
				"gestionlabo-ear/gestionlabo-ejb" 
		+ "/UtilisateurService!edu.esprit.services.UtilisateurServiceRemote");

		LaboServiceRemote laboRemote = (LaboServiceRemote) Utils
				.getProxy("gestionlabo-ear/gestionlabo-ejb/LaboService" 
		+ "!edu.esprit.services.LaboServiceRemote");

		Chercheur chercheur = new Chercheur();
		chercheur.setNom("x");
		chercheur.setGrade("doctorant");
		chercheur.setLogin("login");
		chercheur.setPassword("pass");

		//userRemote.ajouterUtilisateur(chercheur);

		Laboratoire laboratoire = new Laboratoire();
		laboratoire.setNom("labo");
		laboratoire.setId(1);

		//laboRemote.ajouterLabo(laboratoire);
		
		chercheur=(Chercheur) userRemote.chercherParId(4);
		laboratoire=laboRemote.chercherParId(1);
		laboRemote.affecterUtilisateurLabo(laboratoire, chercheur);

	}

}
