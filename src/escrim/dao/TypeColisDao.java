package escrim.dao;

import java.util.List;

import javax.persistence.Query;

import escrim.metiers.TypeColis;
import escrim.utils.EscrimDatabase;

public class TypeColisDao {

	static EscrimDatabase escrimDatabase = EscrimDatabase.getInstance();

	public static void create(TypeColis typeColis) {
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().persist(typeColis);
		escrimDatabase.getEm().getTransaction().commit();
	}

	public static void update(TypeColis typeColisUpdated, int uid) {
		TypeColis typeColis = load(uid);
		escrimDatabase.getEm().getTransaction().begin();
		typeColis = typeColisUpdated;
		escrimDatabase.getEm().getTransaction().commit();

	}

	public static TypeColis load(int uid) {

		return escrimDatabase.getEm().find(TypeColis.class, uid);
	}

	public static void remove(TypeColis typeColisRemoved) {
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().remove(typeColisRemoved);
		escrimDatabase.getEm().getTransaction().commit();
	}

	public static TypeColis findByName(String typeColisName) {
		Query query = escrimDatabase.getEm().createNativeQuery(
				"SELECT * FROM TypeColis where Designation= \'" + typeColisName
						+ "\'", TypeColis.class);
		TypeColis typeColis = (TypeColis) query.getResultList().get(0);
		return typeColis;
	}

	public static List<TypeColis> loadAll() {

		Query query = escrimDatabase.getEm().createNativeQuery(
				"SELECT * FROM TypeColis", TypeColis.class);
		List<TypeColis> listeTypeColis = query.getResultList();
		return listeTypeColis;
	}
}
