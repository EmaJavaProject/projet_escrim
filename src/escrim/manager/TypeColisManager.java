package escrim.manager;

import java.util.List;

import escrim.dao.TypeColisDao;
import escrim.metiers.TypeColis;

/**
 * The Class TypeColisManager.
 */
public class TypeColisManager {

	/**
	 * Creates the type colis.
	 *
	 * @param typeColis the type colis
	 */
	public static void createTypeColis(TypeColis typeColis) {
		typeColis.setVolume();
		TypeColisDao.create(typeColis);

	}

	/**
	 * Creates the temp type colis.
	 *
	 * @return the type colis
	 */
	public static TypeColis createTempTypeColis() {
		return new TypeColis();
	}

	/**
	 * Update type colis.
	 *
	 * @param typeColis the type colis
	 * @param uid the uid
	 */
	public static void updateTypeColis(TypeColis typeColis, int uid) {
		typeColis.setVolume();
		TypeColisDao.update(typeColis, uid);

	}

	/**
	 * Removes the type colis.
	 *
	 * @param uid the uid
	 */
	public static void removeTypeColis(int uid) {
		TypeColis typeColisRemoved = loadTypeColis(uid);
		TypeColisDao.remove(typeColisRemoved);

	}

	/**
	 * Load type colis.
	 *
	 * @param uid the uid
	 * @return the type colis
	 */
	public static TypeColis loadTypeColis(int uid) {
		return TypeColisDao.load(uid);
	}

	/**
	 * Find type colis by name.
	 *
	 * @param typeColisName the type colis name
	 * @return the type colis
	 */
	public static TypeColis findTypeColisByName(String typeColisName) {
		return TypeColisDao.findByName(typeColisName);
	}

	/**
	 * Load all type colis.
	 *
	 * @return the list
	 */
	public static List<TypeColis> loadAllTypeColis() {
		return TypeColisDao.loadAll();
	}

}
