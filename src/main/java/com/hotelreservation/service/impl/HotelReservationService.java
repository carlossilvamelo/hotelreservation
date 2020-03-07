package com.hotelreservation.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.hotelreservation.factory.ServiceFactory;
import com.hotelreservation.models.Hotel;
import com.hotelreservation.models.enumeration.CostumerType;
import com.hotelreservation.service.HotelServiceStrategy;
import com.hotelreservation.service.IHotelReservationService;
import com.hotelreservation.utils.InputPreProcessingUtil;

public class HotelReservationService implements IHotelReservationService {

	List<HotelServiceStrategy> hotelServiceList = Arrays.asList(ServiceFactory.getLakewookService(),
			ServiceFactory.getBridgewoodService(), ServiceFactory.getRidgewoodService());

	@Override
	public List<String> calculateBestHotelPrice(List<String> inputs) {
		List<String> bestHotels = new ArrayList<String>();

		for (String input : inputs) {
			CostumerType costumerType = InputPreProcessingUtil.extractCostumerType(input);
			List<LocalDate> dates = InputPreProcessingUtil.extractListOfDays(input);
			List<Hotel> hotels = new ArrayList<Hotel>();
		
			for (HotelServiceStrategy service : hotelServiceList) {
				hotels.add(service.calculatePrice(costumerType, dates));
			}
			if (hotels.isEmpty())
				throw new RuntimeException("Empty input");

			Collections.sort(hotels, (first, sec) -> first.compareTo(sec));
			bestHotels.add(hotels.get(0).getName());

		}
		return bestHotels;

	}

	@Override
	public List<Hotel> calculateBestHotel(List<String> inputs) {
		List<String> bestHotels = new ArrayList<String>();

		List<Hotel> hotels = new ArrayList<Hotel>();
		for (String input : inputs) {
			CostumerType costumerType = InputPreProcessingUtil.extractCostumerType(input);
			List<LocalDate> dates = InputPreProcessingUtil.extractListOfDays(input);
		
			for (HotelServiceStrategy service : hotelServiceList) {
				hotels.add(service.calculatePrice(costumerType, dates));
			}
			if (hotels.isEmpty())
				throw new RuntimeException("Empty input");

			Collections.sort(hotels, (first, sec) -> first.compareTo(sec));

		}
		return hotels;
	}

}
