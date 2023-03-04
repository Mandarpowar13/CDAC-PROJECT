package com.trekappAPI.controller;

import java.util.List;
import java.util.Set;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trekappAPI.entity.Bookings;
import com.trekappAPI.entity.Customer;
import com.trekappAPI.entity.Treks;
import com.trekappAPI.repo.BookingRepo;
import com.trekappAPI.repo.CustomerRepo;
import com.trekappAPI.repo.TreksRepo;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/bookings")
public class BookingController {
	
	@Autowired
	private BookingRepo repo;
	@Autowired
	private CustomerRepo crepo;
	@Autowired
	private TreksRepo trepo;
	
	@GetMapping("/viewall")
	public  List<Bookings> viewAllBooking(){
		return repo.findAll();
	}
	
	@GetMapping("/viewByCust/{id}")
	public ResponseEntity<List<Bookings>>getbookingByCID(@PathVariable(value = "id") Long id){
		List<Bookings> booking = repo.findByCustomerCid(id);
		
		return new ResponseEntity<>(booking,HttpStatus.OK) ;
	}
	@GetMapping("/viewByTrek/{id}")
	public ResponseEntity<List<Bookings>>getbookingByTID(@PathVariable Long id){
		
         List<Bookings> booking = repo.findByTrekTid(id);
		
		return new ResponseEntity<>(booking,HttpStatus.OK) ;
	}
	
	@PostMapping("/addBooking/{cid}/{tid}")
	public  ResponseEntity<Bookings> addbooking(@PathVariable(value = "cid") Long cid ,
			@PathVariable(value = "tid") Long tid,
			@RequestBody Bookings booking ) {
		Treks trek = trepo.findById(tid).orElse(null);
		Bookings bookings = crepo.findById(cid).map(customer ->{
			booking.setTrek(trek);
		booking.setCustomer(customer);
		return repo.save(booking);
		
		
		}).orElse(null);
		return new ResponseEntity<>(bookings,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBooking(@PathVariable("id") Long id) {
		repo.deleteById(id);

		return "Booking Deleted" + id;
	}
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	
}
