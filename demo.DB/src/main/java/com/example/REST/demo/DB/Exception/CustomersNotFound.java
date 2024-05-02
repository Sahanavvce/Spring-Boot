package com.example.REST.demo.DB.Exception;

public class CustomersNotFound extends RuntimeException{
	
	public static String msg = "Customer not found!!!";
	
	public CustomersNotFound() {}

	public CustomersNotFound(String msg) {
		super(msg);
		this.msg=msg;
	}
}
