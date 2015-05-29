import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class main {

	public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("escrim");
		
		EntityManager em = factory.createEntityManager();
	}

}
