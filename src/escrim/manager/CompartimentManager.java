package escrim.manager;

import java.util.List;

import escrim.dao.CompartimentDao;
import escrim.metiers.Compartiment;

public class CompartimentManager {

	public static void createCompartiment(Compartiment compartiment) {
		compartiment.setVolume();
		CompartimentDao.create(compartiment);

	}

	public static Compartiment createTempCompartiment() {
		return new Compartiment();
	}

	public static void updateCompartiment(Compartiment compartiment, int uid) {
		compartiment.setVolume();
		CompartimentDao.update(compartiment, uid);

	}

	public static void removeCompartiment(int uid) {
		Compartiment compartimentRemoved = loadCompartiment(uid);
		CompartimentDao.remove(compartimentRemoved);

	}

	public static Compartiment loadCompartiment(int uid) {
		return CompartimentDao.load(uid);

	}

	public static List<Compartiment> loadAllCompartiment() {
		return CompartimentDao.loadAll();
	}

	public static List<Compartiment> loadOutsideTransport(int uidTransport) {
		return CompartimentDao.findCompartimentOutsideTransport(uidTransport);
	}

	public static List<Compartiment> loadByTransport(int uidTransport) {
		return CompartimentDao.findCompartimentIntoTransport(uidTransport);
	}

	public static void fillTransport(int uidTransport, int uidCompartiment) {
		Compartiment compartiment = loadCompartiment(uidCompartiment);

		/*
		 * if
		 * (!TransportManager.loadTransport(uidTransport).getListCompartiment()
		 * .contains(compartiment)) { Transport transport = new Transport();
		 * transport = TransportManager.loadTransport(uidTransport);
		 * transport.addCompartiment(compartiment); }
		 */

		updateCompartiment(compartiment, compartiment.getUid());
	}

	public static void fillOutTransport(int uidTransport, int uidCompartiment) {
		Compartiment compartiment = loadCompartiment(uidCompartiment);
		/*
		 * if
		 * (TransportManager.loadTransport(uidTransport).getListCompartiment()
		 * .contains(compartiment)) { Transport transport = new Transport();
		 * transport = TransportManager.loadTransport(uidTransport);
		 * transport.removeCompartiment(compartiment); }
		 */
		updateCompartiment(compartiment, compartiment.getUid());
	}

}
