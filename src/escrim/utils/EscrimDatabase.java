/**
 * 
 */
package escrim.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * The Class EscrimDatabase.
 *
 * @author Martin Classe permettant l'unicité de la connexion à la base de
 *         données, lorsqu'une transaction est nécessaire, faire appel à cette
 *         classe
 */
public class EscrimDatabase {

	/** The singleton. */
	private static EscrimDatabase singleton = null;
	
	/** The factory. */
	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("escrim");
	
	/** The em. */
	EntityManager em = factory.createEntityManager();

	/**
	 * Instantiates a new escrim database.
	 */
	protected EscrimDatabase() {

	}

	/**
	 * Gets the single instance of EscrimDatabase.
	 *
	 * @return single instance of EscrimDatabase
	 */
	public static EscrimDatabase getInstance() {

		if (singleton == null)
			singleton = new EscrimDatabase();
		return singleton;

	}

	/**
	 * Gets the factory.
	 *
	 * @return the factory
	 */
	public EntityManagerFactory getFactory() {
		return factory;
	}

	/**
	 * Sets the factory.
	 *
	 * @param factory the new factory
	 */
	public void setFactory(EntityManagerFactory factory) {
		this.factory = factory;
	}

	/**
	 * Gets the em.
	 *
	 * @return the em
	 */
	public EntityManager getEm() {
		return em;
	}

	/**
	 * Sets the em.
	 *
	 * @param em the new em
	 */
	public void setEm(EntityManager em) {
		this.em = em;
	}

}
