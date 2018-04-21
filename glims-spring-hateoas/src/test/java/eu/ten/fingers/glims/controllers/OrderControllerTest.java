package eu.ten.fingers.glims.controllers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import eu.ten.fingers.glims.repositories.MockOrderRepository;
import eu.ten.fingers.glims.repositories.OrderRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = OrderController.class, secure = false)
public class OrderControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OrderRepository orderRepository;
	
	@Test
	public void testAll() throws Exception {
		given(orderRepository.findAll()).willReturn(new MockOrderRepository().findAll());
		mockMvc.perform(get("/orders")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}

	@Test
	public void testGet() throws Exception {
		given(orderRepository.findById(1L)).willReturn(new MockOrderRepository().findById(1L));
		mockMvc.perform(get("/orders/1")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}
	
	@Test
	public void testGet_UnknownOrder() throws Exception {
		given(orderRepository.findById(1L)).willReturn(null);
		mockMvc.perform(get("/orders/1")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().is4xxClientError());
	}
	

}
