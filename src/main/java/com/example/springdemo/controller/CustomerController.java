package com.example.springdemo.controller;

import com.example.springdemo.dao.CustomerDAO;
import com.example.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// inject the customer DAO
	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping("/list")
	public String listCustomers(Model theModel) {

		// get customers from the DAO
		List<Customer> customers = customerDAO.getCustomers();

		// add the customers to the model
		theModel.addAttribute("customers", customers);
		
		return "list-customers";
	}
	
}


