package edu.esprit.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import edu.esprit.persistance.Contact;
import edu.esprit.persistance.Technicien;
import edu.esprit.persistance.Utilisateur;

/**
 * Session Bean implementation class UtilisateurService
 */
@Stateless
@LocalBean
public class UtilisateurService implements UtilisateurServiceRemote {
	
	@PersistenceContext
	EntityManager em;
	

    /**
     * Default constructor. 
     */
    public UtilisateurService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void ajouterUtilisateur(Utilisateur utilisateur) {
		
		em.persist(utilisateur);
		
	}
	@Override
	public void supprimerUtilisateur(Utilisateur utilisateur) {
		
		em.remove(chercherParId(utilisateur.getId()));
		
	}
	@Override
	public Utilisateur modifierUtilisateur(Utilisateur utilisateur) {
		
		return em.merge(utilisateur);
	}

	@Override
	public Utilisateur chercherParId(int id) {
		return em.find(Utilisateur.class, id);
	}

	@Override
	public List<Technicien> retournerListeTechnicien() {
		
		String requete="select t from Technicien t";
		 
	     return em.createQuery(requete, Technicien.class)
			 .getResultList();
	}

	@Override
	public Utilisateur chercherParNom(String nom) {
		
		String requete ="select u from Utilisateur u where u.nom=:x";
		try{
		return em.createQuery(requete,Utilisateur.class)
				.setParameter("x", nom)
				.getSingleResult();

		}
		catch(NoResultException ex ){
			System.out.println("pas de résultat");
			return null;
		}
		
	}

	@Override
	public Utilisateur identifierUtisateur(String login, String password) {
		
		String requete ="select u from Utilisateur u where u.login=:x and u.password=:y";
		try{
		return em.createQuery(requete,Utilisateur.class)
				.setParameter("x", login)
				.setParameter("y", password)
				.getSingleResult();

		}
		catch(NoResultException ex ){
			System.out.println("pas de résultat");
			return null;
		}
	}

	@Override
	public void ajouterContact(Contact contact) {
		em.persist(contact);
		
	}

	@Override
	public Contact chercherContact(int id) {

		return em.find(Contact.class, id);

	}

	@Override
	public void affecterUtilisateurAContact(Utilisateur u, Contact c) {
		
		c.setUtilisateur(u);
		em.merge(c);
		
	}

}
