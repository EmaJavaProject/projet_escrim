package escrim.manager;

import java.util.List;

import escrim.dao.CompartimentDao;
import escrim.metiers.Compartiment;
import escrim.metiers.Transport;

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

		if (compartiment.getTransport() != TransportManager
				.loadTransport(uidTransport)) {
			Transport transport = new Transport();
			transport = TransportManager.loadTransport(uidTransport);
			compartiment.setTransport(transport);
		}
		updateCompartiment(compartiment, compartiment.getUid());
	}

	public static void fillOutTransport(int uidTransport, int uidCompartiment) {
		Compartiment compartiment = loadCompartiment(uidCompartiment);

		compartiment.setTransport(null);

		updateCompartiment(compartiment, compartiment.getUid());
	}

}
