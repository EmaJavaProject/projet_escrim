package escrim.manager;

import java.util.List;

import escrim.dao.TransportDao;
import escrim.metiers.Transport;

public class TransportManager {

	public static void createTransport(Transport Transport) {
		TransportDao.create(Transport);

	}

	public static Transport createTempTransport() {
		return new Transport();
	}

	public static void updateTransport(Transport Transport, int uid) {
		TransportDao.update(Transport, uid);

	}

	public static void removeTransport(int uid) {
		Transport TransportRemoved = loadTransport(uid);
		TransportDao.remove(TransportRemoved);

	}

	public static Transport loadTransport(int uid) {
		return TransportDao.load(uid);

	}

	public static List<Transport> loadAllTransport() {
		return TransportDao.loadAll();
	}

}
