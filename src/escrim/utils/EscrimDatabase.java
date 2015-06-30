/**
 * 
 */
package escrim.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Martin Classe permettant l'unicit� de la connexion � la base de
 *         donn�es, lorsqu'une transaction est n�cessaire, faire appel � cette
 *         classe
 */
public class EscrimDatabase {

	private static EscrimDatabase singleton = null;
	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("escrim");
	EntityManager em = factory.createEntityManager();

	protected EscrimDatabase() {

	}

	public static EscrimDatabase getInstance() {

		if (singleton == null)
			singleton = new EscrimDatabase();
		return singleton;

	}

	public EntityManagerFactory getFactory() {
		return factory;
	}

	public void setFactory(EntityManagerFactory factory) {
		this.factory = factory;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
