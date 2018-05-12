package controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DogControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@Test
	public void shouldReturnAListOfDogs() throws Exception {
		MvcResult result = mockMvc.perform(get("/dog/getDogs")).andReturn();		
		String resultString = result.getResponse().getContentAsString();
		
		assertEquals("", resultString);
		
	}
}
