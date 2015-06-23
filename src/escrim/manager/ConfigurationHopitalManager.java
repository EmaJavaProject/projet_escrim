package escrim.manager;

import java.util.List;

import escrim.dao.ConfigurationHopitalDao;
import escrim.metiers.ConfigurationHopital;


public class ConfigurationHopitalManager {

	public void createConfigurationHopital(String denomination) {
		ConfigurationHopital configHopital = new ConfigurationHopital();
		configHopital.setDenomination(denomination);
		ConfigurationHopitalDao.create(configHopital);
	}

	public void updateConfigurationHopital(int uid, String denomination) {
		ConfigurationHopital tampon = loadConfigurationHopital(uid);
		tampon.setDenomination(denomination);
		ConfigurationHopitalDao.update(tampon, uid);
	}

	public void deleteConfigurationHopital(int uid) {
		ConfigurationHopital configRemoved = loadConfigurationHopital(uid);
		ConfigurationHopitalDao.remove(configRemoved);
	}

	public static ConfigurationHopital loadConfigurationHopital(int uid) {
		return ConfigurationHopitalDao.load(uid);
	}

	public static List<ConfigurationHopital> loadAllConfigurationHopital() {
		return ConfigurationHopitalDao.loadAll();
	}
}
