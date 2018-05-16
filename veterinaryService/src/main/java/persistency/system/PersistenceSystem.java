package persistency.system;

import javax.persistence.EntityManager;

import persistency.conection.ConectionJPA;
import repository.DogRepository;
import repository.imp.DogRepositoryImp;

public class PersistenceSystem {

	private EntityManager entityManager;

	public PersistenceSystem() {
		this.entityManager = new ConectionJPA().createEntityManager();
	}

	public DogRepository getDogRepository() {
		return new DogRepositoryImp(entityManager);
	}
	

	public void iniciar() {
		entityManager.getTransaction().begin();
	}

	public void terminar() {
		entityManager.getTransaction().commit();
	}
}
