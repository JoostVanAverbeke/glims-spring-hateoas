package eu.ten.fingers.glims.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

@Builder
@Data public class Order {
	private Long id;
	private String internalId;
	private String shortId;
	private Calendar receiptTime;
	@Singular private List<RequestedCode> requestedCodes;

	public Order(Long id, String internalId, String shortId,
			Calendar receiptTime) {
		this(id, internalId, shortId, receiptTime, null);
	}
	
	public Order(Long id, String internalId, String shortId,
			Calendar receiptTime, List<RequestedCode> requestedCodes) {
		super();
		this.id = id;
		this.internalId = internalId;
		this.shortId = shortId;
		this.receiptTime = receiptTime;		
		this.requestedCodes = (requestedCodes != null) ? 
				new ArrayList<RequestedCode>(requestedCodes) : new ArrayList<RequestedCode>();
		
	}

}
