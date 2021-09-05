package com.example.springdemo.controller;

import com.example.springdemo.entity.Customer;
import com.example.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// inject the customer Service
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {

		// get customers from the DAO
		List<Customer> customers = customerService.getCustomers();

		// add the customers to the model
		theModel.addAttribute("customers", customers);
		
		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model){
		// create model attribute to bind form data
		Customer theCustomer = new Customer();

		model.addAttribute("customer", theCustomer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

		// save the customer using our service
		customerService.saveCustomer(theCustomer);


		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id,
									Model model){
		// get the customer from DB
		Customer customer = customerService.getCustomer(id);

		// set customer as a model attribute to pre-populate the form
		model.addAttribute("customer", customer);

		// send over to our form
		return "customer-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id){
		//delete the customer
		customerService.deleteCustomer(id);

		return "redirect:/customer/list";
	}
}


