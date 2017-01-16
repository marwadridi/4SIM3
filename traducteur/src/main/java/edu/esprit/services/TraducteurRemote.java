package edu.esprit.services;

import javax.ejb.Remote;

@Remote
public interface TraducteurRemote {
	
	String traduire(String mot);

}
