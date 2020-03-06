package com.hotelreservation.factory;

import com.hotelreservation.service.impl.BridgewoodService;
import com.hotelreservation.service.impl.HotelReservationService;
import com.hotelreservation.service.impl.LakewookService;
import com.hotelreservation.service.impl.RidgewoodService;

public class ServiceFactory {

	public static LakewookService getLakewookService() {
		return new LakewookService();
	}

	public static HotelReservationService getHotelReservationService() {
		return new HotelReservationService();
	} 
	public static BridgewoodService getBridgewoodService() {
		return new BridgewoodService();
	}
	public static RidgewoodService getRidgewoodService() {
		return new RidgewoodService();
	}
	
}
