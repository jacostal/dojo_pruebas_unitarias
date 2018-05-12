package controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.entity.Dog;

@RestController
public class DogController {

	private static final String PREFIX = "/dog";

	@RequestMapping(PREFIX + "/getDogs")
	public List<Dog> getDogs() {
		
		return null;
	}

}
