package edu.esprit.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Chaine
 *
 */
@Entity

public class Chaine implements Serializable {

	@Id
	private String nom;
	private long frequence;
	private static final long serialVersionUID = 1L;
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private List<Emission> emissions;

	public Chaine() {
		super();
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public long getFrequence() {
		return this.frequence;
	}

	public void setFrequence(long frequence) {
		this.frequence = frequence;
	}

	public List<Emission> getEmissions() {
		return emissions;
	}

	public void setEmissions(List<Emission> emissions) {
		this.emissions = emissions;
	}

}
