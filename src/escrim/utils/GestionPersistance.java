package escrim.utils;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.Query;

import escrim.metiers.Metier;

public class GestionPersistance {

	private final static Logger logger = Logger
			.getLogger(GestionPersistance.class.getName());

	/**
	 * On rend persistant un objet de la classe metier correspondant
	 * 
	 * @param metier
	 */
	public static void addObjetToDB(Metier metier) {

		EscrimDatabase escrimDatabase = EscrimDatabase.getInstance();
		escrimDatabase.getEm().getTransaction().begin();
		escrimDatabase.getEm().persist(metier);
		escrimDatabase.getEm().getTransaction().commit();
		escrimDatabase.getEm().refresh(metier);

	}

	/**
	 * on récupère l'objet métier qui a la class className et l'uid
	 * 
	 * @param className
	 * @param uid
	 * @return
	 */
	public static Metier getOneObjectFromDB(String className, int uid) {
		EscrimDatabase escrimDatabase = EscrimDatabase.getInstance();

		try {
			Query query = escrimDatabase.getEm().createNativeQuery(
					"SELECT * FROM " + className + " WHERE uid = " + uid,
					Class.forName("escrim.metiers." + className));
			List result = query.getResultList();
			Metier metier = (Metier) result.get(0);
			return metier;
		} catch (ClassNotFoundException e) {
			logger.warning(e.toString()
					+ "\nLa classe n'a pas pu être trouvé !");
			return null;
		}

	}

	/**
	 * On récupère tous les objets métiers à partir du nom de la classe
	 * 
	 * @param className
	 * @return la list des objets Métiers
	 */

	public static List<Metier> getAllObjectFromDB(String className) {
		EscrimDatabase escrimDatabase = EscrimDatabase.getInstance();

		try {
			Query query = escrimDatabase.getEm().createNativeQuery(
					"SELECT * FROM " + className,
					Class.forName("escrim.metiers." + className));
			List<Metier> result = query.getResultList();
			return result;
		} catch (ClassNotFoundException e) {
			logger.warning(e.toString()
					+ "\nLa classe n'a pas pu être trouvé !");
			return null;
		}

	}
}
