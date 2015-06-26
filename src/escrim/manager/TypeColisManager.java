package escrim.manager;

import java.util.List;

import escrim.dao.TypeColisDao;
import escrim.metiers.TypeColis;

public class TypeColisManager {

	public static void createTypeColis(TypeColis typeColis) {
		typeColis.setVolume();
		TypeColisDao.create(typeColis);

	}

	public static TypeColis createTempTypeColis() {
		return new TypeColis();
	}

	public static void updateTypeColis(TypeColis typeColis, int uid) {
		TypeColisDao.update(typeColis, uid);

	}

	public static void removeTypeColis(int uid) {
		TypeColis typeColisRemoved = loadTypeColis(uid);
		TypeColisDao.remove(typeColisRemoved);

	}

	public static TypeColis loadTypeColis(int uid) {
		return TypeColisDao.load(uid);
	}

	public static TypeColis findTypeColisByName(String typeColisName) {
		return TypeColisDao.findByName(typeColisName);
	}

	public static List<TypeColis> loadAllTypeColis() {
		return TypeColisDao.loadAll();
	}

}
