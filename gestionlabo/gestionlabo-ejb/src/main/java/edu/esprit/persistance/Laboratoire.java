package edu.esprit.persistance;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Laboratoire
 *
 */
@Entity

public class Laboratoire implements Serializable {

	   
	@Id
	private int id;
	private String nom;
	private String adresse;
	private static final long serialVersionUID = 1L;
	
	//uni directionnel Labo => utilisateur
	
//	@OneToMany
//	private List<Utilisateur> utilisateurs;
	
	@OneToMany(mappedBy="laboratoire")
	private List<Utilisateur> utilisateurs;

	public Laboratoire() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
   
}
