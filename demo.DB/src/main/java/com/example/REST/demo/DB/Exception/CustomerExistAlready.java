package com.example.REST.demo.DB.Exception;

public class CustomerExistAlready {

public static String msg = "Customer Exists already";
	
	public CustomerExistAlready() {}

	public CustomerExistAlready(String msg) {
		super();
		this.msg=msg;
	}
}
