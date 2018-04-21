package eu.ten.fingers.glims.repositories.exceptions;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private final Long id;

	  public ResourceNotFoundException(long id) {
		super("Resource could not be found with id: " + id);
	    this.id = id;
	  }

}
