package eu.ten.fingers.glims.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import eu.ten.fingers.glims.models.User;

/**
 * Here we use a very simple implementation which stores the user "Trump"
 * with password "Donald" in a local HashMap with his generated authentication token.
 * We match the user name, and password against "Trump" and "Donald" and return
 * a generated token.
 * 
 * @author joost
 *
 */
@Service
public class SimpleAuthenticationService implements UserAuthenticationService {
	Map<String, User> users = new HashMap<>();
	
	public Optional<String> login(String username, String password) {
		
		if (verifyUserCredentials(username, password)) {
			final String token = UUID.randomUUID().toString();
			final User userTrump = User.builder()
									   .id(token)
									   .username("Trump")
									   .password("Donald")
									   .build();
			users.put(token, userTrump);
			return Optional.of(token);
		} else {
			return Optional.empty();
		}		    
	}

	public Optional<User> findByToken(String token) {
		return Optional.ofNullable(users.get(token));
		
	}

	public void logout(User user) {
		users.remove(user.getId());
	}
	
	private boolean verifyUserCredentials(String username, String password) {
		boolean returnValue;
		
		if (StringUtils.isNotBlank(username) && "Trump".compareTo(username) == 0 &&
				StringUtils.isNotBlank(password) && "Donald".compareTo(password) == 0) {
			returnValue = true;
		}
		else {
			returnValue = false;
		}
		return returnValue;
	}

}
