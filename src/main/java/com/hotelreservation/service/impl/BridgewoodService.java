package com.hotelreservation.service.impl;

import java.time.LocalDate;
import java.util.List;

import com.hotelreservation.factory.ModelFactory;
import com.hotelreservation.models.Hotel;
import com.hotelreservation.models.enumeration.CostumerType;
import com.hotelreservation.service.HotelServiceStrategy;

public class BridgewoodService implements HotelServiceStrategy {

	@Override
	public Hotel calculatePrice(CostumerType costumerType, List<LocalDate> dates) {
		Hotel hotel = generateInstance();
		Double price = 0.0;
		for (LocalDate date : dates) {
			if (date.getDayOfWeek().name().equals("SATURDAY") || date.getDayOfWeek().name().equals("SUNDAY")) {
				price += hotel.getWeekendTaxMap().get(costumerType);
			} else {
				price += hotel.getNormalTaxMap().get(costumerType);
			}
		}
		hotel.setCalculatedPrice(price);
		return hotel;
	}

	@Override
	public Hotel generateInstance() {
		return ModelFactory.getInstanceOfBridgewood();
	}

}
