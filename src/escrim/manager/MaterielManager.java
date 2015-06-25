package escrim.manager;

import java.util.List;

import escrim.dao.MaterielDao;
import escrim.metiers.Materiel;

public class MaterielManager {

	public static void createMateriel(Materiel Materiel) {
		MaterielDao.create(Materiel);

	}

	public static Materiel createTempMateriel() {
		return new Materiel();
	}

	public static void updateMateriel(Materiel materiel, int uid) {
		MaterielDao.update(materiel, uid);

	}

	public static void removeMateriel(int uid) {
		Materiel materielRemoved = loadMateriel(uid);
		MaterielDao.remove(materielRemoved);

	}

	public static Materiel loadMateriel(int uid) {
		return MaterielDao.load(uid);

	}

	public static List<Materiel> loadAllMateriel() {
		return MaterielDao.loadAll();
	}

}
