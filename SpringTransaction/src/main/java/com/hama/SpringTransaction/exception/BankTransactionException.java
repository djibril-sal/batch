package com.hama.SpringTransaction.exception;

public class BankTransactionException extends Exception {
	
	
	private static final long serialVersionUID = 8193473285877171181L;

	public BankTransactionException (String message) {
		super(message);
	}

}
