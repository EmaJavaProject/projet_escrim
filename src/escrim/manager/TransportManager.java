package escrim.manager;

import java.util.List;

import escrim.dao.TransportDao;
import escrim.metiers.Transport;

/**
 * The Class TransportManager.
 */
public class TransportManager {

	/**
	 * Creates the transport.
	 *
	 * @param Transport the transport
	 */
	public static void createTransport(Transport Transport) {
		TransportDao.create(Transport);

	}

	/**
	 * Creates the temp transport.
	 *
	 * @return the transport
	 */
	public static Transport createTempTransport() {
		return new Transport();
	}

	/**
	 * Update transport.
	 *
	 * @param Transport the transport
	 * @param uid the uid
	 */
	public static void updateTransport(Transport Transport, int uid) {
		TransportDao.update(Transport, uid);

	}

	/**
	 * Removes the transport.
	 *
	 * @param uid the uid
	 */
	public static void removeTransport(int uid) {
		Transport TransportRemoved = loadTransport(uid);
		TransportDao.remove(TransportRemoved);

	}

	/**
	 * Load transport.
	 *
	 * @param uid the uid
	 * @return the transport
	 */
	public static Transport loadTransport(int uid) {
		return TransportDao.load(uid);

	}

	/**
	 * Load all transport.
	 *
	 * @return the list
	 */
	public static List<Transport> loadAllTransport() {
		return TransportDao.loadAll();
	}

}
