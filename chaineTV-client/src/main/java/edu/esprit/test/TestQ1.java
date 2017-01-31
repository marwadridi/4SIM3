package edu.esprit.test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import edu.esprit.persistence.Animateur;
import edu.esprit.persistence.Realisateur;
import edu.esprit.services.ChaineServiceRemote;

public class TestQ1 {

	public static void main(String[] args) throws NamingException {


		String jndiName="chaineTV-ear/chaineTV-ejb"
				+ "/ChaineService!edu.esprit.services.ChaineServiceRemote";
		Context context= new InitialContext();
		ChaineServiceRemote proxy= (ChaineServiceRemote) context.lookup(jndiName);

		Realisateur realisateur = new Realisateur();
		Animateur animateur = new Animateur();
		Animateur animateur2 = new Animateur();
		
		realisateur.setNom("x");
		realisateur.setPrenom("y");
		realisateur.setDomaine("doc");
		
		animateur.setNom("anim");
		animateur.setPrenom("anim");
		animateur.setSpecialite("div");
		
		animateur2.setNom("anim2");
		animateur2.setPrenom("anim2");
		animateur2.setSpecialite("div");
		
		proxy.ajouterUtilisateur(realisateur);
		proxy.ajouterUtilisateur(animateur2);
		proxy.ajouterUtilisateur(animateur);
	}

}
