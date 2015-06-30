package escrim.dao;

import java.util.List;

import javax.persistence.Query;

import escrim.metiers.Colis;
import escrim.utils.EscrimDatabase;

/**
 * The Class ColisDao.
 */
public class ColisDao {

	/** The escrim database. */
	static EscrimDatabase escrimDatabase = EscrimDatabase.getInstance();

	/**
	 * Creates the.
	 *
	 * @param Colis
	 *            the colis
	 */
	public static void create(Colis Colis) {

		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().persist(Colis);
		escrimDatabase.getEm().getTransaction().commit();
	}

	/**
	 * Update.
	 *
	 * @param ColisUpdated
	 *            the colis updated
	 * @param uid
	 *            the uid
	 */
	public static void update(Colis ColisUpdated, int uid) {
		Colis Colis = load(uid);
		escrimDatabase.getEm().getTransaction().begin();
		Colis = ColisUpdated;
		escrimDatabase.getEm().getTransaction().commit();

	}

	/**
	 * Load.
	 *
	 * @param uid
	 *            the uid
	 * @return the colis
	 */
	public static Colis load(int uid) {

		return escrimDatabase.getEm().find(Colis.class, uid);
	}

	/**
	 * Removes the.
	 *
	 * @param ColisRemoved
	 *            the colis removed
	 */
	public static void remove(Colis ColisRemoved) {
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().remove(ColisRemoved);
		escrimDatabase.getEm().getTransaction().commit();
	}

	/**
	 * Load all.
	 *
	 * @return the list
	 */
	public static List<Colis> loadAll() {

		Query query = escrimDatabase.getEm().createNamedQuery("Colis.loadAll",
				Colis.class);
		List<Colis> listeColis = query.getResultList();
		return listeColis;
	}

	public static List<Colis> findColisIntoConfigHopital(int uidConfig) {
		Query query = escrimDatabase
				.getEm()
				.createNativeQuery(
						"SELECT * FROM Colis inner join colis_config on Colis.UID = colis_config.Colis_UID where colis_config.Config_ID = "
								+ uidConfig + "", Colis.class);

		List<Colis> listeColis = query.getResultList();
		return listeColis;

	}

	public static List<Colis> findColisOutsideConfigHopital(int uidConfig) {
		Query query = escrimDatabase
				.getEm()
				.createNativeQuery(
						"SELECT * FROM COLIS WHERE COLIS.UID NOT IN (SELECT COLIS.UID FROM COLIS INNER JOIN COLIS_CONFIG ON COLIS.UID = COLIS_CONFIG.COLIS_UID WHERE COLIS_CONFIG.CONFIG_ID = "
								+ uidConfig + ")", Colis.class);

		List<Colis> listeAllColis = query.getResultList();

		return listeAllColis;
	}
}
