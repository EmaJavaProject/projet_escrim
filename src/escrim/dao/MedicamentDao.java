package escrim.dao;

import java.util.List;

import javax.persistence.Query;

import escrim.metiers.Medicament;
import escrim.utils.EscrimDatabase;

public class MedicamentDao {

	static EscrimDatabase escrimDatabase = EscrimDatabase.getInstance();

	public static void create(Medicament medicament) {
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().persist(medicament);
		escrimDatabase.getEm().getTransaction().commit();
	}

	public static void update(Medicament medicamentUpdated, int uid) {
		Medicament medicament = load(uid);
		escrimDatabase.getEm().getTransaction().begin();
		medicament = medicamentUpdated;
		escrimDatabase.getEm().getTransaction().commit();

	}

	public static Medicament load(int uid) {

		return escrimDatabase.getEm().find(Medicament.class, uid);
	}

	public static void remove(Medicament medicamentRemoved) {
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().remove(medicamentRemoved);
		escrimDatabase.getEm().getTransaction().commit();
	}

	public static List<Medicament> loadAll() {

		Query query = escrimDatabase.getEm().createNativeQuery(
				"SELECT * FROM medicament", Medicament.class);
		List<Medicament> listeMedicament = query.getResultList();
		return listeMedicament;
	}
}
