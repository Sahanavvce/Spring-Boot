package com.example.REST.demo.DB.Exception;

public class CustomerIdNotFoundException extends RuntimeException{
	
	public static String msg = "Customers not found!!!";
	
	public CustomerIdNotFoundException() {}

	public CustomerIdNotFoundException(String msg) {
		super(msg);
		this.msg=msg;
	}
}
