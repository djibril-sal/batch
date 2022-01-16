package com.hama.SpringTransaction.model;

public class BankAccountInfo {
	
	private long id;
	private String fullName;
	private Double balance;
	
	
	public BankAccountInfo() {
	}


	public BankAccountInfo(long id, String fullName, Double balance) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.balance = balance;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	
	
	
	

}
