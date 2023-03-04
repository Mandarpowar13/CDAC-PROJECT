package com.trekappAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.trekappAPI.entity.Treks;
import com.trekappAPI.repo.TreksRepo;
import com.trekappAPI.services.TreksServices;
import com.trekappAPI.user.UserRepository;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:3000/")
public class AuthController {

    
    @Autowired
    private TreksServices services;
    @Autowired
	private TreksRepo repo;

    @Autowired
    private UserRepository userRepository;




   


     
    
    @GetMapping("/showtreks")
    
    public List<Treks> findAllTreks(){
   	 return services.gettreks();
    }
@GetMapping("/showtreks/{id}")
    
    public Treks findTreks(@PathVariable Long id){
   	 return repo.findById(id).orElse(null);
    }
    
    @PostMapping("/addtrek")
    public Treks addTrek(@RequestBody Treks trek) {
   	 return services.saveTreks(trek);
  
   	 
    }
    
    @GetMapping("/trekbyID/{id}")
    public Treks findTrekById(@PathVariable Long id) {
   	 return services.getTreksById(id);
    }
    @GetMapping("/trek/{name}")
    public List<Treks> findTrekByName(@PathVariable String name) {
   	 return services.getTreksByName(name);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Treks> updateTrek(@PathVariable Long id ,@RequestBody Treks trek) {
     Treks exiTrek = repo.findById(id).orElse(null);
		
		exiTrek.setName(trek.getName());
		exiTrek.setDescrip(trek.getDescrip());
		exiTrek.setPrice(trek.getPrice());
		exiTrek.setImgUrl(trek.getImgUrl());
		exiTrek.setImgUrl1(trek.getImgUrl1());
		exiTrek.setImgUrl2(trek.getImgUrl2());
		exiTrek.setImgUrl3(trek.getImgUrl3());
		exiTrek.setImgUrl4(trek.getImgUrl4());
	
		Treks updateTrek = repo.save(exiTrek);
    	return ResponseEntity.ok(updateTrek);
   	 
    }
    
    @DeleteMapping("/delete/{id}")
    public String deleteTrek(@PathVariable Long id) {
    	userRepository.deleteById(id);
		return "User removed" + id;
   	
    }
    
}
