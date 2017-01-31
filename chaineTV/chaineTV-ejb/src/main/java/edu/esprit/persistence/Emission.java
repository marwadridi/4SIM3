package edu.esprit.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Emission
 *
 */
@Entity

public class Emission implements Serializable {

	   
	@Id
	private String nom;
	private int duree;
	private String jour;
	private String frequence;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Utilisateur realisateur;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Utilisateur> animateurs;

	public Emission() {
		super();
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public int getDuree() {
		return this.duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}   
	public String getJour() {
		return this.jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}   
	public String getFrequence() {
		return this.frequence;
	}

	public void setFrequence(String frequence) {
		this.frequence = frequence;
	}
	public Utilisateur getRealisateur() {
		return realisateur;
	}
	public void setRealisateur(Utilisateur realisateur) {
		this.realisateur = realisateur;
	}
	public List<Utilisateur> getAnimateurs() {
		return animateurs;
	}
	public void setAnimateurs(List<Utilisateur> animateurs) {
		this.animateurs = animateurs;
	}
   
}
