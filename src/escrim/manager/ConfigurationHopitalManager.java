package escrim.manager;

import java.util.List;

import escrim.dao.ConfigurationHopitalDao;
import escrim.metiers.ConfigurationHopital;

/**
 * The Class ConfigurationHopitalManager.
 */
public class ConfigurationHopitalManager {

	/**
	 * Creates the configuration hopital.
	 *
	 * @param ConfigurationHopital
	 *            the configuration hopital
	 */
	public static void createConfigurationHopital(
			ConfigurationHopital ConfigurationHopital) {
		ConfigurationHopitalDao.create(ConfigurationHopital);

	}

	/**
	 * Creates the temp configuration hopital.
	 *
	 * @return the configuration hopital
	 */
	public static ConfigurationHopital createTempConfigurationHopital() {
		return new ConfigurationHopital();
	}

	/**
	 * Update configuration hopital.
	 *
	 * @param ConfigurationHopital
	 *            the configuration hopital
	 * @param uid
	 *            the uid
	 */
	public static void updateConfigurationHopital(
			ConfigurationHopital ConfigurationHopital, int uid) {
		ConfigurationHopitalDao.update(ConfigurationHopital, uid);

	}

	/**
	 * Removes the configuration hopital.
	 *
	 * @param uid
	 *            the uid
	 */
	public static void removeConfigurationHopital(int uid) {
		ConfigurationHopital ConfigurationHopitalRemoved = loadConfigurationHopital(uid);
		ConfigurationHopitalDao.remove(ConfigurationHopitalRemoved);

	}

	/**
	 * Load configuration hopital.
	 *
	 * @param uid
	 *            the uid
	 * @return the configuration hopital
	 */
	public static ConfigurationHopital loadConfigurationHopital(int uid) {
		return ConfigurationHopitalDao.load(uid);

	}

	/**
	 * Load all configuration hopital.
	 *
	 * @return the list
	 */
	public static List<ConfigurationHopital> loadAllConfigurationHopital() {
		return ConfigurationHopitalDao.loadAll();
	}

	public static List<String> loadDistinctConfig() {
		return ConfigurationHopitalDao.loadDistinctConfig();
	}

}
