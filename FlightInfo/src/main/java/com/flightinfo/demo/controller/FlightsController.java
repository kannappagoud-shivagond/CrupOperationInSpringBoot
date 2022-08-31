package com.flightinfo.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.flightinfo.demo.exception.ResourceNotFoundException;
import com.flightinfo.demo.model.Flight;
import com.flightinfo.demo.repository.FlightsRepository;



@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200/")
public class FlightsController {
	
	@Autowired
	private FlightsRepository flightsRepository;
	
	//get all flights
	
	@GetMapping("/flights")
	public List<Flight> getAllFlights(){
		return flightsRepository.findAll();
		
		
	}
	//create flight in rest api
	@PostMapping("/flights")
	public Flight createFlight(@RequestBody Flight flight) {
		return flightsRepository.save(flight);
	}
	// get Flight by id rest api
		@GetMapping("/flights/{number}")
		public ResponseEntity<Flight> getFlightById(@PathVariable Long id) {
			Flight flights = flightsRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Flight not exist with id :" + id));
			return ResponseEntity.ok(flights);
		}
		
		// update flight rest api
		
		@PutMapping("/flights/{number}")
		public ResponseEntity<Flight> updateFlight(@PathVariable Long number, @RequestBody Flight flightsDetails){
			Flight flights = flightsRepository.findById(number)
					.orElseThrow(() -> new ResourceNotFoundException("Flight not exist with id :" + number));
			
			flights.setFlightNumber(flightsDetails.getFlightNumber());
			flights.setFlightName(flightsDetails.getFlightName());
			flights.setAirportName(flightsDetails.getAirportName());
			flights.setPassengerName(flightsDetails.getPassengerName());
			
			
			Flight updatedFlight = flightsRepository.save(flights);
			return ResponseEntity.ok(updatedFlight);
		}
		
		//delete flight rest api
		@DeleteMapping("/flights/{number}")
		public ResponseEntity<Map<String,Boolean>> deleteFlight(@PathVariable long number){
			Flight flights = flightsRepository.findById(number)
					.orElseThrow(() -> new ResourceNotFoundException("Flight not exist with id :" + number));
			
			flightsRepository.delete(flights);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
			
			
		}
	
}
