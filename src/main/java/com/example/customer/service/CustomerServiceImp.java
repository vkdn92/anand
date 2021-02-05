package com.example.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;


@Service
public class CustomerServiceImp  implements CustomerService{

	@Autowired
	CustomerRepository customerrepository;
	
	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerrepository.findAll();
	}

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		this.customerrepository.save(customer);
		
	}

	@Override
	public Customer getCustomerById(long id) {
		
		Optional <Customer> optional=customerrepository.findById(id);
		Customer customer=null;
		if(optional.isPresent())
		{
			customer=optional.get();
		}
		else
		{
			throw new RuntimeException("customer not found id::"+id);
		}
			return customer;
	}

	public void deleteCustomerById(long id) {
		
		customerrepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

}

	

