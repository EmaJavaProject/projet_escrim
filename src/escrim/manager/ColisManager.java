package escrim.manager;

import java.util.List;

import escrim.dao.ColisDao;
import escrim.metiers.Colis;

public class ColisManager {

	public static void createColis(Colis Colis) {
		ColisDao.create(Colis);

	}

	public static Colis createTempColis() {
		return new Colis();
	}

	public static void updateColis(Colis Colis, int uid) {
		ColisDao.update(Colis, uid);

	}

	public static void removeColis(int uid) {
		Colis ColisRemoved = loadColis(uid);
		ColisDao.remove(ColisRemoved);

	}

	public static Colis loadColis(int uid) {
		return ColisDao.load(uid);

	}

	public static List<Colis> loadAllColis() {
		return ColisDao.loadAll();
	}

}
