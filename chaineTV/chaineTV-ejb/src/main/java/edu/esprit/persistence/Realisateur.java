package edu.esprit.persistence;

import edu.esprit.persistence.Utilisateur;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Realisateur
 *
 */
@Entity

public class Realisateur extends Utilisateur implements Serializable {

	
	private String domaine;
	private static final long serialVersionUID = 1L;

	public Realisateur() {
		super();
	}   
	public String getDomaine() {
		return this.domaine;
	}

	public void setDomaine(String domaine) {
		this.domaine = domaine;
	}
   
}
