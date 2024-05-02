package com.example.REST.demo.DB.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.REST.demo.DB.Exception.CustomerIdNotFoundException;
import com.example.REST.demo.DB.Exception.CustomersNotFound;
import com.example.REST.demo.DB.controller.ErrorResponse;
import com.example.REST.demo.DB.controller.Response;
import com.example.REST.demo.DB.model.Customer;
import com.example.REST.demo.DB.repository.cusRepo;

@Service
public class serviceclass implements serviceInterface {

	@Autowired
	private cusRepo CusRepo;

	@Override
	public ResponseEntity insert(Customer customer) {
//		CusRepo.save(Customer);
		try {
			if (customer.getPhonenum().length() < 10 || customer.getPhonenum().length() > 10) {
				ErrorResponse res = new ErrorResponse("Not acceptable", 406,
						"Phone number is not in the format,Phone number length should be equal to ten..");
				return new ResponseEntity<>(res, HttpStatus.NOT_ACCEPTABLE);
			}
			if (customer.getName() == "") {
				ErrorResponse res = new ErrorResponse("Not acceptable", 406, "Name should not be null");
				return new ResponseEntity<>(res, HttpStatus.NOT_ACCEPTABLE);
			}
			if (customer.getAddress() == "") {
				ErrorResponse res = new ErrorResponse("Not acceptable", 406, "Address should not be null");
				return new ResponseEntity<>(res, HttpStatus.NOT_ACCEPTABLE);
			}
//			if(CusRepo.existsById(customer.getId())) {
//				ErrorResponse res = new ErrorResponse("Conflict", 409, CustomerExistAlready.msg);
//				return new ResponseEntity<>(res, HttpStatus.CONFLICT);
//			}
//			if(CusRepo.exists((Example<Customer>) customer)) {
//				ErrorResponse res = new ErrorResponse("Conflict", 409, CustomerExistAlready.msg);
//				return new ResponseEntity<>(res, HttpStatus.CONFLICT);
//			}
			
			CusRepo.save(customer);
			Response res = new Response("Success", 201, "Customer created successfully", customer);
			return new ResponseEntity<>(res, HttpStatus.CREATED);

//			            }else {
//			            	ErrorResponse res = new ErrorResponse("Conflict", 409, CustomerExistAlready.msg);
//			                return new ResponseEntity<>(res, HttpStatus.CONFLICT);
//			            }

		} catch (Exception e) {
			Response res = new Response("Failure", 500, "Internal server error", null);
			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//	@Override
//	public Customer getById(Integer id) {
//		Optional<Customer> findById= CusRepo.findById(id);
//		if(findById.isPresent()) {
//			return findById.get();
//		}
//		return null;
//	}

	@Override
	public ResponseEntity getAllCus() {
//		return CusRepo.findAll();
		List<Customer> customers = CusRepo.findAll();
		try {
			if (!customers.isEmpty()) {
				Response res = new Response("Success", 200, "All customers retrieved successfully", customers);
				return new ResponseEntity<>(res, HttpStatus.OK);
			} else {
				ErrorResponse res = new ErrorResponse("Failure", 404, CustomersNotFound.msg);
				return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			Response res = new Response("Failure", 500, "Internal server error", null);
			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> getCusbyId(int id) throws CustomersNotFound,NullPointerException{
		try {
			if (CusRepo.existsById(id)) {
				Optional<Customer> customer = CusRepo.findById(id);
				Response res = new Response("Success", 200, "Customer retrieved successfully", customer);
				return new ResponseEntity<>(res, HttpStatus.OK);
			} else {
				ErrorResponse res = new ErrorResponse("Failure", 404, CustomerIdNotFoundException.msg);
				return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			Response res = new Response("Failure", 500, "Internal server error", null);
			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity deleteById(Integer id) throws CustomersNotFound{
		try {
			if (CusRepo.existsById(id)) {
				CusRepo.deleteById(id);
				Response res = new Response("Success", 200, "Customer deleted successfully", null);
				return new ResponseEntity<>(res, HttpStatus.OK);
			} else {
				ErrorResponse res = new ErrorResponse("Failure", 404, CustomerIdNotFoundException.msg);
				return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			Response res = new Response("Failure", 500, "Internal server error", null);
			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity updatebyId(int id, Customer customer) {
		// TODO Auto-generated method stub

		try {
			if (CusRepo.existsById(id)) {
				if (customer.getPhonenum().length() == 10) {
					Customer cus = CusRepo.findById(id).get();
					cus.setPhonenum(customer.getPhonenum());
					CusRepo.save(cus);
				}
				if (customer.getName() != "") {
					Customer cus = CusRepo.findById(id).get();
					cus.setName(customer.getName());
					CusRepo.save(cus);
				}
				if (customer.getAddress() != "") {
					Customer cus = CusRepo.findById(id).get();
					cus.setAddress(customer.getAddress());
					CusRepo.save(cus);
				}
				Response res = new Response("Success", 200, "Customer updated succesfully", customer);
				return new ResponseEntity<>(res, HttpStatus.OK);
			} else {
				ErrorResponse res = new ErrorResponse("Failure", 404, CustomerIdNotFoundException.msg);
				return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			Response res = new Response("Failure", 500, "Internal server error", null);
			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}