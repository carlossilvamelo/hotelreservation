package com.hotelreservation.models;

import java.util.HashMap;
import java.util.Map;

import com.hotelreservation.models.enumeration.CostumerType;

public class Bridgewood extends Hotel{
	
	private final Double SEMANAL_TAX_FOR_REGULAR_COSTUMER = 160.0;
	private final Double SEMANAL_TAX_FOR_REWARDS_COSTUMER = 110.0;
	
	private final Double WEEKEND_TAX_FOR_REGULAR_COSTUMER = 60.0;
	private final Double WEEKEND_TAX_FOR_REWARDS_COSTUMER = 50.0;
	private final Integer CLASSIFICATION = 4;
	private final Map<CostumerType, Double> NORMAL_TAX_MAP = new HashMap<CostumerType, Double>() {
		{
			put(CostumerType.REGULAR, SEMANAL_TAX_FOR_REGULAR_COSTUMER);
			put(CostumerType.REWARDS, SEMANAL_TAX_FOR_REWARDS_COSTUMER);
		}
	};
	
	private final Map<CostumerType, Double> WEEKEND_TAX_MAP = new HashMap<CostumerType, Double>() {

		{
			put(CostumerType.REGULAR, WEEKEND_TAX_FOR_REGULAR_COSTUMER);
			put(CostumerType.REWARDS, WEEKEND_TAX_FOR_REWARDS_COSTUMER);
		}
	};

	public Bridgewood() {
		setName("Bridgewood");
		setNormalTaxMap(NORMAL_TAX_MAP);
		setWeekendTaxMap(WEEKEND_TAX_MAP);
		setClassification(CLASSIFICATION);
	}
}
