package edu.esprit.services;

import javax.ejb.Remote;

import edu.esprit.persistance.Laboratoire;
import edu.esprit.persistance.Utilisateur;

@Remote
public interface LaboServiceRemote {
	
	void ajouterLabo(Laboratoire laboratoire);
	Laboratoire chercherParId(int id);
	void affecterUtilisateurLabo(Laboratoire l, Utilisateur u);

}
