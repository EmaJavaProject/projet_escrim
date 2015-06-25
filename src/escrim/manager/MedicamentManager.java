package escrim.manager;

import java.util.List;

import escrim.dao.MedicamentDao;
import escrim.metiers.Medicament;

public class MedicamentManager {

	public static void createMedicament(Medicament Medicament) {
		MedicamentDao.create(Medicament);

	}

	public static Medicament createTempMedicament() {
		return new Medicament();
	}

	public static void updateMedicament(Medicament Medicament, int uid) {
		MedicamentDao.update(Medicament, uid);

	}

	public static void removeMedicament(int uid) {
		Medicament MedicamentRemoved = loadMedicament(uid);
		MedicamentDao.remove(MedicamentRemoved);

	}

	public static Medicament loadMedicament(int uid) {
		return MedicamentDao.load(uid);

	}

	public static List<Medicament> loadAllMedicament() {
		return MedicamentDao.loadAll();
	}

}
