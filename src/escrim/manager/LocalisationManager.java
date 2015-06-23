package escrim.manager;

import java.util.List;

import escrim.dao.LocalisationDao;
import escrim.metiers.Localisation;

public class LocalisationManager {

	public void createLocalisation(int numeroSector, String nomSector) {
		Localisation localisation = new Localisation();
		localisation.setNumeroSector(numeroSector);
		localisation.setNomSector(nomSector);
		LocalisationDao.create(localisation);
	}

	public void updateLocalisation(int uid, int numeroSector, String nomSector) {
		Localisation tampon = loadLocalisation(uid);
		tampon.setNumeroSector(numeroSector);;
		tampon.setNomSector(nomSector);
		LocalisationDao.update(tampon, uid);
	}

	public void deleteLocalisation(int uid) {
		Localisation localRemoved = loadLocalisation(uid);
		LocalisationDao.remove(localRemoved);
	}

	public static Localisation loadLocalisation(int uid) {
		return LocalisationDao.load(uid);
	}
	
	public static List<Localisation> loadAllLocalisation() {
		return LocalisationDao.loadAll();
	}
}
