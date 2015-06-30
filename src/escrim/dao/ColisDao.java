package escrim.dao;

import java.util.List;

import javax.persistence.Query;

import escrim.metiers.Colis;
import escrim.utils.EscrimDatabase;

public class ColisDao {

	static EscrimDatabase escrimDatabase = EscrimDatabase.getInstance();

	public static void create(Colis Colis) {
		// TODO Auto-generated method stub
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().persist(Colis);
		escrimDatabase.getEm().getTransaction().commit();
	}

	public static void update(Colis ColisUpdated, int uid) {
		Colis Colis = load(uid);
		escrimDatabase.getEm().getTransaction().begin();
		Colis = ColisUpdated;
		escrimDatabase.getEm().getTransaction().commit();

	}

	public static Colis load(int uid) {

		return escrimDatabase.getEm().find(Colis.class, uid);
	}

	public static void remove(Colis ColisRemoved) {
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().remove(ColisRemoved);
		escrimDatabase.getEm().getTransaction().commit();
	}

	public static List<Colis> loadAll() {

		Query query = escrimDatabase.getEm().createNativeQuery(
				"SELECT * FROM Colis", Colis.class);
		List<Colis> listeColis = query.getResultList();
		return listeColis;
	}
}
