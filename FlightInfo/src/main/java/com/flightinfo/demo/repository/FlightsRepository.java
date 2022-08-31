package com.flightinfo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightinfo.demo.model.Flight;

@Repository
public interface FlightsRepository extends JpaRepository<Flight, Long> {
	

}
