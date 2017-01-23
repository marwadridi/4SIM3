package edu.esprit.test;

import edu.esprit.persistance.Contact;
import edu.esprit.persistance.Technicien;
import edu.esprit.services.UtilisateurServiceRemote;
import edu.esprit.utils.Utils;

public class CascadeTest {
	
	public static void main(String[] args) {
		
		
		UtilisateurServiceRemote userRemote= (UtilisateurServiceRemote) 
				Utils.getProxy("gestionlabo-ear/gestionlabo-ejb" 
						+ "/UtilisateurService!edu.esprit.services."
						+ "UtilisateurServiceRemote");
		
		
		Technicien tech = new Technicien();
		tech.setNom("teckx");
		tech.setSpecialite("dev");
		tech.setLogin("tech");
		tech.setPassword("pass");
		
		
		Contact contact = new Contact();
		contact.setAdresse("tunis");
		contact.setEmail("x@esprit.tn");
		
		contact.setUtilisateur(tech);
		
		tech.setContact(contact);
		
		userRemote.ajouterUtilisateur(tech);
	}

}
