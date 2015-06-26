package escrim.dao;

import java.util.List;

import javax.persistence.Query;

import escrim.metiers.Materiel;
import escrim.utils.EscrimDatabase;

public class MaterielDao {

	static EscrimDatabase escrimDatabase = EscrimDatabase.getInstance();

	public static void create(Materiel materiel) {
		// TODO Auto-generated method stub
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().persist(materiel);
		escrimDatabase.getEm().getTransaction().commit();
	}

	public static void update(Materiel materielUpdated, int uid) {
		Materiel materiel = load(uid);
		escrimDatabase.getEm().getTransaction().begin();
		materiel = materielUpdated;
		escrimDatabase.getEm().getTransaction().commit();

	}

	public static Materiel load(int uid) {

		return escrimDatabase.getEm().find(Materiel.class, uid);
	}

	public static void remove(Materiel materielRemoved) {
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().remove(materielRemoved);
		escrimDatabase.getEm().getTransaction().commit();
	}

	public static List<Materiel> loadAll() {

		Query query = escrimDatabase.getEm().createNativeQuery(
				"SELECT * FROM Materiel where DTYPE = 'Materiel'",
				Materiel.class);
		List<Materiel> listeMateriel = query.getResultList();
		return listeMateriel;
	}
}
