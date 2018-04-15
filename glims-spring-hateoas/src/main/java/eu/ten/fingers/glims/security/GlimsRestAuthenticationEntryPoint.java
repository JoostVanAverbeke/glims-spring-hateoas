package eu.ten.fingers.glims.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import eu.ten.fingers.glims.repositories.exceptions.ResourceNotFoundException;

/**
 * This class implements custom error handling when an exception is thrown during the request handling.
 *  
 * @author joost
 *
 */
@ControllerAdvice
public class GlimsRestAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException authException)
			throws IOException, ServletException {
	    // 401
	    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed");
	}
	
	/**
	 * Sends an error response to the client with status {@link HttpServletResponse#SC_UNAUTHORIZED} 
	 * and clears the buffer.
	 * 
	 * @param request that resulted in an UsernameNotFoundException
	 * @param response so that the user agent can begin authentication
	 * @param usernameNotFoundException the UsernameNotFoundException exception that caused the invocation
	 * @throws IOException
	 */
	@ExceptionHandler (value = {UsernameNotFoundException.class})
	public void commence(HttpServletRequest request, HttpServletResponse response,
			UsernameNotFoundException usernameNotFoundException) throws IOException {
		// 401
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed");
	}

	/**
	 * Sends an error response to the client with status {@link HttpServletResponse#SC_FORBIDDEN} 
	 * and clears the buffer.
	 * 
	 * @param request that resulted in an AccessDeniedException
	 * @param response so that the user agent can begin authentication
	 * @param accessDeniedException the AccessDeniedException exception that caused the invocation
	 * @throws IOException
	 */
	@ExceptionHandler (value = {AccessDeniedException.class})
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException {
		// 403
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "Authorization Failed : " + accessDeniedException.getMessage());
	}

	/**
	 * Sends an error response to the client with status {@link HttpServletResponse#SC_NOT_FOUND} 
	 * and clears the buffer.
	 * 
	 * @param request that resulted in a ResourceNotFoundException
	 * @param response so that the user agent can begin authentication
	 * @param exception the ResourceNotFoundException exception that caused the invocation
	 * @throws IOException
	 */
	@ExceptionHandler (value = {ResourceNotFoundException.class})
	public void commence(HttpServletRequest request, HttpServletResponse response,
			ResourceNotFoundException resourceNotFoundException) throws IOException {
		// 404
		response.sendError(HttpServletResponse.SC_NOT_FOUND, "Resource not found : " + resourceNotFoundException.getMessage());
	}

	/**
	 * Sends an error response to the client with status {@link HttpServletResponse#SC_INTERNAL_SERVER_ERROR} 
	 * and clears the buffer.
	 * 
	 * @param request that resulted in an Exception
	 * @param response so that the user agent can begin authentication
	 * @param exception the Exception exception that caused the invocation
	 * @throws IOException
	 */
	@ExceptionHandler (value = {Exception.class})
	public void commence(HttpServletRequest request, HttpServletResponse response,
			Exception exception) throws IOException {
		// 500
		response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Server Error : " + exception.getMessage());
	}

}
