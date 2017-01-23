package edu.esprit.services;

import javax.ejb.Remote;

import edu.esprit.persistance.Competence;
import edu.esprit.persistance.Technicien;

@Remote
public interface CompetenceServiceRemote {

	void ajouterCompetence(Competence competence);

	Competence chercherCompetenceParId(int id);

	void affecterCompetenceTechnicien(Competence c, Technicien t);

}
