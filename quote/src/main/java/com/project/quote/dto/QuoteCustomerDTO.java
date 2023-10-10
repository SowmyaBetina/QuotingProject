package com.project.quote.dto;


public class QuoteCustomerDTO {
    private String quoteName;
    private String quoteOwner;
    private String customerName;
    private String accountStatus;
	public String getQuoteName() {
		return quoteName;
	}
	public void setQuoteName(String quoteName) {
		this.quoteName = quoteName;
	}
	public String getQuoteOwner() {
		return quoteOwner;
	}
	public void setQuoteOwner(String quoteOwner) {
		this.quoteOwner = quoteOwner;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
    

}
