package com.mars.springjdbc.dao;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mars.springjdbc.model.Customer;
import com.mars.springjdbc.model.CustomerMapper;



@Component
public class CustomerDAOImpl implements CustomerDAO {
	
	JdbcTemplate jdbcTemplate;
	
	private final String SQL_CREATE_CUSTOMER = "insert into customer values(?,?,?,?,?)";
	private final String SQL_UPDATE_CUSTOMER = "update customer set customer_name =? ,city =?,grade =?,salesman_id=? where customer_id =?";
	private final String SQL_DELETE_CUSTOMER = "delete from customer where customer_id =?";
	private final String SQL_SELECT_ALL_CUSTOMER ="select * from customer";
	private final String SQL_SELECT_SINGLE_CUSTOMER ="select * from customer where customer_id = ?";
	
	@Autowired
	public CustomerDAOImpl(DataSource ds) {
		jdbcTemplate = new JdbcTemplate(ds);
		
	}
	
	
	//SELECT SINGLE CUSTOMER DATA
	public Customer getCustomerById(int customer_id) {
		
		//ROWMAPER IS AN INTERFACE SO WE NEED TO CREATE A IMPLEMRNTATION CLASS TO CREATE OBJECT OF ROWMAPPER THAT IS CUSTOMERMAPPER
		RowMapper<Customer> rowMapper =new CustomerMapper();
		Customer customer =this.jdbcTemplate.queryForObject(SQL_SELECT_SINGLE_CUSTOMER, rowMapper, customer_id);
		return customer;
	}

	
	public List<Customer> getAllCustomers() {
		
		return jdbcTemplate.query(SQL_SELECT_ALL_CUSTOMER,new CustomerMapper());
	}


//	public boolean deleteCustomer(Customer customer) {
//		
//		return jdbcTemplate.update(SQL_DELETE_CUSTOMER,customer.getCustomer_id())>0;
//	}


	public boolean updateCustomer(Customer customer) {
		
		return jdbcTemplate.update(SQL_UPDATE_CUSTOMER,customer.getCustomer_name(),customer.getCity(),customer.getGrade(),customer.getSalesman_id(),customer.getCustomer_id())>0;
	}


	public boolean createCustomer(Customer customer) {
		
		return jdbcTemplate.update(SQL_CREATE_CUSTOMER,customer.getCustomer_name(),customer.getCity(),customer.getCustomer_id(),customer.getGrade(),customer.getSalesman_id())>0;
	}

	
	public int deleteCustomer(int customer_id) {
		
		return jdbcTemplate.update(SQL_DELETE_CUSTOMER,customer_id);
	}
	

}
