package escrim.dao;

import java.util.List;

import javax.persistence.Query;

import escrim.metiers.Medicament;
import escrim.utils.EscrimDatabase;

/**
 * The Class MedicamentDao.
 */
public class MedicamentDao {

	/** The escrim database. */
	static EscrimDatabase escrimDatabase = EscrimDatabase.getInstance();

	/**
	 * Creates the.
	 *
	 * @param medicament the medicament
	 */
	public static void create(Medicament medicament) {
		// TODO Auto-generated method stub
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().persist(medicament);
		escrimDatabase.getEm().getTransaction().commit();
	}

	/**
	 * Update.
	 *
	 * @param medicamentUpdated the medicament updated
	 * @param uid the uid
	 */
	public static void update(Medicament medicamentUpdated, int uid) {
		Medicament medicament = load(uid);
		escrimDatabase.getEm().getTransaction().begin();
		medicament = medicamentUpdated;
		escrimDatabase.getEm().getTransaction().commit();

	}

	/**
	 * Load.
	 *
	 * @param uid the uid
	 * @return the medicament
	 */
	public static Medicament load(int uid) {

		return escrimDatabase.getEm().find(Medicament.class, uid);
	}

	/**
	 * Removes the.
	 *
	 * @param medicamentRemoved the medicament removed
	 */
	public static void remove(Medicament medicamentRemoved) {
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().remove(medicamentRemoved);
		escrimDatabase.getEm().getTransaction().commit();
	}

	/**
	 * Load all.
	 *
	 * @return the list
	 */
	public static List<Medicament> loadAll() {

		Query query = escrimDatabase.getEm().createNamedQuery(
				"Medicament.loadAll",
				Medicament.class);
		query.setParameter("type", "Medicament");
		List<Medicament> listeMedicament = query.getResultList();
		return listeMedicament;
	}
}
