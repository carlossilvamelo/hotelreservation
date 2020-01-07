package com.hotelreservation.service;

import java.time.LocalDate;
import java.util.List;

import com.hotelreservation.models.Hotel;
import com.hotelreservation.models.enumeration.CostumerType;

public interface HotelServiceStrategy {

	public Hotel calculatePrice(CostumerType costumerType, List<LocalDate> dates);
	public Hotel generateInstance();
}
