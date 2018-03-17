package eu.ten.fingers.glims.repositories;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Repository;

import eu.ten.fingers.glims.models.Order;
import eu.ten.fingers.glims.models.RequestedCode;

@Repository
public class OrderRepository {

	private final List<Order> orders = new ArrayList<Order>();
	
	public OrderRepository() {
		Calendar order1ReceiptTime = Calendar.getInstance();

		order1ReceiptTime.set(2018,  Calendar.JANUARY, 30);
		Order.OrderBuilder orderBuilder1 = Order.builder().id(1L).
				internalId("180210-00001").
				shortId("S-180210-00001").
				receiptTime(order1ReceiptTime);
		Order.OrderBuilder orderBuilder2 = Order.builder().id(2L).
				internalId("180210-00002").
				shortId("S-180210-00002").
				receiptTime(order1ReceiptTime);
		Order.OrderBuilder orderBuilder3 = Order.builder().id(3L).
				internalId("180210-00003").
				shortId("S-180210-00003").
				receiptTime(order1ReceiptTime);
		
		RequestedCode.RequestedCodeBuilder requestedCodeBuilder1 = RequestedCode.builder().id(1L)
				.identifier("123456781").requestCodeMnemonic("NA");
		RequestedCode.RequestedCodeBuilder requestedCodeBuilder2 = RequestedCode.builder().id(2L)
				.identifier("123456782").requestCodeMnemonic("K");
		RequestedCode.RequestedCodeBuilder requestedCodeBuilder3 = RequestedCode.builder().id(3L)
				.identifier("123456783").requestCodeMnemonic("CL");
		RequestedCode.RequestedCodeBuilder requestedCodeBuilder4 = RequestedCode.builder().id(4L)
				.identifier("123456784").requestCodeMnemonic("GLU");
		RequestedCode.RequestedCodeBuilder requestedCodeBuilder5 = RequestedCode.builder().id(5L)
				.identifier("123456784").requestCodeMnemonic("CKMB");

		orderBuilder1.requestedCode(requestedCodeBuilder1.build())
			.requestedCode(requestedCodeBuilder2.build());
		orderBuilder2.requestedCode(requestedCodeBuilder3.build());
		orderBuilder3.requestedCode(requestedCodeBuilder4.build())
			.requestedCode(requestedCodeBuilder5.build());
		
		this.orders.add(orderBuilder1.build());
		this.orders.add(orderBuilder2.build());
		this.orders.add(orderBuilder3.build());
	}
	
	public List<Order> findAll() {
		return this.orders;
	}
	
	public Order findById(Long id) {
		for(Order order : this.orders) {
			if (order.getId().equals(id)) {
				return order;
			}
		}
		return null;
	}

}
