package edu.esprit.services;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.persistance.Contact;
import edu.esprit.persistance.Technicien;
import edu.esprit.persistance.Utilisateur;

@Remote
public interface UtilisateurServiceRemote {
	
	void ajouterUtilisateur(Utilisateur utilisateur);
	void supprimerUtilisateur(Utilisateur utilisateur);
	Utilisateur modifierUtilisateur(Utilisateur utilisateur);
	Utilisateur chercherParId(int id);
	
	List<Technicien> retournerListeTechnicien();
	Utilisateur chercherParNom(String nom);
	Utilisateur identifierUtisateur(String login,String password);
	
	
	void ajouterContact(Contact contact);
	Contact chercherContact(int id);
	
	void affecterUtilisateurAContact(Utilisateur u,Contact c);

}
