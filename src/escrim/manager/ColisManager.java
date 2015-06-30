package escrim.manager;

import java.util.List;

import escrim.dao.ColisDao;
import escrim.metiers.Colis;
import escrim.metiers.TypeColis;

/**
 * The Class ColisManager.
 */
public class ColisManager {

	/**
	 * Creates the colis.
	 *
	 * @param colis
	 *            the colis
	 */
	public static void createColis(Colis colis) {
		TypeColis typeColis = new TypeColis();
		typeColis = TypeColisManager.findTypeColisByName(colis.getTypeColis()
				.getDesignation());
		colis.setTypeColis(typeColis);
		ColisDao.create(colis);

	}

	/**
	 * Creates the temp colis.
	 *
	 * @return the colis
	 */
	public static Colis createTempColis() {
		return new Colis();
	}

	/**
	 * Update colis.
	 *
	 * @param colis
	 *            the colis
	 * @param uid
	 *            the uid
	 */
	public static void updateColis(Colis colis, int uid) {

		if (loadColis(uid).getTypeColis().getDesignation() != colis
				.getTypeColis().getDesignation()) {
			TypeColis typeColis = new TypeColis();
			typeColis = TypeColisManager.findTypeColisByName(colis
					.getTypeColis().getDesignation());
			colis.setTypeColis(typeColis);
		}
		ColisDao.update(colis, uid);

	}

	/**
	 * Removes the colis.
	 *
	 * @param uid
	 *            the uid
	 */
	public static void removeColis(int uid) {
		Colis colisRemoved = loadColis(uid);
		ColisDao.remove(colisRemoved);

	}

	/**
	 * Load colis.
	 *
	 * @param uid
	 *            the uid
	 * @return the colis
	 */
	public static Colis loadColis(int uid) {
		return ColisDao.load(uid);

	}

	/**
	 * Load all colis.
	 *
	 * @return the list
	 */
	public static List<Colis> loadAllColis() {
		return ColisDao.loadAll();
	}

	public static List<Colis> loadOutsideConfigHopital(int uidConfig) {
		return ColisDao.findColisOutsideConfigHopital(uidConfig);
	}

	public static List<Colis> loadByConfigHopital(int uidConfig) {
		return ColisDao.findColisIntoConfigHopital(uidConfig);
	}

	public static void fillConfig(int uidConfig, int uidColis) {
		Colis colis = loadColis(uidColis);
		// /TODO
		// if (colis.get != TransportManager.loadTransport(uidConfig)) {
		// Transport transport = new Transport();
		// transport = TransportManager.loadTransport(uidConfig);
		// colis.setTransport(transport);
		// }
		updateColis(colis, colis.getUid());
	}

	public static void fillOutConfig(int uidConfig, int uidColis) {
		Colis colis = loadColis(uidColis);
		// TODO
		// colis.setTransport(null);

		updateColis(colis, colis.getUid());
	}

}
