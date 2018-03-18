package eu.ten.fingers.glims;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Passing our security configuration class to the super class ensures that all requests 
 * to our sample web service will be secured.
 * 
 * @author joost
 *
 */
public class SecurityWebApplicationInitializer extends
		AbstractSecurityWebApplicationInitializer {
	
	public SecurityWebApplicationInitializer() {
		super(SecurityConfig.class);
	}
}
