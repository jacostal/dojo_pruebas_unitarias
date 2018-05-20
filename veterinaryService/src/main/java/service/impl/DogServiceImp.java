package service.impl;

import java.util.ArrayList;
import java.util.List;

import domain.Dog;
import domain.repository.DogEntity;
import persistency.system.PersistenceSystem;
import repository.DogRepository;
import service.DogService;

public class DogServiceImp implements DogService{
	
	private DogRepository dogRepository;
	
	public DogServiceImp() {
		PersistenceSystem persistenceSystem = new PersistenceSystem();
		dogRepository = persistenceSystem.getDogRepository();
	}
	
	
	@Override
	public List<Dog> getAllDogs(){
		List<Dog> dogEntityList = new ArrayList<>();
		for (DogEntity dogEntity : dogRepository.getAllDogs()) {
			dogEntityList.add(new Dog(dogEntity.getId(), dogEntity.getName(), dogEntity.getBreed(), dogEntity.getDateOfBirth()));
		}
		return dogEntityList;
	}

}
