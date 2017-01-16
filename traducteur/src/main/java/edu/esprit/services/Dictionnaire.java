package edu.esprit.services;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class Dictionnaire
 */
@Singleton
@LocalBean
public class Dictionnaire {

	private Map<String, String> dict= new HashMap<>();
	
	   public Dictionnaire() {
	        
		   dict.put("hello", "salut");
		   dict.put("bonjour", "good morning");
	    }
	    
	    public Map<String, String> getDict() {
			return dict;
		}

		public void setDict(Map<String, String> dict) {
			this.dict = dict;
		}

}
