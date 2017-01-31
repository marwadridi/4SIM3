package edu.esprit.persistence;

import edu.esprit.persistence.Utilisateur;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Animateur
 *
 */
@Entity

public class Animateur extends Utilisateur implements Serializable {

	
	private String specialite;
	private static final long serialVersionUID = 1L;

	public Animateur() {
		super();
	}   
	public String getSpecialite() {
		return this.specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
   
}
