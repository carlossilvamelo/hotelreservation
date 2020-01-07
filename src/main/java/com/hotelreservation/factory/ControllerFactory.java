package com.hotelreservation.factory;

import com.hotelreservation.controller.HotelReservationController;

public class ControllerFactory {

	public static HotelReservationController getInstanceOfHotelReservationController() {
		return new HotelReservationController();
	}
}
