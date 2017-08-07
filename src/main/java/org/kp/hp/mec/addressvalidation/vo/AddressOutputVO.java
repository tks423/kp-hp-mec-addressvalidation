package org.kp.hp.mec.addressvalidation.vo;

import java.util.Formatter;
import java.util.Locale;

public class AddressOutputVO {
	private String recordId;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zipCode;
	private String zip4;
	private boolean dpvCode;	
	private Integer errorCode;
	private String errorCodeDesc;
	private String status;
	
	

	public AddressOutputVO() {	
	}

	public String getRecordId() {
		return recordId;
	}
	
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}
	


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	

	
	public boolean isDpvCoded() {
		return dpvCode;
	}
	
	public void setDpvCoded(boolean dpvCoded) {
		dpvCode = dpvCoded;
	}
	

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Formatter formatter = new Formatter(sb, Locale.US);
		formatter.format("%s%n%b%n%s%n", recordId, dpvCode, errorCode.toString());
		if (addressLine2 == null || addressLine2.length() == 0) {
			formatter.format("%s%n%s, %s  %s", addressLine1, city, state, zipCode);	
		}
		else {
			formatter.format("%s%n%s%n%s, %s  %s", addressLine2, addressLine1, city, state, zipCode);	
		}
//		formatter.format("%n%s%n", mDpBarcode);
		return sb.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorCodeDesc() {
		return errorCodeDesc;
	}

	public void setErrorCodeDesc(String errorCodeDesc) {
		this.errorCodeDesc = errorCodeDesc;
	}

	public String getStatus() {
	    if(this.errorCode <= 8){
	    	this.status = "standardized";
	    }
	    
	    if(this.errorCode > 8 && this.errorCode < 100) {
	    	this.status = "corrected";
	    }
	    
	    if(this.errorCode >= 100){
	    	this.status = "undeliverable";
	    }
		return status;
	}

	public String getZip4() {
		return zip4;
	}

	public void setZip4(String zip4) {
		this.zip4 = zip4;
	}
}