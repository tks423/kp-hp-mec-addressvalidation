package org.kp.hp.mec.addressvalidation.vo;

import java.util.List;

public class AddressValidationRequest {

	private List<AddressInputVO> addresses;
	private String systemId;
	private String systemName;
	private String requestId;
	private String recordCount;
	
	
	public List<AddressInputVO> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<AddressInputVO> addresses) {
		this.addresses = addresses;
	}
	public String getSystemId() {
		return systemId;
	}
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(String recordCount) {
		this.recordCount = recordCount;
	}
	

}
