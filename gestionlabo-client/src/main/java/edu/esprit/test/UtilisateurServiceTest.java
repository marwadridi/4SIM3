package edu.esprit.test;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import edu.esprit.persistance.Contact;
import edu.esprit.persistance.Technicien;
import edu.esprit.persistance.Utilisateur;
import edu.esprit.services.UtilisateurServiceRemote;

public class UtilisateurServiceTest {

	public static void main(String[] args) throws NamingException {
		
		String jndiName="gestionlabo-ear/gestionlabo-ejb"
				+ "/UtilisateurService!edu.esprit.services.UtilisateurServiceRemote";
		Context context = new InitialContext();
		
		UtilisateurServiceRemote proxy = (UtilisateurServiceRemote) context.lookup(jndiName);
		
		
		//test ajout d'un technicien
		
		Technicien utilisateur = new Technicien();
		utilisateur.setLogin("login");
		utilisateur.setNom("user1");
		utilisateur.setPassword("pass");
		utilisateur.setSpecialite("dev");
		
		//proxy.ajouterUtilisateur(utilisateur);
		
		// test chercher par ID 
		
		Utilisateur technicien = (Technicien) proxy.chercherParId(1);
		
		System.out.println(technicien.getNom());
		
		// test update 

		technicien.setNom("nom modifié");
		
		//proxy.modifierUtilisateur(technicien);
		
		// test remove
		
		//proxy.supprimerUtilisateur(technicien);
		
		// test find by Name :
		
		System.out.println(proxy.chercherParNom("user1"));
		
		//test lister techniciens 
		
		List<Technicien> techs = proxy.retournerListeTechnicien();
		
		techs.stream().forEach(t -> System.out.println(t.getNom()));
		
		// ajout contact 
		
		Contact contact = new Contact();
		contact.setAdresse("esprit");
		contact.setEmail("contact@esprit.tn");
		
		//proxy.ajouterContact(contact);
		
		 // recherhc du contact 
		
		contact =proxy.chercherContact(3);
		technicien = proxy.chercherParId(1);
		
		proxy.affecterUtilisateurAContact(technicien,contact);
		
		
		
		
		
	}

}
