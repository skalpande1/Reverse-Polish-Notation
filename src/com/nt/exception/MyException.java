package com.nt.exception;
public class MyException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public MyException() {
		super();
	}

	public MyException(String msg) {
		super(msg);
	}
}