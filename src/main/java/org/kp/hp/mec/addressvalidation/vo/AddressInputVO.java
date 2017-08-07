package org.kp.hp.mec.addressvalidation.vo;

import java.util.Formatter;
import java.util.Locale;

public class AddressInputVO {
	private String recordId;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zipCode;

	public AddressInputVO() {
		this.recordId = "";
		this.addressLine1 = "";
		this.addressLine2 = "";
		this.city = "";
		this.state = "";
		this.zipCode = "";
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

	public void setAddressLine1(String address1) {
		addressLine1 = address1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String address2) {
		this.addressLine2 = address2;

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

	public void setZipCode(String zip) {
		zipCode = zip;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Formatter formatter = new Formatter(sb, Locale.US);
		if (addressLine2 == null || addressLine2.length() == 0) {
			formatter.format("%s\n%s%n%s, %s  %s", recordId, addressLine1, city, state, zipCode);
		} else {
			formatter.format("%s\n%s%n%s%n%s, %s  %s", recordId, addressLine2, addressLine1, city, state, zipCode);
		}
		return sb.toString();
	}
}