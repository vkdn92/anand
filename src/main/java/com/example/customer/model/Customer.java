package com.example.customer.model;

import javax.persistence.*;
@Entity
@Table(name="customers")
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	
	@Column(name="Name")
	private String Name;
	
	@Column(name="Salary")
	private Long Salary;
	
	@Column(name="Address")
	private String Address;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		this.Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public Long getSalary() {
		return Salary;
	}

	public void setSalary(Long salary) {
		this.Salary = salary;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	}
}
