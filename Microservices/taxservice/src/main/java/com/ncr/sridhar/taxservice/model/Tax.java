package com.ncr.sridhar.taxservice.model;

public class Tax {
	
	private String taxName;
	private String taxPercent;
	
	public Tax(String taxName, String taxPercent) {
		this.taxName = taxName;
		this.taxPercent = taxPercent;
	}	
	
	public String getTaxName() {
		return taxName;
	}
	public void setTaxName(String taxName) {
		this.taxName = taxName;
	}
	public String getTaxPercent() {
		return taxPercent;
	}
	public void setTaxPercent(String taxPercent) {
		this.taxPercent = taxPercent;
	}
}
