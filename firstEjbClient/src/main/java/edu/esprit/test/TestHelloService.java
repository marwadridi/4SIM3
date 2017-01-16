package edu.esprit.test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import edu.esprit.services.HelloServiceRemote;

public class TestHelloService {

	public static void main(String[] args) {
		
		
	String projet="firstEjb";
	String implClass="HelloService";
	String interfaceRemote="edu.esprit.services.HelloServiceRemote";
		
	String 	JndiName=projet+"/"+implClass+"!"+interfaceRemote;
		

		try {
			Context context = new InitialContext();
			HelloServiceRemote proxy= (HelloServiceRemote) context.lookup(JndiName);
			
			
			System.out.println(proxy.sayHello("hello"));
			
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
