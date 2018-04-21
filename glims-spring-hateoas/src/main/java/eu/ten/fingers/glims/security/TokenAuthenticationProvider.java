package eu.ten.fingers.glims.security;

/**
 * The TokenAuthenticationProvider is responsible of finding the user by it’s authentication token.
 * 
 * @author joost
 *
 */
import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import eu.ten.fingers.glims.services.UserAuthenticationService;


@Component
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
public final class TokenAuthenticationProvider extends
AbstractUserDetailsAuthenticationProvider {
	@NonNull
	UserAuthenticationService auth;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authenticationToken)
			throws AuthenticationException {
		// Nothing to do
		logger.info( 
			String.format("additionalAuthenticationChecks requested on %s details with %s authentication", 
					userDetails, authenticationToken) );
	}

	@Override
	protected UserDetails retrieveUser(String userName,
			UsernamePasswordAuthenticationToken authenticationToken)
			throws AuthenticationException {
		final Object token = authenticationToken.getCredentials();
//		Old fashioned way for debugging purpose...		
//		Optional<User> user = auth.findByToken((String) token);
//		if (user.isPresent()) {
//			return (UserDetails) user.get();
//		} else {
//			throw new UsernameNotFoundException("Cannot find user with authentication token=" + token);
//		}
	    return (UserDetails) Optional
	      .ofNullable(token)
	      .map(String::valueOf)
	      .flatMap(auth::findByToken)
	      .orElseThrow(() -> new UsernameNotFoundException("Cannot find user with authentication token=" + token));
	}
}
