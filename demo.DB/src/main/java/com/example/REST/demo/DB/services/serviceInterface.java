package com.example.REST.demo.DB.services;

import org.springframework.http.ResponseEntity;

import com.example.REST.demo.DB.controller.Response;
import com.example.REST.demo.DB.model.Customer;

public interface serviceInterface {
	public ResponseEntity insert(Customer Customer);
	public ResponseEntity deleteById(Integer id);
	public ResponseEntity<Response> getAllCus();
	public ResponseEntity getCusbyId(int id);
	public ResponseEntity updatebyId(int id,Customer customer);
}