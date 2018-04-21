package eu.ten.fingers.glims.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.RedirectStrategy;

/**
 * As we’re securing a REST API, in case of authentication failure, the server should 
 * not redirect to any error page. The server will simply return an HTTP 401 
 * 
 * @author joost
 *
 */
public class NoRedirectStrategy implements RedirectStrategy {

	@Override
	public void sendRedirect(HttpServletRequest request, HttpServletResponse response,
			String url) throws IOException {
		// No redirect is required with pure REST

	}

}
