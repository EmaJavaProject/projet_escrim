package escrim.manager;

import java.util.List;

import escrim.dao.MaterielDao;
import escrim.metiers.Colis;
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

	public static List<Materiel> loadOutsideColis(int uidColis) {
		return MaterielDao.findMaterielOustideColis(uidColis);
	}

	public static List<Materiel> loadByColis(int uidColis) {
		return MaterielDao.findMaterielIntoColis(uidColis);
	}

	public static void fillColis(int uidColis, int uidMateriel) {
		Materiel materiel = loadMateriel(uidMateriel);
		if (materiel.getColis() != ColisManager.loadColis(uidColis)) {
			Colis colis = new Colis();
			colis = ColisManager.loadColis(uidColis);
			materiel.setColis(colis);
		}

		updateMateriel(materiel, materiel.getUid());
	}

	public static void fillOutColis(int uidColis, int uidMateriel) {
		Materiel materiel = loadMateriel(uidMateriel);
		materiel.setColis(null);
		updateMateriel(materiel, materiel.getUid());
	}

}
