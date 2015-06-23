package escrim.dao;

import java.util.List;

import javax.persistence.Query;

import escrim.metiers.Localisation;
import escrim.utils.EscrimDatabase;

public class LocalisationDao {
	static EscrimDatabase escrimDatabase = EscrimDatabase.getInstance();

	public static void create(Localisation localisation) {

		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().persist(localisation);
		escrimDatabase.getEm().getTransaction().commit();
	}

	public static void update(Localisation localisationUpdated, int uid) {
		Localisation localisation = load(uid);
		escrimDatabase.getEm().getTransaction().begin();
		localisation = localisationUpdated;
		escrimDatabase.getEm().getTransaction().commit();

	}

	public static Localisation load(int uid) {

		return escrimDatabase.getEm().find(Localisation.class, uid);
	}

	public static void remove(Localisation localisationRemoved) {
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().remove(localisationRemoved);
		escrimDatabase.getEm().getTransaction().commit();
	}

	public static List<Localisation> loadAll() {

		Query query = escrimDatabase.getEm().createNativeQuery(
				"SELECT * FROM localisation", Localisation.class);
		List<Localisation> listeLocalisation = query.getResultList();
		return listeLocalisation;
	}
}
