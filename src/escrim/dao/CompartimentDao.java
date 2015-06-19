package escrim.dao;

import java.util.List;

import javax.persistence.Query;

import escrim.metiers.Compartiment;
import escrim.utils.EscrimDatabase;

public class CompartimentDao {

	static EscrimDatabase escrimDatabase = EscrimDatabase.getInstance();

	public static void create(Compartiment compartiment) {
		// TODO Auto-generated method stub
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().persist(compartiment);
		escrimDatabase.getEm().getTransaction().commit();
	}

	public static void update(Compartiment compartimentUpdated, int uid) {
		Compartiment compartiment = load(uid);
		escrimDatabase.getEm().getTransaction().begin();
		compartiment = compartimentUpdated;
		escrimDatabase.getEm().getTransaction().commit();

	}

	public static Compartiment load(int uid) {

		return escrimDatabase.getEm().find(Compartiment.class, uid);
	}

	public static void remove(Compartiment compartimentRemoved) {
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().remove(compartimentRemoved);
		escrimDatabase.getEm().getTransaction().commit();
	}

	public static List<Compartiment> loadAll() {

		Query query = escrimDatabase.getEm().createNativeQuery(
				"SELECT * FROM compartiment", Compartiment.class);
		List<Compartiment> listeCompartiment = query.getResultList();
		return listeCompartiment;
	}
}
