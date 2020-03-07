package com.hotelreservation.service;

import java.util.List;

import com.hotelreservation.models.Hotel;

public interface IHotelReservationService {

	public List<String> calculateBestHotelPrice(List<String> inputs);
	public List<Hotel> calculateBestHotel(List<String> inputs);
}
