package com.tj.springRest.beans;

public class CurrencyObject {

	private String country;
	private String currency;
	private String exchangeRate;
	public String getCountry() {
		return country;
	}
	public CurrencyObject(String country, String currency, String exchangeRate) {
		super();
		this.country = country;
		this.currency = currency;
		this.exchangeRate = exchangeRate;
	}
	public CurrencyObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
}
