package escrim.dao;

import java.util.List;

import javax.persistence.Query;

import escrim.metiers.ConfigurationHopital;
import escrim.utils.EscrimDatabase;

public class ConfigurationHopitalDao {

	static EscrimDatabase escrimDatabase = EscrimDatabase.getInstance();

	public static void create(ConfigurationHopital ConfigurationHopital) {
		// TODO Auto-generated method stub
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().persist(ConfigurationHopital);
		escrimDatabase.getEm().getTransaction().commit();
	}

	public static void update(ConfigurationHopital ConfigurationHopitalUpdated, int uid) {
		ConfigurationHopital ConfigurationHopital = load(uid);
		escrimDatabase.getEm().getTransaction().begin();
		ConfigurationHopital = ConfigurationHopitalUpdated;
		escrimDatabase.getEm().getTransaction().commit();

	}

	public static ConfigurationHopital load(int uid) {

		return escrimDatabase.getEm().find(ConfigurationHopital.class, uid);
	}

	public static void remove(ConfigurationHopital ConfigurationHopitalRemoved) {
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().remove(ConfigurationHopitalRemoved);
		escrimDatabase.getEm().getTransaction().commit();
	}

	public static List<ConfigurationHopital> loadAll() {

		Query query = escrimDatabase.getEm().createNativeQuery(
				"SELECT * FROM ConfigurationHopital", ConfigurationHopital.class);
		List<ConfigurationHopital> listeConfigurationHopital = query.getResultList();
		return listeConfigurationHopital;
	}
}
