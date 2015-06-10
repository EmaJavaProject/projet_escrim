/**
 * 
 */
package escrim.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Martin
 * Classe permettant l'unicit� de la connexion � la base de donn�es, lorsqu'une transaction est n�cessaire,
 * faire appel � cette classe
 */
public class EscrimDatabase {
	
	private static EscrimDatabase singleton = null;
	
	protected EscrimDatabase() {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("escrim");
	
	EntityManager em = factory.createEntityManager();
	}
	
	
    public static EscrimDatabase getInstance() {

	if (singleton == null)
	    singleton = new EscrimDatabase();
	return singleton;
	
    }

}
