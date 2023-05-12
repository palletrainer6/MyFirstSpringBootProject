package com.palle.CustomerCRUDSpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping
public class CustomerCrudSpringBootApplication
{
	private final CustomerRepository customerRepository;
	public CustomerCrudSpringBootApplication(CustomerRepository customerRepository)
	{
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args)
	{
		SpringApplication.run(CustomerCrudSpringBootApplication.class, args);
	}

	/* Display all the customer data from DB  */
	@GetMapping("/")
	public List<Customer> getCustomers()
	{
		return customerRepository.findAll();
	}

	/* Display the customer data based on id from DB  */

	// @GetMapping("/byId")
	public List<Customer> getCustomerById()
	{
		ArrayList<Integer> al = new ArrayList<>(2);
		al.add(1);

		Iterable<Integer> i = al;

		return customerRepository.findAllById(i);
	}

	/* Insert Customer into DB  */

	record NewCustomerRequest(Integer id, String name, Integer age, String email){};

	@PostMapping
	public void addCustomer(@RequestBody NewCustomerRequest newCustomerRequest)
	{
		Customer customer = new Customer();
		customer.setId(newCustomerRequest.id);
		customer.setName("Balaji");
		customer.setAge(29);
		customer.setEmail("Bala@gmail.com");

		customerRepository.save(customer);
	}

}
