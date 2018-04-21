package eu.ten.fingers.glims.resources;

import java.text.SimpleDateFormat;

import eu.ten.fingers.glims.controllers.OrderController;
import eu.ten.fingers.glims.models.Order;

import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;



public class OrderResource extends ResourceSupport {
	
	private final Order order;
	
	public OrderResource(final Order order) {
		this.order = order;
	    final long id = order.getId();
	    add(linkTo(OrderController.class).withRel("order"));
//	    add(linkTo(methodOn(GymMembershipController.class).all(id)).withRel("memberships"));
	    add(linkTo(methodOn(OrderController.class).get(id)).withSelfRel());

	}
	
	public String getInternalId() {
		return order.getInternalId();
	}

	public String getShortId() {
		return order.getShortId();
	}
	
//	https://static.javadoc.io/com.fasterxml.jackson.core/jackson-databind/2.8.5/com/fasterxml/jackson/databind/ser/std/CalendarSerializer.html
	public String getReceiptTime() {
		if (order.getReceiptTime() != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			return dateFormat.format(this.order.getReceiptTime().getTime());
		}
		return null;	
	}

}
