package com.trekappAPI.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trekappAPI.entity.Treks;






public interface TreksRepo extends JpaRepository<Treks, Long> {

	List<Treks> findByName(String name);

	
	
	

	

}
