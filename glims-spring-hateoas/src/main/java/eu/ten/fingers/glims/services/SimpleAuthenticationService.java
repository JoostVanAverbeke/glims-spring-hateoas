package eu.ten.fingers.glims.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import eu.ten.fingers.glims.models.User;

/**
 * Here we use a very simple implementation which stores the users in a local HashMap by token.
 * 
 * @author joost
 *
 */
@Service
public class SimpleAuthenticationService implements UserAuthenticationService {
	Map<String, User> users = new HashMap<>();
	
	public Optional<String> login(String username, String password) {
		   final String token = UUID.randomUUID().toString();
		    final User user = User
		      .builder()
		      .id(token)
		      .username(username)
		      .password(password)
		      .build();

		    users.put(token, user);
		    return Optional.of(token);
		    
	}

	public Optional<User> findByToken(String token) {
		return Optional.ofNullable(users.get(token));
		
	}

	public void logout(User user) {
		users.remove(user.getId());
	}

}
