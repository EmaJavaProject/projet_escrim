package escrim.manager;

import java.util.List;

import escrim.dao.MedicamentDao;
import escrim.metiers.Medicament;

/**
 * The Class MedicamentManager.
 */
public class MedicamentManager {

	/**
	 * Creates the medicament.
	 *
	 * @param Medicament the medicament
	 */
	public static void createMedicament(Medicament Medicament) {
		MedicamentDao.create(Medicament);

	}

	/**
	 * Creates the temp medicament.
	 *
	 * @return the medicament
	 */
	public static Medicament createTempMedicament() {
		return new Medicament();
	}

	/**
	 * Update medicament.
	 *
	 * @param Medicament the medicament
	 * @param uid the uid
	 */
	public static void updateMedicament(Medicament Medicament, int uid) {
		MedicamentDao.update(Medicament, uid);

	}

	/**
	 * Removes the medicament.
	 *
	 * @param uid the uid
	 */
	public static void removeMedicament(int uid) {
		Medicament MedicamentRemoved = loadMedicament(uid);
		MedicamentDao.remove(MedicamentRemoved);

	}

	/**
	 * Load medicament.
	 *
	 * @param uid the uid
	 * @return the medicament
	 */
	public static Medicament loadMedicament(int uid) {
		return MedicamentDao.load(uid);

	}

	/**
	 * Load all medicament.
	 *
	 * @return the list
	 */
	public static List<Medicament> loadAllMedicament() {
		return MedicamentDao.loadAll();
	}

}
