package edu.esprit.services;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.esprit.persistance.Competence;
import edu.esprit.persistance.Technicien;

/**
 * Session Bean implementation class CompetenceService
 */
@Stateless
@LocalBean
public class CompetenceService implements CompetenceServiceRemote {

    /**
     * Default constructor. 
     */
    public CompetenceService() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext
    EntityManager em;

	@Override
	public void ajouterCompetence(Competence competence) {
		em.persist(competence);
		
	}

	@Override
	public Competence chercherCompetenceParId(int id) {
		
		return em.find(Competence.class, id);
	}

	@Override
	public void affecterCompetenceTechnicien(Competence c, Technicien t) {
		
		if(t.getCompetences()==null)
			{
			t.setCompetences(new ArrayList<>());
			}
			
		
		t.getCompetences().add(c);
		em.merge(t);
	}

}
