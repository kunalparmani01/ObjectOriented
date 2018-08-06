package com.jda.core;

public class Stock {
	private String nameOfStack;
	private double pricePerShare;
	private double totalShare;
	Transaction transAction;
	public String getNameOfStack() {
		return nameOfStack;
	}
	public void setNameOfStack(String nameOfStack) {
		this.nameOfStack = nameOfStack;
	}
	public double getPricePerShare() {
		return pricePerShare;
	}
	public void setPricePerShare(double pricePerShare) {
		this.pricePerShare = pricePerShare;
	}
	public double getTotalShare() {
		return totalShare;
	}
	public Transaction getTransAction() {
		return transAction;
	}
	public void setTransAction(Transaction transAction) {
		this.transAction = transAction;
	}
	public void setTotalShare(double totalShare) {
		this.totalShare = totalShare;
	}
}
