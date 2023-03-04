package com.trekappAPI.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trekappAPI.entity.Bookings;
import com.trekappAPI.entity.Customer;
import com.trekappAPI.repo.BookingRepo;
import com.trekappAPI.repo.CustomerRepo;
import com.trekappAPI.user.Status;
import com.trekappAPI.user.User;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/cus")
public class CustomerController {
	@Autowired
	CustomerRepo repo;
	
	@Autowired
	BookingRepo Brepo;
	@PostMapping("/signup")
	public String signup(@RequestBody Customer newCustomer) {
		List<Customer> customers = repo.findAll();
		for(Customer cust: customers ) {
			if(cust.equals(newCustomer)) {
				return "USER ALREADY EXISTS";
			}
		}
		repo.save(newCustomer);
		return "SIGUNED UP!";
	}
	
	
	 @PostMapping("/login")
	    public String loginUser( @RequestBody Customer customer) {
	        List<Customer> customers = repo.findAll();

	        for (Customer other : customers) {
	            if (other.equals(customer)) {
	            	
	                //userRepository.save(user);
	                return "SUCCESS!";
	            }
	        }

	        return "FAILURE";
	    }
	 
	 @GetMapping("/viewall")
	    public List<Customer> getCust(){
			return repo.findAll();
		}
	 
	 @GetMapping("/{id}")
	    public Customer getUserbyId(@PathVariable Long id) {
			return repo.findById(id).orElse(null);
		}
	
	 @DeleteMapping("/delete/{id}")
	    public String deleteCust(@PathVariable Long id) {
	   	  repo.deleteById(id);
	   	return "customer removed" + id;
	    }
	 
	 @PutMapping("/update/{id}")
	    public ResponseEntity<Customer> updateTrek(@PathVariable Long id ,@RequestBody Customer customer) {
	     Customer exiCust = repo.findById(id).orElse(null);
			
	     exiCust.setEmail(customer.getEmail());
	     exiCust.setPassword(customer.getPassword());
	     exiCust.setName(customer.getName());
			
		
			Customer updateCust = repo.save(exiCust);
	    	return ResponseEntity.ok(updateCust);
	   	 	
	    	
	    }
	 
	
	 
	
	
}
