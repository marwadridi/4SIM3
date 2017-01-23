package edu.esprit.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.esprit.persistance.Laboratoire;
import edu.esprit.persistance.Utilisateur;

/**
 * Session Bean implementation class LaboService
 */
@Stateless
@LocalBean
public class LaboService implements LaboServiceRemote {

    /**
     * Default constructor. 
     */
    public LaboService() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext
    EntityManager em;
    
    
	@Override
	public void ajouterLabo(Laboratoire laboratoire) {
		em.persist(laboratoire);
		
	}

	@Override
	public Laboratoire chercherParId(int id) {
		return  em.find(Laboratoire.class, id);
		
	}

	@Override
	public void affecterUtilisateurLabo(Laboratoire l, Utilisateur u) {
		u.setLaboratoire(l);
		em.merge(u);
		
	}

}
