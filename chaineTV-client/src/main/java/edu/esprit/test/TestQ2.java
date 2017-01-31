package edu.esprit.test;

import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import edu.esprit.persistence.Chaine;
import edu.esprit.persistence.Emission;
import edu.esprit.services.ChaineServiceRemote;

public class TestQ2 {

	public static void main(String[] args) throws NamingException {
		String jndiName="chaineTV-ear/chaineTV-ejb"
				+ "/ChaineService!edu.esprit.services.ChaineServiceRemote";
		Context context= new InitialContext();
		ChaineServiceRemote proxy= (ChaineServiceRemote) context.lookup(jndiName);

		Chaine chaine = new Chaine();
		chaine.setNom("chaine");
		chaine.setFrequence(12451);
		
		Emission emission = new Emission();
		emission.setNom("emisson1");
		emission.setDuree(60);
		emission.setFrequence("hebdo");
		emission.setJour("lundi");
		Emission emission2 = new Emission();
		emission2.setNom("emisson2");
		emission2.setDuree(30);
		emission2.setFrequence("hebdo");
		emission2.setJour("mardi");
		
		
		chaine.setEmissions(new ArrayList<Emission>());
		chaine.getEmissions().add(emission);
		chaine.getEmissions().add(emission2);
		
		proxy.ajouterChaine(chaine);
		
	}

}
