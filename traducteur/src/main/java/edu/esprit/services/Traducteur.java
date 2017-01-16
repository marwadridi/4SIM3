package edu.esprit.services;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Traducteur
 */
@Stateless
public class Traducteur implements TraducteurRemote {

    /**
     * Default constructor. 
     */
    public Traducteur() {
        // TODO Auto-generated constructor stub
    }

    @EJB
    Dictionnaire dictionnaire;
    
    
	@Override
	public String traduire(String mot) {
		
		return dictionnaire.getDict().get(mot);
	}

}
