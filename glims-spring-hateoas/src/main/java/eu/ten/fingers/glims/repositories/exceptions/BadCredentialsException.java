package eu.ten.fingers.glims.repositories.exceptions;

public class BadCredentialsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BadCredentialsException(String errorMessage) {
		super(errorMessage);
	}

}
