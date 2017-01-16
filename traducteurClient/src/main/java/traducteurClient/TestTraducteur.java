package traducteurClient;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import edu.esprit.services.TraducteurRemote;

public class TestTraducteur {

	public static void main(String[] args) throws NamingException {
		
		
		String projet="traducteur";
		String implClass="Traducteur";
		String interfaceRemote=TraducteurRemote.class.getCanonicalName();
		
		String jndiName=projet+"/"+implClass+"!"+interfaceRemote;
		
		
		Context context = new InitialContext();
		
		TraducteurRemote proxy= (TraducteurRemote) context.lookup(jndiName);
		
		System.out.println(proxy.traduire("hello"));

	}

}
