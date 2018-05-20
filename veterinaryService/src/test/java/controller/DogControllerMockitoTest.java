package controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import domain.Dog;
import domain.repository.DogEntity;
import repository.DogRepository;
import service.DogService;
import service.impl.DogServiceImp;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DogControllerMockitoTest {
	
	private DogController dogController = new DogController();
	@InjectMocks private DogService dogService = new DogServiceImp();
	@Mock private DogRepository dogRepository;

	
	@Before
	public void initMocks() {
		ReflectionTestUtils.setField(dogController, "dogService", dogService);
		ReflectionTestUtils.setField(dogService, "dogRepository", dogRepository);
	}
	
	@Test
	public void shouldReturnAListOfDogs() throws Exception {
		List<Dog> dogListExpected = new ArrayList<>();
		Dog dog = new Dog(99l, "dogMocked", "pitbull", "2018-01-01");
		dogListExpected.add(dog);
		
		List<DogEntity> dogListMocked = new ArrayList<>();
		DogEntity dogEntity = new DogEntity(99l, "dogMocked", "pitbull", "2018-01-01");
		dogListMocked.add(dogEntity);
		
		Mockito.when(dogRepository.getAllDogs()).thenReturn(dogListMocked);
		
		List<Dog> dogsList = dogController.getDogs();
		
		assertThat(dogsList, hasItem(Matchers.<Dog>isIn(dogListExpected)));
		assertThat(dogsList, hasItem(new Dog(99l, "dogMocked", "pitbull", "2018-01-01")));
		assertThat(dogsList, hasItem(Matchers.<Dog>hasProperty("id", equalTo(99L))));
		assertThat(dogsList, hasItem(Matchers.<Dog>hasProperty("name", equalTo("dogMocked"))));
		assertThat(dogsList, hasItem(Matchers.<Dog>hasProperty("breed")));
	}
	
	
}
