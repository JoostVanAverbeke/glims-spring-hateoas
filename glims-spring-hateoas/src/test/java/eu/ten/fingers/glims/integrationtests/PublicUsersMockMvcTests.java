package eu.ten.fingers.glims.integrationtests;

import static org.hamcrest.CoreMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Very good tip: andDo(print()), is very useful!
 * 
 * @author joost
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PublicUsersMockMvcTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void envEndpointNotHidden() throws Exception {
        mockMvc.perform(post("/public/users/login")
        		.param("username", "Trump")
        		.param("password", "Donald")
        		.contentType(MediaType.APPLICATION_JSON))
        		.andExpect(status().isOk())
        		.andExpect(content().contentType("text/plain;charset=UTF-8"))
        		.andExpect(content().string(is(notNullValue())));
    }
}