package edu.esprit.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Utilisateur
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Utilisateur implements Serializable {

	   
	@Id
	@GeneratedValue
	private int id;
	private String nom;
	private String prenom;
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy="realisateur")
	private List<Emission> emissionsRealisateurs;
	
	@ManyToMany(mappedBy="animateurs")
	private List<Emission> emissionsAnimateurs;
	public Utilisateur() {
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
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public List<Emission> getEmissionsRealisateurs() {
		return emissionsRealisateurs;
	}
	public void setEmissionsRealisateurs(List<Emission> emissionsRealisateurs) {
		this.emissionsRealisateurs = emissionsRealisateurs;
	}
	public List<Emission> getEmissionsAnimateurs() {
		return emissionsAnimateurs;
	}
	public void setEmissionsAnimateurs(List<Emission> emissionsAnimateurs) {
		this.emissionsAnimateurs = emissionsAnimateurs;
	}
   
}
