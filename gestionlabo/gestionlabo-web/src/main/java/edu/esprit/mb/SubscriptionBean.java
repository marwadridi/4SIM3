package edu.esprit.mb;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.esprit.persistance.Chercheur;
import edu.esprit.persistance.Contact;
import edu.esprit.services.UtilisateurService;

@ManagedBean(name = "sbean")
@SessionScoped
public class SubscriptionBean {
	
	
	private Chercheur chercheur = new Chercheur();
	
	private Contact contact = new Contact();
	
	@EJB
	UtilisateurService service;
	

	public void doAdd(){
		
		chercheur.setContact(contact);
		contact.setUtilisateur(chercheur);
		//cascade persist 
		service.ajouterUtilisateur(chercheur);
		
		FacesContext.getCurrentInstance().addMessage("form:btn",
				new FacesMessage("ajout avec succés"));
		
		
	}
	
	public String doCancel(){
		
		chercheur = new Chercheur();
		contact = new Contact();
		
		return "step1?faces-redirect=true";
		
	}
	
	
	public Chercheur getChercheur() {
		return chercheur;
	}

	public void setChercheur(Chercheur chercheur) {
		this.chercheur = chercheur;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	

}
