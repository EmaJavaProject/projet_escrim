package escrim.manager;

import java.util.List;

import escrim.dao.CompartimentDao;
import escrim.metiers.Compartiment;
import escrim.metiers.Transport;

/**
 * The Class CompartimentManager.
 */
public class CompartimentManager {

	/**
	 * Creates the compartiment.
	 *
	 * @param compartiment the compartiment
	 */
	public static void createCompartiment(Compartiment compartiment) {
		compartiment.setVolume();
		CompartimentDao.create(compartiment);

	}

	/**
	 * Creates the temp compartiment.
	 *
	 * @return the compartiment
	 */
	public static Compartiment createTempCompartiment() {
		return new Compartiment();
	}

	/**
	 * Update compartiment.
	 *
	 * @param compartiment the compartiment
	 * @param uid the uid
	 */
	public static void updateCompartiment(Compartiment compartiment, int uid) {
		compartiment.setVolume();
		CompartimentDao.update(compartiment, uid);

	}

	/**
	 * Removes the compartiment.
	 *
	 * @param uid the uid
	 */
	public static void removeCompartiment(int uid) {
		Compartiment compartimentRemoved = loadCompartiment(uid);
		CompartimentDao.remove(compartimentRemoved);

	}

	/**
	 * Load compartiment.
	 *
	 * @param uid the uid
	 * @return the compartiment
	 */
	public static Compartiment loadCompartiment(int uid) {
		return CompartimentDao.load(uid);

	}

	/**
	 * Load all compartiment.
	 *
	 * @return the list
	 */
	public static List<Compartiment> loadAllCompartiment() {
		return CompartimentDao.loadAll();
	}

	/**
	 * Load outside transport.
	 *
	 * @param uidTransport the uid transport
	 * @return the list
	 */
	public static List<Compartiment> loadOutsideTransport(int uidTransport) {
		return CompartimentDao.findCompartimentOutsideTransport(uidTransport);
	}

	/**
	 * Load by transport.
	 *
	 * @param uidTransport the uid transport
	 * @return the list
	 */
	public static List<Compartiment> loadByTransport(int uidTransport) {
		return CompartimentDao.findCompartimentIntoTransport(uidTransport);
	}

	/**
	 * Fill transport.
	 *
	 * @param uidTransport the uid transport
	 * @param uidCompartiment the uid compartiment
	 */
	public static void fillTransport(int uidTransport, int uidCompartiment) {
		Compartiment compartiment = loadCompartiment(uidCompartiment);

		if (compartiment.getTransport() != TransportManager
				.loadTransport(uidTransport)) {
			Transport transport = new Transport();
			transport = TransportManager.loadTransport(uidTransport);
			compartiment.setTransport(transport);
		}
		updateCompartiment(compartiment, compartiment.getUid());
	}

	/**
	 * Fill out transport.
	 *
	 * @param uidTransport the uid transport
	 * @param uidCompartiment the uid compartiment
	 */
	public static void fillOutTransport(int uidTransport, int uidCompartiment) {
		Compartiment compartiment = loadCompartiment(uidCompartiment);

		compartiment.setTransport(null);

		updateCompartiment(compartiment, compartiment.getUid());
	}

}
