package escrim.dao;

import java.util.List;

import javax.persistence.Query;

import escrim.metiers.Transport;
import escrim.utils.EscrimDatabase;

/**
 * The Class TransportDao.
 */
public class TransportDao {

	/** The escrim database. */
	static EscrimDatabase escrimDatabase = EscrimDatabase.getInstance();

	/**
	 * Creates the.
	 *
	 * @param Transport the transport
	 */
	public static void create(Transport Transport) {
		// TODO Auto-generated method stub
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().persist(Transport);
		escrimDatabase.getEm().getTransaction().commit();
	}

	/**
	 * Update.
	 *
	 * @param TransportUpdated the transport updated
	 * @param uid the uid
	 */
	public static void update(Transport TransportUpdated, int uid) {
		Transport Transport = load(uid);
		escrimDatabase.getEm().getTransaction().begin();
		Transport = TransportUpdated;
		escrimDatabase.getEm().getTransaction().commit();

	}

	/**
	 * Load.
	 *
	 * @param uid the uid
	 * @return the transport
	 */
	public static Transport load(int uid) {

		return escrimDatabase.getEm().find(Transport.class, uid);
	}

	/**
	 * Removes the.
	 *
	 * @param TransportRemoved the transport removed
	 */
	public static void remove(Transport TransportRemoved) {
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().remove(TransportRemoved);
		escrimDatabase.getEm().getTransaction().commit();
	}

	/**
	 * Load all.
	 *
	 * @return the list
	 */
	public static List<Transport> loadAll() {

		Query query = escrimDatabase.getEm().createNativeQuery(
				"SELECT * FROM Transport", Transport.class);
		List<Transport> listeTransport = query.getResultList();
		return listeTransport;
	}
}
