package eu.ten.fingers.glims.repositories;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import eu.ten.fingers.glims.models.Order;
import eu.ten.fingers.glims.models.Order.OrderBuilder;
import eu.ten.fingers.glims.models.RequestedCode;


public class OrderRepository {

	private final List<Order> orders = new ArrayList<Order>();
	
	public OrderRepository() {
		Calendar order1ReceiptTime = Calendar.getInstance();

		order1ReceiptTime.set(2018,  Calendar.JANUARY, 30);
		Order.OrderBuilder orderBuilder1 = Order.builder().id(1L).
				internalId("180210-00001").
				shortId("S-180210-00001").
				receiptTime(order1ReceiptTime);
		Order.OrderBuilder orderBuilder2 = Order.builder().id(1L).
				internalId("180210-00002").
				shortId("S-180210-00002").
				receiptTime(order1ReceiptTime);
		Order.OrderBuilder orderBuilder3 = Order.builder().id(1L).
				internalId("180210-00003").
				shortId("S-180210-00003").
				receiptTime(order1ReceiptTime);

//		orderbuilder1.addRequestedCode(new RequestedCode(id, requestCodeMnemonic, identifier));
	}
	
	Order findById(long id) {
		return null;
	}

}
