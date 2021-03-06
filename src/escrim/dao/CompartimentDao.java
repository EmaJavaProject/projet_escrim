package escrim.dao;

import java.util.List;

import javax.persistence.Query;

import escrim.metiers.Compartiment;
import escrim.utils.EscrimDatabase;

/**
 * The Class CompartimentDao.
 */
public class CompartimentDao {

	/** The escrim database. */
	static EscrimDatabase escrimDatabase = EscrimDatabase.getInstance();

	/**
	 * Creates the.
	 *
	 * @param compartiment
	 *            the compartiment
	 */
	public static void create(Compartiment compartiment) {
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().persist(compartiment);
		escrimDatabase.getEm().getTransaction().commit();
	}

	/**
	 * Update.
	 *
	 * @param compartimentUpdated
	 *            the compartiment updated
	 * @param uid
	 *            the uid
	 */
	public static void update(Compartiment compartimentUpdated, int uid) {
		escrimDatabase.getEm().getTransaction().begin();
		compartimentUpdated = load(uid);
		escrimDatabase.getEm().getTransaction().commit();

	}

	/**
	 * Load.
	 *
	 * @param uid
	 *            the uid
	 * @return the compartiment
	 */
	public static Compartiment load(int uid) {

		return escrimDatabase.getEm().find(Compartiment.class, uid);
	}

	/**
	 * Removes the.
	 *
	 * @param compartimentRemoved
	 *            the compartiment removed
	 */
	public static void remove(Compartiment compartimentRemoved) {
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().remove(compartimentRemoved);
		escrimDatabase.getEm().getTransaction().commit();
	}

	/**
	 * Load all.
	 *
	 * @return the list
	 */
	public static List<Compartiment> loadAll() {

		Query query = escrimDatabase.getEm().createNamedQuery(
				"Compartiment.loadAll", Compartiment.class);
		@SuppressWarnings("unchecked")
		List<Compartiment> listeCompartiment = query.getResultList();
		return listeCompartiment;
	}

	/**
	 * Find compartiment into transport.
	 *
	 * @param uidTransport
	 *            the uid transport
	 * @return the list
	 */
	public static List<Compartiment> findCompartimentIntoTransport(
			int uidTransport) {
		Query query = escrimDatabase.getEm().createNamedQuery(
				"Compartiment.findCompartimentIntoTransport",
				Compartiment.class);
		query.setParameter("uid", uidTransport);
		@SuppressWarnings("unchecked")
		List<Compartiment> listeCompartiments = query.getResultList();
		return listeCompartiments;

	}

	/**
	 * Find compartiment outside transport.
	 *
	 * @param uidTransport
	 *            the uid transport
	 * @return the list
	 */
	public static List<Compartiment> findCompartimentOutsideTransport(
			int uidTransport) {
		Query query = escrimDatabase.getEm().createNamedQuery(
				"Compartiment.findCompartimentOutsideTransport",
				Compartiment.class);
		@SuppressWarnings("unchecked")
		List<Compartiment> listeAllCompartiments = query.getResultList();
		return listeAllCompartiments;
	}
}
