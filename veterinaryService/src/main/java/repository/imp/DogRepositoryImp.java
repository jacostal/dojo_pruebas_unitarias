package repository.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import domain.repository.DogEntity;
import repository.DogRepository;

public class DogRepositoryImp implements DogRepository {

	private static final String NAME = "name";
	private static final String QUERY_DOG_BY_NAME = "Dog.findByName";
	private static final String QUERY_ALL_DOGS = "Dog.findAll";
	
	private EntityManager entityManager;

	public DogRepositoryImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}	

	@Override
	public void add(DogEntity entity) {
		
		entityManager.persist(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DogEntity> getDogByName(String name) {
		
		Query query = entityManager.createNamedQuery(QUERY_DOG_BY_NAME);
		query.setParameter(NAME, name);
		return query.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<DogEntity> getAllDogs() {
		
		Query query = entityManager.createNamedQuery(QUERY_ALL_DOGS);
		return query.getResultList();
	}

}
