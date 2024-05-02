package com.example.REST.demo.DB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.REST.demo.DB.model.Customer;

public interface cusRepo extends JpaRepository<Customer,Integer>{

//	void save(Customer cusUpdate);
//
//	Optional<Customer> findById(int id);
// 
}