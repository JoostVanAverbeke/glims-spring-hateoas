package eu.ten.fingers.glims.controllers;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.ten.fingers.glims.services.UserAuthenticationService;

import javax.servlet.http.HttpServletRequest;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

/**
 * The PublicUsersController allows a user to login into the application.
 * 
 * @author joost
 *
 */
@RestController
@RequestMapping("/public/users")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
public class PublicUsersController {
	@NonNull
	UserAuthenticationService authentication;

	@PostMapping("/login")
	String login(final HttpServletRequest request,
		@RequestParam("username") final String username,
		@RequestParam("password") final String password) {
		return authentication
		  .login(username, password)
		  .orElseThrow(() -> new RuntimeException("invalid login and/or password"));
	}
}
