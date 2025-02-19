package com.example.moattravel_4.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

@Service
public class ReservationService {
	public boolean isWithinCapacity(Integer numberOfPeople,Integer capacity) {
		return numberOfPeople <= capacity;
	}
	public Integer calculateAmount(LocalDate checkinDate,LocalDate checkoutDate,Integer price) {
		long numberOfNights = ChronoUnit.DAYS.between(checkinDate, checkoutDate);
		int amount = price * (int)numberOfNights;
		return amount;
	}

}
