package controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.Dog;
import service.DogService;
import service.impl.DogServiceImp;

@RestController
public class DogController {

	private static final String PREFIX = "/dog";
	
	private static DogService dogService = new DogServiceImp();

	@RequestMapping(PREFIX + "/getDogs")
	public List<Dog> getDogs() {
		return dogService.getAllDogs();
	}

}
