package com.flightinfo.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Flights")
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long FlightNumber;
	
	@Column(name = "FlightName")
	private String FlightName;
	
	@Column(name = "AirportName")
	private String AirportName;
	
	@Column(name = "PassengerName")
	private String PassengerName;
	
	public Flight() {
		
	}
	
	public Flight(String flightName, String airportName, String passengerName) {
		super();
		FlightName = flightName;
		AirportName = airportName;
		PassengerName = passengerName;
	}
	public long getFlightNumber() {
		return FlightNumber;
	}
	public void setFlightNumber(long flightNumber) {
		FlightNumber = flightNumber;
	}
	public String getFlightName() {
		return FlightName;
	}
	public void setFlightName(String flightName) {
		FlightName = flightName;
	}
	public String getAirportName() {
		return AirportName;
	}
	public void setAirportName(String airportName) {
		AirportName = airportName;
	}
	public String getPassengerName() {
		return PassengerName;
	}
	public void setPassengerName(String passengerName) {
		PassengerName = passengerName;
	}
	
}
