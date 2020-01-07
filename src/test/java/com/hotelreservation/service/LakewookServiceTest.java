package com.hotelreservation.service;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import com.hotelreservation.factory.ServiceFactory;
import com.hotelreservation.models.Hotel;
import com.hotelreservation.models.enumeration.CostumerType;
import com.hotelreservation.service.impl.LakewookService;
import com.hotelreservation.utils.InputPreProcessingUtil;

@RunWith(JUnit4.class)
public class LakewookServiceTest {
	private LakewookService lakewookService = ServiceFactory.getLakewookCalculator();

	@Test
	public void calculatePriceTestShouldReturnRightPrice() {
		Double[] rightPrices = { 330.0, 290.0, 240.0 };
		List<String> inputs = getInputs();
		List<Hotel> hotels = new ArrayList<Hotel>();

		for (String input : inputs) {
			List<LocalDate> dates = InputPreProcessingUtil.extractListOfDays(input);
			CostumerType costumerType = InputPreProcessingUtil.extractCostumerType(input);
			hotels.add(lakewookService.calculatePrice(costumerType, dates));
		}
		for (int i = 0; i < hotels.size(); i++) {
			assertEquals(hotels.get(i).getCalculatedPrice(), rightPrices[i]);
		}

	}

	private List<String> getInputs() {
		return Arrays.asList("Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)",
				"Regular: 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)",
				"Rewards: 26Mar2009(thur), 27Mar2009(fri), 28Mar2009(sat)");
	}
}
