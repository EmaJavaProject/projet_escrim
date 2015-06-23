package escrim.dao;

import java.util.List;

import javax.persistence.Query;

import escrim.metiers.ConfigurationHopital;
import escrim.utils.EscrimDatabase;

public class ConfigurationHopitalDao {
	static EscrimDatabase escrimDatabase = EscrimDatabase.getInstance();

	public static void create(ConfigurationHopital configHopital) {

		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().persist(configHopital);
		escrimDatabase.getEm().getTransaction().commit();
	}

	public static void update(ConfigurationHopital configHopitalUpdated, int uid) {
		ConfigurationHopital config = load(uid);
		escrimDatabase.getEm().getTransaction().begin();
		config = configHopitalUpdated;
		escrimDatabase.getEm().getTransaction().commit();

	}

	public static ConfigurationHopital load(int uid) {

		return escrimDatabase.getEm().find(ConfigurationHopital.class, uid);
	}

	public static void remove(ConfigurationHopital configHopitalRemoved) {
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().remove(configHopitalRemoved);
		escrimDatabase.getEm().getTransaction().commit();
	}

	public static List<ConfigurationHopital> loadAll() {

		Query query = escrimDatabase.getEm().createNativeQuery(
				"SELECT * FROM configurationhopital", ConfigurationHopital.class);
		List<ConfigurationHopital> listeConfigHopital = query.getResultList();
		return listeConfigHopital;
	}
}
