package edu.esprit.test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import edu.esprit.persistence.Animateur;
import edu.esprit.persistence.Emission;
import edu.esprit.persistence.Realisateur;
import edu.esprit.services.ChaineServiceRemote;

public class TestQ3 {

	public static void main(String[] args) throws NamingException {


		String jndiName="chaineTV-ear/chaineTV-ejb"
				+ "/ChaineService!edu.esprit.services.ChaineServiceRemote";
		Context context= new InitialContext();
		ChaineServiceRemote proxy= (ChaineServiceRemote) context.lookup(jndiName);

		Animateur animateur=(Animateur) proxy.findByIdUser(2);
		
		Emission emission = proxy.findById("emisson1");
		
		proxy.AffecterAnimateurAUneEmission(animateur, emission);
		
		
	}

}
