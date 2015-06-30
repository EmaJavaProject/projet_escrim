package escrim.manager;

import java.util.List;

import escrim.dao.ColisDao;
import escrim.metiers.Colis;
import escrim.metiers.TypeColis;

public class ColisManager {

	public static void createColis(Colis colis) {
		TypeColis typeColis = new TypeColis();
		typeColis = TypeColisManager.findTypeColisByName(colis.getTypeColis()
				.getDesignation());
		colis.setTypeColis(typeColis);
		ColisDao.create(colis);

	}

	public static Colis createTempColis() {
		return new Colis();
	}

	public static void updateColis(Colis colis, int uid) {

		if (loadColis(uid).getTypeColis().getDesignation() != colis
				.getTypeColis().getDesignation()) {
			TypeColis typeColis = new TypeColis();
			typeColis = TypeColisManager.findTypeColisByName(colis
					.getTypeColis().getDesignation());
			colis.setTypeColis(typeColis);
		}
		ColisDao.update(colis, uid);

	}

	public static void removeColis(int uid) {
		Colis colisRemoved = loadColis(uid);
		ColisDao.remove(colisRemoved);

	}

	public static Colis loadColis(int uid) {
		return ColisDao.load(uid);

	}

	public static List<Colis> loadAllColis() {
		return ColisDao.loadAll();
	}

}
