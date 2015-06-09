/**
 * 
 */
package escrim.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Martin
 * Classe permettant l'unicité de la connexion à la base de données, lorsqu'une transaction est nécessaire,
 * faire appel à cette classe
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
