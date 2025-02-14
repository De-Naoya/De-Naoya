package com.example.moattravel_3.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.moattravel_3.entity.House;
import com.example.moattravel_3.entity.Reservation;
import com.example.moattravel_3.entity.User;
import com.example.moattravel_3.repository.HouseRepository;
import com.example.moattravel_3.repository.ReservationRepository;
import com.example.moattravel_3.repository.UserRepository;

@Service
public class ReservationService {

	private final ReservationRepository reservationRepository;
	private final HouseRepository houseRepository;
	private final UserRepository userRepository;

	public ReservationService(ReservationRepository reservationRepository, HouseRepository houseRepository,
			UserRepository userRepository) {
		this.reservationRepository = reservationRepository;
		this.houseRepository = houseRepository;
		this.userRepository = userRepository;
	}

	@Transactional
	public void create(Map<String, String> paymentIntentObject) {
		Reservation reservation = new Reservation();
		Integer houseId = Integer.valueOf(paymentIntentObject.get("houseId"));
		Integer userId = Integer.valueOf(paymentIntentObject.get("userId"));
		House house = houseRepository.getReferenceById(houseId);
		User user = userRepository.getReferenceById(userId);
		LocalDate checkinDate = LocalDate.parse(paymentIntentObject.get("CheckinDate"));
		LocalDate checkoutDate = LocalDate.parse(paymentIntentObject.get("CheckoutDate"));
		Integer numberOfPeople = Integer.valueOf(paymentIntentObject.get("numberOfPeople"));
		Integer amount = Integer.valueOf(paymentIntentObject.get("amount"));
		reservation.setHouse(house);
		reservation.setUser(user);
		reservation.setCheckinDate(checkinDate);
		reservation.setCheckoutDate(checkoutDate);
		reservation.setNumberOfPeople(numberOfPeople);
		reservation.setAmount(amount);
		reservationRepository.save(reservation);
	}

	public boolean isWithinCapacity(Integer numberOfPeople, Integer capacity) {
		return numberOfPeople <= capacity;
	}

	public Integer calculateAmount(LocalDate checkinDate, LocalDate checkoutDate, Integer price) {
		long numberOfNights = ChronoUnit.DAYS.between(checkinDate, checkoutDate);
		int amount = price * (int) numberOfNights;
		return amount;
	}
}
