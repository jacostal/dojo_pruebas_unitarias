package controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.not;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import domain.Dog;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DogControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@Test
	public void shouldReturnStatusOk() {
		try {
			mockMvc.perform(get("/dog/getDogs")).andExpect(status().isOk());	
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void shouldReturnSomeJson() {
		try {
			String result =  mockMvc.perform(get("/dog/getDogs")).andReturn().getResponse().getContentAsString();	
			assertTrue(!result.isEmpty());
			assertThat(is(not(result.isEmpty())));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void shouldReturnAListOfDogs() throws Exception {
		DogController dogController = new DogController();
		List<Dog> dogListExpected = new ArrayList<>();
		Dog dog = new Dog(1l, "llaverito", "pinche", "1980-01-01");
		dogListExpected.add(dog);
		
		List<Dog> dogsList = dogController.getDogs();
		
		assertThat(dogsList, hasItem(Matchers.<Dog>isIn(dogListExpected)));
		assertThat(dogsList, hasItem(new Dog(1l, "llaverito", "pinche", "1980-01-01")));
		assertThat(dogsList, hasItem(Matchers.<Dog>hasProperty("id", equalTo(1L))));
		assertThat(dogsList, hasItem(Matchers.<Dog>hasProperty("name", equalTo("llaverito"))));
		assertThat(dogsList, hasItem(Matchers.<Dog>hasProperty("breed")));
	}
}
