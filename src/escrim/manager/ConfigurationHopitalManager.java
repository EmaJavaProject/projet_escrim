package escrim.manager;

import java.util.List;

import escrim.dao.ConfigurationHopitalDao;
import escrim.metiers.ConfigurationHopital;

public class ConfigurationHopitalManager {

	public static void createConfigurationHopital(ConfigurationHopital ConfigurationHopital) {
		ConfigurationHopitalDao.create(ConfigurationHopital);

	}

	public static ConfigurationHopital createTempConfigurationHopital() {
		return new ConfigurationHopital();
	}

	public static void updateConfigurationHopital(ConfigurationHopital ConfigurationHopital, int uid) {
		ConfigurationHopitalDao.update(ConfigurationHopital, uid);

	}

	public static void removeConfigurationHopital(int uid) {
		ConfigurationHopital ConfigurationHopitalRemoved = loadConfigurationHopital(uid);
		ConfigurationHopitalDao.remove(ConfigurationHopitalRemoved);

	}

	public static ConfigurationHopital loadConfigurationHopital(int uid) {
		return ConfigurationHopitalDao.load(uid);

	}

	public static List<ConfigurationHopital> loadAllConfigurationHopital() {
		return ConfigurationHopitalDao.loadAll();
	}

}
