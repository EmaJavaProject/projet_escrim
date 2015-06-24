package escrim.manager;

import java.util.List;

import escrim.dao.MaterielDao;
import escrim.metiers.Materiel;

public class MaterielManager {

	public static void createMateriel(String denomination, String observation, int quantite) {
		Materiel materiel = new Materiel();
		materiel.setDenomination(denomination);
		materiel.setObservations(observation);
		materiel.setQuantite(quantite);
		MaterielDao.create(materiel);
	}

	public static void updateMateriel(int uid, String denomination, String observation, int quantite) {
		Materiel materielTemporaire = loadMateriel(uid);
		materielTemporaire.setDenomination(denomination);
		materielTemporaire.setObservations(observation);
		materielTemporaire.setQuantite(quantite);
		MaterielDao.update(materielTemporaire, uid);
	}

	public static void deleteMateriel(int uid) {
		Materiel deleteMateriel = loadMateriel(uid);
		MaterielDao.remove(deleteMateriel);
	}

	public static Materiel loadMateriel(int uid) {
		return MaterielDao.load(uid);
	}
	public static List<Materiel> loadAllMateriels(){
		return MaterielDao.loadAll();
	}

}
