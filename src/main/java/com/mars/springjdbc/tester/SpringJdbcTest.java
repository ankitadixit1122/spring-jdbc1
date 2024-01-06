package com.mars.springjdbc.tester;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.mars.springjdbc.config.AppConfig;
import com.mars.springjdbc.dao.CustomerDAO;
import com.mars.springjdbc.model.Customer;

public class SpringJdbcTest {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		
		CustomerDAO customerDao = context.getBean(CustomerDAO.class);
		
		
		//INSERT
		
//		Customer cust = new Customer ("Ankita","hartland",3010,100,123);
//		customerDao.createCustomer(cust);
//		System.out.println("Customer Added!!!!");
//		
		
		//UPDATE
		
//		Customer cust = new Customer();
//		cust.setCustomer_id(3007);
//		cust.setCustomername("Amy");
//		cust.setCity("Chicago");
//		cust.setGrade(500);
//		cust.setSalesman_id(5015);
//		customerDao.updateCustomer(cust);
//		System.out.println("Customer Upadated !!!!");
		
		//DELETE
		
//		int result =customerDao.deleteCustomer(3008);
//		System.out.println("Deleted " + result +"!!1");
		
		
		//SELECT ALL RECORDS
		
		List<Customer> customer = customerDao.getAllCustomers();
		for(Customer c : customer)
		{
			System.out.println(c);
		}
		
		((AnnotationConfigApplicationContext) context).close();
	}

}
