package com.example.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	CustomerService customerservice;
	
	@GetMapping("/list")
	public String viewHomePage(Model model)
	{
		model.addAttribute("listCustomers", customerservice.getAllCustomers());
		return "Index";
	
	}
	@GetMapping("/showNewCustomerForm")
	public String showNewCustomerForm(Model model)
	{
		Customer customer=new Customer();
		model.addAttribute("customer",customer);
	return "new_customer";
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer)
	{
	customerservice.saveCustomer(customer);
	return "redirect:/list";
	
	}
	@GetMapping("/ubdate/{id}")
	public String ubdate(@PathVariable(value="id")long id,Model model)
	{
		Customer customer=customerservice.getCustomerById(id);
		model.addAttribute("customer", customer);
		return "ubdate";
		
	}
	@GetMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable(value="id")long id)
	{
		customerservice.deleteCustomerById(id);
		return "redirect:/list";
		
	}
	
	
	

}
