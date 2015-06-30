package escrim.dao;

import java.util.List;

import javax.persistence.Query;

import escrim.metiers.TypeColis;
import escrim.utils.EscrimDatabase;

/**
 * The Class TypeColisDao.
 */
public class TypeColisDao {

	/** The escrim database. */
	static EscrimDatabase escrimDatabase = EscrimDatabase.getInstance();

	/**
	 * Creates the.
	 *
	 * @param typeColis the type colis
	 */
	public static void create(TypeColis typeColis) {
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().persist(typeColis);
		escrimDatabase.getEm().getTransaction().commit();
	}

	/**
	 * Update.
	 *
	 * @param typeColisUpdated the type colis updated
	 * @param uid the uid
	 */
	public static void update(TypeColis typeColisUpdated, int uid) {
		TypeColis typeColis = load(uid);
		escrimDatabase.getEm().getTransaction().begin();
		typeColis = typeColisUpdated;
		escrimDatabase.getEm().getTransaction().commit();

	}

	/**
	 * Load.
	 *
	 * @param uid the uid
	 * @return the type colis
	 */
	public static TypeColis load(int uid) {

		return escrimDatabase.getEm().find(TypeColis.class, uid);
	}

	/**
	 * Removes the TypeColis.
	 *
	 * @param typeColisRemoved the type colis removed
	 */
	public static void remove(TypeColis typeColisRemoved) {
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().remove(typeColisRemoved);
		escrimDatabase.getEm().getTransaction().commit();
	}

	/**
	 * Find by name.
	 *
	 * @param typeColisName the type colis name
	 * @return the type colis
	 */
	public static TypeColis findByName(String typeColisName) {
		Query query = escrimDatabase.getEm().createNativeQuery(
				"SELECT * FROM TypeColis where Designation= \'" + typeColisName
						+ "\'", TypeColis.class);
		TypeColis typeColis = (TypeColis) query.getResultList().get(0);
		return typeColis;
	}

	/**
	 * Load all.
	 *
	 * @return the list
	 */
	public static List<TypeColis> loadAll() {

		Query query = escrimDatabase.getEm().createNativeQuery(
				"SELECT * FROM TypeColis", TypeColis.class);
		List<TypeColis> listeTypeColis = query.getResultList();
		return listeTypeColis;
	}
}
