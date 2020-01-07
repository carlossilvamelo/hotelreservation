package com.hotelreservation.models;

import java.util.HashMap;
import java.util.Map;

import com.hotelreservation.models.enumeration.CostumerType;

public class Ridgewood extends Hotel{
	private final Double SEMANAL_TAX_FOR_REGULAR_COSTUMER = 220.0;
	private final Double SEMANAL_TAX_FOR_REWARDS_COSTUMER = 100.0;
	
	private final Double WEEKEND_TAX_FOR_REGULAR_COSTUMER = 150.0;
	private final Double WEEKEND_TAX_FOR_REWARDS_COSTUMER = 40.0;
	private final Integer CLASSIFICATION = 5;
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

	public Ridgewood() {
		setName("Ridgewood");
		setNormalTaxMap(NORMAL_TAX_MAP);
		setWeekendTaxMap(WEEKEND_TAX_MAP);
		setClassification(CLASSIFICATION);
	}
}
