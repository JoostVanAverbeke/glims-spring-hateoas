package eu.ten.fingers.glims.repositories.exceptions;

import lombok.Getter;

@Getter
public class OrderNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private final Long id;

	  public OrderNotFoundException(long id) {
		super("Person could not be found with id: " + id);
	    this.id = id;
	  }

}
