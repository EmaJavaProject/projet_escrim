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
	 * @param ConfigurationHopital the configuration hopital
	 */
	public static void create(ConfigurationHopital ConfigurationHopital) {
		// TODO Auto-generated method stub
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().persist(ConfigurationHopital);
		escrimDatabase.getEm().getTransaction().commit();
	}

	/**
	 * Update.
	 *
	 * @param ConfigurationHopitalUpdated the configuration hopital updated
	 * @param uid the uid
	 */
	public static void update(ConfigurationHopital ConfigurationHopitalUpdated, int uid) {
		ConfigurationHopital ConfigurationHopital = load(uid);
		escrimDatabase.getEm().getTransaction().begin();
		ConfigurationHopital = ConfigurationHopitalUpdated;
		escrimDatabase.getEm().getTransaction().commit();

	}

	/**
	 * Load.
	 *
	 * @param uid the uid
	 * @return the configuration hopital
	 */
	public static ConfigurationHopital load(int uid) {

		return escrimDatabase.getEm().find(ConfigurationHopital.class, uid);
	}

	/**
	 * Removes the.
	 *
	 * @param ConfigurationHopitalRemoved the configuration hopital removed
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

		Query query = escrimDatabase.getEm().createNativeQuery(
				"SELECT * FROM ConfigurationHopital", ConfigurationHopital.class);
		List<ConfigurationHopital> listeConfigurationHopital = query.getResultList();
		return listeConfigurationHopital;
	}
}
