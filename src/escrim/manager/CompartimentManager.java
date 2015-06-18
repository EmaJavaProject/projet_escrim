package escrim.manager;

import java.util.List;

import escrim.dao.CompartimentDao;
import escrim.metiers.Colis;
import escrim.metiers.Compartiment;
import escrim.utils.EscrimDatabase;

public class CompartimentManager {

	public static void createCompartiment(float hauteur, float largeur,
			float longueur, float volume, float poids,
			List<Colis> colisDansCompartiment) {
		Compartiment compartiment = new Compartiment();
		compartiment.setHauteur(hauteur);
		compartiment.setLargeur(largeur);
		compartiment.setLongueur(longueur);
		compartiment.setListeColisDansCompartiment(colisDansCompartiment);
		compartiment.setVolume(volume);
		CompartimentDao.create(compartiment);

	}

	public static void updateCompartiment(int uid, float hauteur,
			float largeur, float longueur, float volume, float poids,
			List<Colis> colisDansCompartiment) {

		Compartiment tempon = loadCompartiment(uid);
		tempon.setHauteur(hauteur);
		tempon.setLargeur(largeur);
		tempon.setLongueur(longueur);
		tempon.setListeColisDansCompartiment(colisDansCompartiment);
		tempon.setVolume(volume);
		CompartimentDao.update(tempon, uid);

	}

	public void deleteCompartiment(int uid) {

	}

	public static Compartiment loadCompartiment(int uid) {
		Compartiment compartiment = EscrimDatabase.getInstance().getEm()
				.find(Compartiment.class, uid);
		return compartiment;

	}

}
