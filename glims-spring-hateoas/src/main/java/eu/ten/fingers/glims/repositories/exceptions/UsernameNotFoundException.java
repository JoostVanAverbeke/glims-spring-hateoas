package eu.ten.fingers.glims.repositories.exceptions;

public class UsernameNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UsernameNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
