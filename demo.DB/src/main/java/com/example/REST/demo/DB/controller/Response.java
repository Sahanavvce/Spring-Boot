package com.example.REST.demo.DB.controller;


public class Response {

	private String status;
	private int statusCode;
    private String message;
    private Object data;
    
    public Response(String status, int statusCode, String message, Object data) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object customer) {
		this.data = customer;
	}
	
}
