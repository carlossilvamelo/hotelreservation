package com.hotelreservation.models;

import java.util.HashMap;
import java.util.Map;

import com.hotelreservation.models.enumeration.CostumerType;

public class Lakewood extends Hotel {
	
	private final Double SEMANAL_TAX_FOR_REGULAR_COSTUMER = 110.0;
	private final Double SEMANAL_TAX_FOR_REWARDS_COSTUMER = 80.0;
	
	private final Double WEEKEND_TAX_FOR_REGULAR_COSTUMER = 90.0;
	private final Double WEEKEND_TAX_FOR_REWARDS_COSTUMER = 80.0;
	private final Integer CLASSIFICATION = 3;
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

	public Lakewood() {
		setName("Lakewood");
		setNormalTaxMap(NORMAL_TAX_MAP);
		setWeekendTaxMap(WEEKEND_TAX_MAP);
		setClassification(CLASSIFICATION);
	}

}
