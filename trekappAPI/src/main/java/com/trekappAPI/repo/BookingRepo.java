package com.trekappAPI.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trekappAPI.entity.Bookings;

import jakarta.transaction.Transactional;

public interface BookingRepo extends JpaRepository<Bookings, Long> {
  
	//@Query(value="SELECT * FROM BOOKINGS WHERE CID = (:CID)")
	List<Bookings> findByCustomerCid( Long cid);
	
	/*@Query(value="SELECT * FROM BOOKINGS WHERE tid = (:tid)")*/
    List<Bookings> findByTrekTid(Long tid);
  
}
