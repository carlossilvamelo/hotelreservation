package com.hotelreservation.controller;

import java.util.List;

import com.hotelreservation.factory.ServiceFactory;
import com.hotelreservation.service.IHotelReservationService;
import com.hotelreservation.utils.FileReaderUtil;

public class HotelReservationController {

	IHotelReservationService iHotelReservationService = ServiceFactory.getHotelReservationService();

	public void calculateBestHotelPrice() {
		List<String> inputs = FileReaderUtil.consumeInputFile();
		List<String> bestHotelsNames = iHotelReservationService.calculateBestHotelPrice(inputs);
		bestHotelsNames.forEach(System.out::println);
	}
}
