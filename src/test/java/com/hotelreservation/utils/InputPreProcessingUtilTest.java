package com.hotelreservation.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import com.hotelreservation.models.enumeration.CostumerType;

@RunWith(JUnit4.class)
public class InputPreProcessingUtilTest {

	
	@Test
	public void extractCostumerTypeTestShouldReturnRightCostumer() {
		
		CostumerType[] rightTypes = {CostumerType.REGULAR, CostumerType.REGULAR, CostumerType.REWARDS};
		List<String> inputs = getInputs();
		
		for (int i=0 ; i < inputs.size() ; i++) {
			CostumerType CostumerType = InputPreProcessingUtil.extractCostumerType(inputs.get(i));
			assertEquals(rightTypes[i].name(), CostumerType.name());
		}
	}
	
	@Test
	public void extractListOfDaysShouldReturnTheRightDate() {
		String input = "Regular: 16Mar2009(mon), 17Jan2009(tues), 18Mar2009(wed)";
		List<LocalDate> rightDates = Arrays.asList(LocalDate.of(2009, Month.MARCH, 16),
				LocalDate.of(2009, Month.JANUARY, 17),
				LocalDate.of(2009, Month.MARCH, 18));
		
		List<LocalDate> resultDates = InputPreProcessingUtil.extractListOfDays(input);
		for (int i=0 ; i < resultDates.size() ; i++) {
			assertTrue(resultDates.get(i).equals(rightDates.get(i)));
		}
	}
	
	
	private List<String> getInputs(){
		return Arrays.asList("Regular: 16Mar2009(mon), 17Mar2009(tues), 18Mar2009(wed)"
				,"Regular: 20Mar2009(fri), 21Mar2009(sat), 22Mar2009(sun)"
				,"Rewards: 26Mar2009(thur), 27Mar2009(fri), 28Mar2009(sat)");
	}
}
