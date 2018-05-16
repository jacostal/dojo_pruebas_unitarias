package repository;

import java.util.List;

import domain.repository.DogEntity;

public interface DogRepository {

	void add(DogEntity entity);

	List<DogEntity> getDogByName(String name);

	List<DogEntity> getAllDogs();

}
