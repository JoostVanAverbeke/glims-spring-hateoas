package eu.ten.fingers.glims.controllers;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import eu.ten.fingers.glims.resources.Greeting;

@RunWith(SpringRunner.class)
@WebMvcTest(GreetingController.class)
public class GreetingControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private GreetingController greetingController;
	
	@Test
	public void testGreeting() throws Exception {
		Greeting greetingTrump = new Greeting("Hello, Trump!");
		HttpEntity<Greeting> greetingHttpEntity = new HttpEntity<Greeting>(greetingTrump);
		given(greetingController.greeting("Trump")).willReturn(greetingHttpEntity);
		
		mvc.perform(get("/greeting?name=Trump"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.content", is("Hello, Trump!")));
	}

}
