package com.hotelreservation;

import com.hotelreservation.controller.HotelReservationController;
import com.hotelreservation.factory.ControllerFactory;

public class HotelReservationApp {

	public static void main(String[] args) {
		HotelReservationController HotelReservationController = ControllerFactory
				.getInstanceOfHotelReservationController();
		
		HotelReservationController.calculateBestHotelPrice();
		
	}

}
