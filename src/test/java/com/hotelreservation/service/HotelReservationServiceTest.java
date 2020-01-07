package com.hotelreservation.service;

import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import com.hotelreservation.factory.ServiceFactory;

@RunWith(JUnit4.class)
public class HotelReservationServiceTest {

	private IHotelReservationService service = ServiceFactory.getHotelReservationService();
	
	@Test
	public void calculateBestHotelPriceTestShouldReturnRightHotels() {
		List<String> names = Arrays.asList("Lakewood", "Bridgewood", "Ridgewood");
		List<String> bestHotelsNames = service.calculateBestHotelPrice(getInputs());
		
		for (int i=0 ; i < bestHotelsNames.size() ; i++) {
			assertTrue(bestHotelsNames.get(i).equals(names.get(i)));
		}
	}
	private List<String> getInputs(){
		return Arrays.asList("Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)"
				,"Regular: 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)"
				,"Rewards: 26Mar2009(thur), 27Mar2009(fri), 28Mar2009(sat)");
	}
}
