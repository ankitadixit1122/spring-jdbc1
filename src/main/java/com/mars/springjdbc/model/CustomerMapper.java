package com.mars.springjdbc.model;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class CustomerMapper implements RowMapper<Customer> {
	
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException{
		
		Customer customer = new Customer();
		customer.setCustomername(rs.getString("customer_name"));
		customer.setCity(rs.getString("city"));
		customer.setCustomer_id(rs.getInt("customer_id"));
		customer.setGrade(rs.getInt("grade"));
		customer.setSalesman_id(rs.getInt("salesman_id"));
		return customer;
		
	}

}
