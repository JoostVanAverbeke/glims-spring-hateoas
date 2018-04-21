package eu.ten.fingers.glims.resources;

import java.util.Calendar;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.hateoas.Link;

import eu.ten.fingers.glims.TestUtils;
import eu.ten.fingers.glims.models.Order;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.is;

public class OrderResourceTest extends TestUtils {
	private Order order;
	private Order emptyOrder;
	private OrderResource orderResource;
	private OrderResource emptyOrderResource;
    
	@Before
	public void beforeSubMethod() { 
		Calendar receiptTime = Calendar.getInstance();
		
		receiptTime.set(2018,  Calendar.JANUARY, 30);
		order = Order.builder()
				.id(1L)
				.internalId("20180408-00001")
				.shortId("S-20180408-0001")
				.receiptTime(receiptTime )
				.build();
		orderResource = new OrderResource(order);
		emptyOrder = Order.builder()
				.id(1L)
				.build();
		emptyOrderResource = new OrderResource(emptyOrder);
	}
	
	@Test
	public void testOrderResource() {
		assertThat(orderResource, is(not(nullValue())));
		assertThat(emptyOrderResource, is(not(nullValue())));
	}

	@Test
	public void testGetInternalId() {
		assertThat(orderResource.getInternalId(), is("20180408-00001"));
		assertThat(emptyOrderResource.getInternalId(), is(nullValue()));
	}

	@Test
	public void testGetShortId() {
		assertThat(orderResource.getShortId(), is("S-20180408-0001"));
		assertThat(emptyOrderResource.getShortId(), is(nullValue()));
	}

	@Test
	public void testGetReceiptTime() {
		assertThat(orderResource.getReceiptTime(), is("2018-01-30"));
		assertThat(emptyOrderResource.getReceiptTime(), is(nullValue()));
	}
	
	@Test
	public void testLinks() {
		assertThat(orderResource.getLinks().size(), is(2));
		assertThat(emptyOrderResource.getLinks().size(), is(2));
	}

	@Test
	public void testLinkToOrderRel() {
		assertThat(orderResource.getLink("order"), is(not(nullValue())));
		assertThat(orderResource.getLink("order").getHref(), Matchers.endsWith("/orders"));
		assertThat(emptyOrderResource.getLink("order"), is(not(nullValue())));
	}

	@Test
	public void testLinkToSelfRel() {
		Link selfRelLink = orderResource.getLinks().get(1);
	    assertThat(selfRelLink.getRel(), is(Link.REL_SELF)); 
	    assertThat(selfRelLink.getHref(), Matchers.endsWith("/orders/" + order.getId().toString())); 
	}
	
}
