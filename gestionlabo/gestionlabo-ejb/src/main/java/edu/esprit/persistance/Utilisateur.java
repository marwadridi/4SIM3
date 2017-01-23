package edu.esprit.persistance;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
// @DiscriminatorColumn(name = "type")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur implements Serializable {

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "c_nom")
	private String nom;
	private String login;
	private String password;
	
	// one to one bi directionnel
	@OneToOne(mappedBy="utilisateur",cascade={CascadeType.PERSIST
		,CascadeType.MERGE})
	private  Contact contact;
	
	@ManyToOne
	private Laboratoire laboratoire;

	
	// uni directionnel
//	@OneToOne
//	private Contact contact;
//
//	@ManyToOne
//	private Laboratoire laboratoire;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Laboratoire getLaboratoire() {
		return laboratoire;
	}

	public void setLaboratoire(Laboratoire laboratoire) {
		this.laboratoire = laboratoire;
	}


}
