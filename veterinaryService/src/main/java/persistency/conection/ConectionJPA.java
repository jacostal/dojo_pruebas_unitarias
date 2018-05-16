package persistency.conection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConectionJPA {
	
	private static final String VETERINARY_DB = "veterinary-db";
	private static EntityManagerFactory entityManagerFactory;

	public ConectionJPA() {
		entityManagerFactory = Persistence.createEntityManagerFactory(VETERINARY_DB);
	}
	
	public EntityManager createEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
