package com.example.REST.demo.DB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.REST.demo.DB.model.Customer;
import com.example.REST.demo.DB.repository.cusRepo;
import com.example.REST.demo.DB.services.serviceInterface;

@RestController
@RequestMapping(path = "/cus", produces = MediaType.APPLICATION_JSON_VALUE)
public class cusController {
	@Autowired
	private serviceInterface cusService;

	@Autowired
	private Validator validator;

	@Autowired
	private cusRepo cusrepo;
//	
//	@Autowired 
//	private Customer customer;

	// Create customer
	@PostMapping(path = "/CreateCustomer", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity createCus(@RequestBody @Validated Customer customer) {
		
		return cusService.insert(customer);
//		try {
//
////            List<Customer> customers = cusService.getAllCus();
////            if(customers.contains(customer.getPhonenum())) {
//			if (customer.getPhonenum().length() < 10 || customer.getPhonenum().length() > 10) {
//				ErrorResponse res = new ErrorResponse("Not acceptable", 406,
//						"Phone number is not in the format,Phone number length should be equal to ten..");
//				return new ResponseEntity<>(res, HttpStatus.NOT_ACCEPTABLE);
//			}
//			if (customer.getName() == "") {
//				ErrorResponse res = new ErrorResponse("Not acceptable", 406, "Name should not be null");
//				return new ResponseEntity<>(res, HttpStatus.NOT_ACCEPTABLE);
//			}
//			if (customer.getAddress() == "") {
//				ErrorResponse res = new ErrorResponse("Not acceptable", 406, "Address should not be null");
//				return new ResponseEntity<>(res, HttpStatus.NOT_ACCEPTABLE);
//			}
//			String status = cusService.insert(customer);
//			Response res = new Response("Success", 201, "Customer created successfully", customer);
//			return new ResponseEntity<>(res, HttpStatus.CREATED);
//
////            }else {
////            	ErrorResponse res = new ErrorResponse("Conflict", 409, CustomerExistAlready.msg);
////                return new ResponseEntity<>(res, HttpStatus.CONFLICT);
////            }
//
//		} catch (Exception e) {
//			Response res = new Response("Failure", 400, "Bad request", null);
//			return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
//		}
	}

	// get by id
	@GetMapping(path = "/customerbyId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getCus(@PathVariable int id) {
		return cusService.getCusbyId(id);
//		try {
//			Optional<Customer> customerOptional = cusService.getCusbyId(id);
//			if (customerOptional.isPresent()) {
//				Customer customer = customerOptional.get();
//				Response res = new Response("Success", 200, "Customer retrieved successfully", customer);
//				return new ResponseEntity<>(res, HttpStatus.OK);
//			} else {
//				ErrorResponse res = new ErrorResponse("Failure", 404, CustomerIdNotFoundException.msg);
//				return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
//			}
//		} catch (Exception e) {
//			Response res = new Response("Failure", 500, "Internal server error", null);
//			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
	}

	// get all customers
	@GetMapping(path = "/getAllcustomers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getAllCus() {
		return cusService.getAllCus();
//		try {
//			List<Customer> customers = cusService.getAllCus();
//			Response res = new Response("Success", 200, "All customers retrieved successfully", customers);
//			return new ResponseEntity<>(res, HttpStatus.OK);
//		} catch (Exception e) {
//			Response res = new Response("Failure", 500, "Internal server error", null);
//			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
	}

	// update customer
	@PutMapping(path = "/Updatecustomer/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity updateCus(@PathVariable int id, @RequestBody Customer customer) {
		return cusService.updatebyId(id, customer);
		
//		try {
//			ResponseEntity cust = cusService.getCusbyId(id);
//			if (cust != null) {
//				if (customer.getName() != null) {
//					Customer cusUpdate = cusrepo.findById(id).get();
//					cusUpdate.setName(customer.getName());
//					cusrepo.save(cusUpdate);
//				}
//				Response res = new Response("Success", 200, "Customer updated succesfully", customer);
//				return new ResponseEntity<>(res, HttpStatus.OK);
//			} else {
//				ErrorResponse res = new ErrorResponse("Failure", 404, CustomerIdNotFoundException.msg);
//				return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
//			}
//		} catch (Exception e) {
//			Response res = new Response("Failure", 500, "Internal server error", null);
//			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
	}

	@DeleteMapping(path = "/Deletecustomer/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity deleteCus(@PathVariable Integer id) {
		return cusService.deleteById(id);
//		try {
//			// Call service method to delete the customer by ID
//			boolean deleted = cusService.deleteById(id);
//
//			if (deleted) {
//				Response res = new Response("Success", 200, "Customer deleted successfully", null);
//				return new ResponseEntity<>(res, HttpStatus.OK);
//			} else {
//				ErrorResponse res = new ErrorResponse("Failure", 404, CustomerIdNotFoundException.msg);
//				return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
//			}
//		} catch (Exception e) {
//			Response res = new Response("Failure", 500, "Internal server error", null);
//			return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
	}

}