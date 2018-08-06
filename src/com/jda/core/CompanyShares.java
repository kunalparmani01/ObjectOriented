package com.jda.core;

public class CompanyShares {
	
	String symbol;
	int numberOfShares;
	String date;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getNumberOfShares() {
		return numberOfShares;
	}

	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date.toString();
	}

}
