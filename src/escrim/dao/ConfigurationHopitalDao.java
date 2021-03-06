package escrim.dao;

import java.util.List;

import javax.persistence.Query;

import escrim.metiers.ConfigurationHopital;
import escrim.utils.EscrimDatabase;

/**
 * The Class ConfigurationHopitalDao.
 */
public class ConfigurationHopitalDao {

	/** The escrim database. */
	static EscrimDatabase escrimDatabase = EscrimDatabase.getInstance();

	/**
	 * Creates the.
	 *
	 * @param ConfigurationHopital
	 *            the configuration hopital
	 */
	public static void create(ConfigurationHopital ConfigurationHopital) {
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().persist(ConfigurationHopital);
		escrimDatabase.getEm().getTransaction().commit();
	}

	/**
	 * Update.
	 *
	 * @param ConfigurationHopitalUpdated
	 *            the configuration hopital updated
	 * @param uid
	 *            the uid
	 */
	public static void update(ConfigurationHopital ConfigurationHopitalUpdated,
			int uid) {
		escrimDatabase.getEm().getTransaction().begin();
		ConfigurationHopitalUpdated = load(uid);
		escrimDatabase.getEm().getTransaction().commit();

	}

	/**
	 * Load.
	 *
	 * @param uid
	 *            the uid
	 * @return the configuration hopital
	 */

	public static ConfigurationHopital load(int uid) {

		return escrimDatabase.getEm().find(ConfigurationHopital.class, uid);
	}

	/**
	 * Removes the.
	 *
	 * @param ConfigurationHopitalRemoved
	 *            the configuration hopital removed
	 */
	public static void remove(ConfigurationHopital ConfigurationHopitalRemoved) {
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().remove(ConfigurationHopitalRemoved);
		escrimDatabase.getEm().getTransaction().commit();
	}

	/**
	 * Load all.
	 *
	 * @return the list
	 */
	public static List<ConfigurationHopital> loadAll() {

		Query query = escrimDatabase.getEm().createNamedQuery(
				"ConfigurationHopital.loadAll", ConfigurationHopital.class);
		@SuppressWarnings("unchecked")
		List<ConfigurationHopital> listeConfigurationHopital = query
				.getResultList();
		return listeConfigurationHopital;
	}

	/**
	 * Load distinct config.
	 *
	 * @return the list
	 */
	public static List<String> loadDistinctConfig() {
		Query query = escrimDatabase.getEm().createNamedQuery(
				"ConfigurationHopital.loadDistinctConfig", String.class);
		@SuppressWarnings("unchecked")
		List<String> listeDistinctConfigs = query.getResultList();
		return listeDistinctConfigs;
	}
}
