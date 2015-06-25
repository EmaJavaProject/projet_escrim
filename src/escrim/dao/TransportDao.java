package escrim.dao;

import java.util.List;

import javax.persistence.Query;

import escrim.metiers.Transport;
import escrim.utils.EscrimDatabase;

public class TransportDao {

	static EscrimDatabase escrimDatabase = EscrimDatabase.getInstance();

	public static void create(Transport Transport) {
		// TODO Auto-generated method stub
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().persist(Transport);
		escrimDatabase.getEm().getTransaction().commit();
	}

	public static void update(Transport TransportUpdated, int uid) {
		Transport Transport = load(uid);
		escrimDatabase.getEm().getTransaction().begin();
		Transport = TransportUpdated;
		escrimDatabase.getEm().getTransaction().commit();

	}

	public static Transport load(int uid) {

		return escrimDatabase.getEm().find(Transport.class, uid);
	}

	public static void remove(Transport TransportRemoved) {
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().remove(TransportRemoved);
		escrimDatabase.getEm().getTransaction().commit();
	}

	public static List<Transport> loadAll() {

		Query query = escrimDatabase.getEm().createNativeQuery(
				"SELECT * FROM Transport", Transport.class);
		List<Transport> listeTransport = query.getResultList();
		return listeTransport;
	}
}
