package edu.esprit.services;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.esprit.persistence.Animateur;
import edu.esprit.persistence.Chaine;
import edu.esprit.persistence.Emission;
import edu.esprit.persistence.Realisateur;
import edu.esprit.persistence.Utilisateur;

/**
 * Session Bean implementation class ChaineService
 */
@Stateless
@LocalBean
public class ChaineService implements ChaineServiceRemote {

    /**
     * Default constructor. 
     */
    public ChaineService() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
    EntityManager em;

	@Override
	public void ajouterUtilisateur(Utilisateur utilisateur) {
		em.persist(utilisateur);
		
	}

	@Override
	public void ajouterChaine(Chaine chaine) {
		em.persist(chaine);
	}

	@Override
	public void AffecterAnimateurAUneEmission(Animateur animateur, Emission emission) {
		
		if(emission.getAnimateurs()==null)
			emission.setAnimateurs(new ArrayList<Utilisateur>());
		
		emission.getAnimateurs().add(animateur);
		em.merge(emission);
		
	}

	@Override
	public Emission findById(String id) {
		return em.find(Emission.class, id);
	}

	@Override
	public Utilisateur findByIdUser(int id) {
		return em.find(Utilisateur.class, id);
	}

	@Override
	public void affecterRealisateurAUneEmission(Realisateur realisateur, Emission emission) {
		// TODO Auto-generated method stub
		
	}

}
