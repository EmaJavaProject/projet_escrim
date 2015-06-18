package escrim.dao;

import escrim.metiers.Compartiment;
import escrim.utils.EscrimDatabase;

public class CompartimentDao {

	public static void create(Compartiment compartiment) {
		// TODO Auto-generated method stub
		EscrimDatabase escrimDatabase = EscrimDatabase.getInstance();
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().persist(compartiment);
		escrimDatabase.getEm().getTransaction().commit();
	}

	public static void update(Compartiment compartimentUpdated, int uid) {
		Compartiment compartiment = load(uid);
		EscrimDatabase escrimDatabase = EscrimDatabase.getInstance();
		escrimDatabase.getEm().getTransaction().begin();
		compartiment = compartimentUpdated;
		escrimDatabase.getEm().getTransaction().commit();

	}

	public static Compartiment load(int uid) {
		EscrimDatabase escrimDatabase = EscrimDatabase.getInstance();
		return escrimDatabase.getEm().find(Compartiment.class, uid);
	}

}
