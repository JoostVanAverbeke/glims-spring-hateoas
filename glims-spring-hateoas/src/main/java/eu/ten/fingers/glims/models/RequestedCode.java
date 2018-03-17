package eu.ten.fingers.glims.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data public class RequestedCode {
	private Long id;
	private String requestCodeMnemonic;
	private String identifier;
	
	public RequestedCode(Long id, String requestCodeMnemonic, String identifier) {
		super();
		this.id = id;
		this.requestCodeMnemonic = requestCodeMnemonic;
		this.identifier = identifier;
	}

}
