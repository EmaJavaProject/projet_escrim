package escrim.utils;

import java.util.Properties;
import java.util.regex.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import escrim.manager.MaterielManager;
import escrim.manager.TypeColisManager;

public class ConnexionEscrim {

	private static ConnexionEscrim singleton = null;
	
	private String login;
	private String motDePasse;
	
	protected ConnexionEscrim() {
		EscrimDatabase em = EscrimDatabase.getInstance();
		login = em.getEm().getProperties().get("javax.persistence.jdbc.user").toString();
		motDePasse = em.getEm().getProperties().get("javax.persistence.jdbc.password").toString();
	}

	public static ConnexionEscrim getInstance() {

		if (singleton == null)
			singleton = new ConnexionEscrim();
		return singleton;

	}
	
	public boolean testInformationConnexion(String login, String motDePasse)
	{
		try{
			if(login.equals(this.login) && motDePasse.equals(this.motDePasse))
			{
				TypeColisManager.loadAllTypeColis();
				return true;
			}
			return false;
		}catch(Exception e)
		{
			return false;
		}
		
		
	}
	
	public String getInformationConnexion()
	{
		EscrimDatabase em = EscrimDatabase.getInstance();
		String url = em.getEm().getProperties().get("javax.persistence.jdbc.url").toString();    
		Matcher testeur = Pattern.compile("jdbc:mysql://([a-z0-9.]+)?\\:([0-9]+)\\/([a-z0-9]+)").matcher(url);
		if(testeur.matches())
		{
			url = new String();
		    for(int index=1; index <= testeur.groupCount(); index++)
		    {
		    	url = url + testeur.group(index);
		    	if(index == 1) url = url + ":";
		    	if(index == 2) url = url + "/";
		    }
		}
		System.out.println(url);
		return url;
	}
	
	public boolean setInformationConnexion(String urlDatabase)
	{
		try{
			EscrimDatabase em = EscrimDatabase.getInstance();
			String url = "jdbc:mysql://";
			if(Pattern.matches("^([a-z0-9.]+)?\\:([0-9]+)\\/([a-z0-9]+)$",urlDatabase))
			{
			  url = url + urlDatabase;
			  System.out.println(url);
			  Properties propriete = new Properties();
			  propriete.setProperty("javax.persistence.jdbc.url", url);
			  EntityManagerFactory factory = Persistence.createEntityManagerFactory("escrim", propriete);
			  em.setEm(factory.createEntityManager());
			  return true;
			}
			return false;	
		}catch(Exception e)
		{
			return false;
		}
		
	}
	
	
	
	
	
}
