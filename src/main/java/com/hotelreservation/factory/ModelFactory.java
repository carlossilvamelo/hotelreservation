package com.hotelreservation.factory;

import com.hotelreservation.models.Bridgewood;
import com.hotelreservation.models.Hotel;
import com.hotelreservation.models.Lakewood;
import com.hotelreservation.models.Ridgewood;

public class ModelFactory {

	public static Hotel getInstanceOfLakewood() {
		return new Lakewood();
	}

	public static Hotel getInstanceOfRidgewood() {
		return new Ridgewood();
	}

	public static Hotel getInstanceOfBridgewood() {
		return new Bridgewood();
	}

}
