package edu.esprit.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Utils {

	static Context context;

	public static Object getProxy(String jndiName) {
		Object obj = null;
		try {
			context = new InitialContext();
			obj = context.lookup(jndiName);
		} 
		 catch (NamingException e) {
			e.getMessage();
			e.printStackTrace();
		}

		return obj;
	}

}
