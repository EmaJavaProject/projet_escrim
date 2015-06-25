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

}
