package escrim.utils;

import java.util.regex.*;

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
		if(login.equals(this.login) && motDePasse.equals(this.motDePasse))
		{
			return true;
		}
		return false;
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
		EscrimDatabase em = EscrimDatabase.getInstance();
		String url = "jdbc:mysql://";
		if(Pattern.matches("^([a-z0-9.]+)?\\:([0-9]+)\\/([a-z0-9]+)$",urlDatabase))
		{
		  url = url + urlDatabase;
		  System.out.println(url);
		  em.getEm().setProperty("javax.persistence.jdbc.url", url);
		  return true;
		}
		return false;

		
	}
	
	
	
	
	
}
