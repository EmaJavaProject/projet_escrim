package escrim.manager;

import java.util.List;

import escrim.dao.CompartimentDao;
import escrim.metiers.Colis;
import escrim.metiers.Compartiment;

public class CompartimentManager {

	public static void createCompartiment(float hauteur, float largeur,
			float longueur, float poids, List<Colis> colisDansCompartiment) {
		Compartiment compartiment = new Compartiment();
		compartiment.setHauteur(hauteur);
		compartiment.setLargeur(largeur);
		compartiment.setLongueur(longueur);
		compartiment.setListeColisDansCompartiment(colisDansCompartiment);
		compartiment.setVolume();
		CompartimentDao.create(compartiment);

	}

	public static Compartiment createTempCompartiment() {
		return new Compartiment();
	}

	public static void updateCompartiment(int uid, float hauteur,
			float largeur, float longueur, float poids,
			List<Colis> colisDansCompartiment) {

		Compartiment tempon = loadCompartiment(uid);
		tempon.setHauteur(hauteur);
		tempon.setLargeur(largeur);
		tempon.setLongueur(longueur);
		tempon.setListeColisDansCompartiment(colisDansCompartiment);
		tempon.setVolume();
		CompartimentDao.update(tempon, uid);

	}

	public void removeCompartiment(int uid) {
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
