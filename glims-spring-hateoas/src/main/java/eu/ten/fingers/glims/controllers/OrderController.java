package eu.ten.fingers.glims.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import eu.ten.fingers.glims.models.Order;
import eu.ten.fingers.glims.resources.OrderResource;

@RestController
@RequestMapping(value = "/orders", produces = MediaTypes.HAL_JSON_VALUE)
public class OrderController {
//	final OrderRepository orderRepository;
//
//	public OrderController(OrderRepository orderRepository) {
//		super();
//		this.orderRepository = orderRepository;
//	}
	@GetMapping
	public ResponseEntity<Resources<OrderResource>> all() {
		final List<OrderResource> orderResourceCollection = CreateOrderResourceCollection();
		final Resources<OrderResource> resources = new Resources<>(orderResourceCollection);
	    final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
	    resources.add(new Link(uriString, "self"));
	    return ResponseEntity.ok(resources);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderResource> get(@PathVariable final long id) {
//	    return orderRepository
//	        .findById(id)
//	        .map(order -> ResponseEntity.ok(new OrderResource(order)))
//	        .orElseThrow(() -> new OrderNotFoundException(id));
		Calendar orderReceiptTime = Calendar.getInstance();
		orderReceiptTime.set(2018,  Calendar.JANUARY, 30);
		Order order = new Order((long) 1, "180210-00001", "S-180210-00001", orderReceiptTime);
		return ResponseEntity.ok(new OrderResource(order));
    }
	
	private List<OrderResource> CreateOrderResourceCollection() {
		List<OrderResource> orderResourceCollection = new ArrayList<OrderResource>();	
		Calendar order1ReceiptTime = Calendar.getInstance();
		
		order1ReceiptTime.set(2018,  Calendar.JANUARY, 30);
		Order order1 = new Order((long) 1, "180210-00001", "S-180210-00001", order1ReceiptTime);
		Order order2 = new Order((long) 2, "180210-00002", "S-180210-00002", order1ReceiptTime);
		Order order3 = new Order((long) 3, "180210-00003", "S-180210-00002", order1ReceiptTime);
		
		orderResourceCollection.add(new OrderResource(order1));
		orderResourceCollection.add(new OrderResource(order2));
		orderResourceCollection.add(new OrderResource(order3));
		return orderResourceCollection;
	}
}
