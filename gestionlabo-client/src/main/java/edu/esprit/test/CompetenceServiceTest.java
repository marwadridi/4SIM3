package edu.esprit.test;

import edu.esprit.persistance.Competence;
import edu.esprit.persistance.Technicien;
import edu.esprit.services.CompetenceServiceRemote;
import edu.esprit.services.UtilisateurServiceRemote;
import edu.esprit.utils.Utils;

public class CompetenceServiceTest {

	public static void main(String[] args) {
		
		CompetenceServiceRemote compRemote = (CompetenceServiceRemote) Utils.getProxy("gestionlabo-ear/gestionlabo-ejb/CompetenceService"
				+ "!edu.esprit.services.CompetenceServiceRemote");
		UtilisateurServiceRemote userRemote = (UtilisateurServiceRemote) 
				Utils.getProxy(
				"gestionlabo-ear/gestionlabo-ejb" 
		+ "/UtilisateurService!edu.esprit.services.UtilisateurServiceRemote");
		
		
		Competence competence = new Competence();
		competence.setNom("java");
		Competence competence2 = new Competence();
		competence2.setNom("java EE");
		
		compRemote.ajouterCompetence(competence);
		compRemote.ajouterCompetence(competence2);
		
		
		Technicien tech =  (Technicien) userRemote.chercherParId(1);
		
		competence=compRemote.chercherCompetenceParId(5);
		competence2=compRemote.chercherCompetenceParId(6);
		
		compRemote.affecterCompetenceTechnicien(competence, tech);
		compRemote.affecterCompetenceTechnicien(competence2, tech);
		
		
		
	
		
		

	}

}
