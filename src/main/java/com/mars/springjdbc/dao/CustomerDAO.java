package com.mars.springjdbc.dao;

import java.util.List;

import com.mars.springjdbc.model.Customer;

public interface CustomerDAO {
	
	//THIS WILL CALL IMPLEMENTATION CLASS USING RUNTIME POLYMERPHISMS
	
	Customer getCustomerById(int customer_id );
	
	List<Customer> getAllCustomers();
	
	int deleteCustomer(int customer_id);
	
	boolean updateCustomer(Customer customer);
	
	boolean createCustomer(Customer customer);
	
	

}
