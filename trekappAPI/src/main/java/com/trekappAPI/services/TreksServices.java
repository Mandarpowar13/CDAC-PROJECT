package com.trekappAPI.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trekappAPI.entity.Treks;
import com.trekappAPI.repo.TreksRepo;




@Service
public class TreksServices {
	
	@Autowired
	private TreksRepo repo;
	
	public Treks saveTreks(Treks trek) {
		return repo.save(trek);
		
	}
	
	public List<Treks> saveTrek(List<Treks> trek){
		return repo.saveAll(trek);
	}
	public List<Treks> gettreks(){
		return repo.findAll();
	}
	
	public Treks getTreksById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public List<Treks> getTreksByName(String name) {
		return repo.findByName(name);
	}
	
	public String deletetrek(Long id) {
		repo.deleteById(id);
		return "Trek removed" + id;
		
	}
	
	public Treks updateTrek(Long id, Treks trek) {
		Treks exiTrek = repo.findById(id).get();
		
		exiTrek.setName(trek.getName());
		exiTrek.setDescrip(trek.getDescrip());
		exiTrek.setPrice(trek.getPrice());
		exiTrek.setImgUrl(trek.getImgUrl());
		exiTrek.setImgUrl1(trek.getImgUrl1());
		exiTrek.setImgUrl2(trek.getImgUrl2());
		exiTrek.setImgUrl3(trek.getImgUrl3());
		exiTrek.setImgUrl4(trek.getImgUrl4());
		return repo.save(exiTrek);
	}
}
