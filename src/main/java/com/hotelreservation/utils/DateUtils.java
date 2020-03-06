package com.hotelreservation.utils;

import java.time.LocalDate;

public class DateUtils {

	public static boolean isWeekend(LocalDate date) {
		return date.getDayOfWeek().name().equals("SATURDAY") || date.getDayOfWeek().name().equals("SUNDAY");
	}
}
