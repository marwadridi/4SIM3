package edu.esprit.services;

import javax.ejb.Remote;

import edu.esprit.persistence.Animateur;
import edu.esprit.persistence.Chaine;
import edu.esprit.persistence.Emission;
import edu.esprit.persistence.Realisateur;
import edu.esprit.persistence.Utilisateur;

@Remote
public interface ChaineServiceRemote {

	void ajouterUtilisateur(Utilisateur utilisateur);

	void ajouterChaine(Chaine chaine);

	void AffecterAnimateurAUneEmission(Animateur animateur, Emission emission);

	Emission findById(String id);

	Utilisateur findByIdUser(int id);

	void affecterRealisateurAUneEmission (Realisateur realisateur,
			Emission emission);
}
