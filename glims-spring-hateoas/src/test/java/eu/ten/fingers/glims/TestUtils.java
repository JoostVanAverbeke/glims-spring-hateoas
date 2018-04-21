package eu.ten.fingers.glims;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


public class TestUtils {
	
	 @Before 
	 public void beforeMethod() { 
	   HttpServletRequest request = new MockHttpServletRequest(); 
	   ServletRequestAttributes requestAttributes = new ServletRequestAttributes(request); 
	   RequestContextHolder.setRequestAttributes(requestAttributes);

	 } 

}
