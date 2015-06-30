package escrim.dao;

import java.util.List;

import javax.persistence.Query;

import escrim.metiers.Materiel;
import escrim.utils.EscrimDatabase;

/**
 * The Class MaterielDao.
 */
public class MaterielDao {

	/** The escrim database. */
	static EscrimDatabase escrimDatabase = EscrimDatabase.getInstance();

	/**
	 * Creates the materiel.
	 *
	 * @param materiel the materiel
	 */
	public static void create(Materiel materiel) {
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().persist(materiel);
		escrimDatabase.getEm().getTransaction().commit();
	}

	/**
	 * Update.
	 *
	 * @param materielUpdated the materiel updated
	 * @param uid the uid
	 */
	public static void update(Materiel materielUpdated, int uid) {
		Materiel materiel = load(uid);
		escrimDatabase.getEm().getTransaction().begin();
		if (materiel != materielUpdated) {
			materiel = materielUpdated;
		}
		escrimDatabase.getEm().getTransaction().commit();

	}

	/**
	 * Load.
	 *
	 * @param uid the uid
	 * @return the materiel
	 */
	public static Materiel load(int uid) {

		return escrimDatabase.getEm().find(Materiel.class, uid);
	}

	/**
	 * Removes the materiel.
	 *
	 * @param materielRemoved the materiel removed
	 */
	public static void remove(Materiel materielRemoved) {
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().remove(materielRemoved);
		escrimDatabase.getEm().getTransaction().commit();
	}

	/**
	 * Load all.
	 *
	 * @return the list
	 */
	public static List<Materiel> loadAll() {
		Query query = escrimDatabase.getEm().createNativeQuery(
				"SELECT * FROM Materiel where DTYPE = 'Materiel'",
				Materiel.class);
		List<Materiel> listeMateriel = query.getResultList();
		return listeMateriel;
	}

	/**
	 * Find materiel into colis.
	 *
	 * @param uidColis the uid colis
	 * @return the list
	 */
	public static List<Materiel> findMaterielIntoColis(int uidColis) {
		Query query = escrimDatabase.getEm().createNativeQuery(
				"SELECT * FROM Materiel where COLIS_UID = " + uidColis + "",
				Materiel.class);
		List<Materiel> listeMateriel = query.getResultList();
		return listeMateriel;

	}

	/**
	 * Find materiel oustide colis.
	 *
	 * @param uidColis the uid colis
	 * @return the list
	 */
	public static List<Materiel> findMaterielOustideColis(int uidColis) {
		Query query = escrimDatabase.getEm().createNativeQuery(
				"SELECT * FROM Materiel where COLIS_UID is NULL",
				Materiel.class);
		List<Materiel> listeAllMateriel = query.getResultList();
		return listeAllMateriel;
	}
}
