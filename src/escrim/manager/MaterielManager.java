package escrim.manager;

import java.util.List;

import escrim.dao.MaterielDao;
import escrim.metiers.Materiel;

/**
 * The Class MaterielManager.
 */
public class MaterielManager {

	/**
	 * Creates the materiel.
	 *
	 * @param Materiel
	 *            the materiel
	 */
	public static void createMateriel(Materiel Materiel) {
		MaterielDao.create(Materiel);
	}

	/**
	 * Creates the temp materiel.
	 *
	 * @return the materiel
	 */
	public static Materiel createTempMateriel() {
		return new Materiel();
	}

	/**
	 * Update materiel.
	 *
	 * @param materiel
	 *            the materiel
	 * @param uid
	 *            the uid
	 */
	public static void updateMateriel(Materiel materiel, int uid) {
		MaterielDao.update(materiel, uid);

	}

	/**
	 * Removes the materiel.
	 *
	 * @param uid
	 *            the uid
	 */
	public static void removeMateriel(int uid) {
		Materiel materielRemoved = loadMateriel(uid);
		MaterielDao.remove(materielRemoved);

	}

	/**
	 * Load materiel.
	 *
	 * @param uid
	 *            the uid
	 * @return the materiel
	 */
	public static Materiel loadMateriel(int uid) {
		return MaterielDao.load(uid);

	}

	/**
	 * Load all materiel.
	 *
	 * @return the list
	 */
	public static List<Materiel> loadAllMateriel() {
		return MaterielDao.loadAll();
	}

	/**
	 * Load outside colis.
	 *
	 * @param uidColis
	 *            the uid colis
	 * @return the list
	 */
	public static List<Materiel> loadOutsideColis(int uidColis) {
		return MaterielDao.findMaterielOustideColis(uidColis);
	}

	/**
	 * Load by colis.
	 *
	 * @param uidColis
	 *            the uid colis
	 * @return the list
	 */
	public static List<Materiel> loadByColis(int uidColis) {
		return MaterielDao.findMaterielIntoColis(uidColis);
	}

}
