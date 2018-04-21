package eu.ten.fingers.glims.integrationtests;

import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
public class BasicAuthenticationIntegrationTests {

//	To verify 
//	https://github.com/FutureProcessing/spring-boot-security-example/blob/master/src/test/java/com/futureprocessing/integration/SecurityTest.java
//  https://docs.spring.io/spring-security/site/docs/current/reference/html/test-mockmvc.html
	
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void accessProtected() throws Exception {
        mockMvc.perform(get("/greeting"))
               .andExpect(unauthenticated());
    }

    @Test
    public void loginUser() throws Exception {
        mockMvc.perform(post("/public/users/login")
               .param("username", "Trump")
               .param("password", "Donald")
               .contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk());
       
    }

    @Test
    public void loginUnknownUser() throws Exception {
        mockMvc.perform(post("/public/users/login")
                .param("username", "Dump")
                .param("password", "Donald")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void loginUserInvalidPassword() throws Exception {
        mockMvc.perform(post("/public/users/login")
                .param("username", "Trump")
                .param("password", "Invalid")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }
}