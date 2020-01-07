package com.hotelreservation.models;

import java.util.Map;

import com.hotelreservation.models.enumeration.CostumerType;

abstract public class Hotel implements Comparable<Hotel>{

	private String name;
	private Map<CostumerType, Double> normalTaxMap;
	private Map<CostumerType, Double> weekendTaxMap;
	private Integer classification;
	private Double calculatedPrice = 0.0;

	public Hotel() {

	}

	public Map<CostumerType, Double> getNormalTaxMap() {
		return normalTaxMap;
	}

	public void setNormalTaxMap(Map<CostumerType, Double> normalTaxMap) {
		this.normalTaxMap = normalTaxMap;
	}

	public Map<CostumerType, Double> getWeekendTaxMap() {
		return weekendTaxMap;
	}

	public void setWeekendTaxMap(Map<CostumerType, Double> weekendTaxMap) {
		this.weekendTaxMap = weekendTaxMap;
	}

	public Integer getClassification() {
		return classification;
	}

	public void setClassification(Integer classification) {
		this.classification = classification;
	}

	public Double getCalculatedPrice() {
		return calculatedPrice;
	}

	public void setCalculatedPrice(Double calculatedPrice) {
		this.calculatedPrice = calculatedPrice;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Hotel hotel) {
		if(this.getCalculatedPrice() == hotel.getCalculatedPrice()
				&& this.getClassification() > hotel.getClassification())
			return 0;
		
		if(this.getCalculatedPrice() < hotel.getCalculatedPrice()) {
			return -1;
		}else{
			if(this.getCalculatedPrice().equals(hotel.getCalculatedPrice())) {
				if(this.getClassification() > hotel.getClassification()) {
					return -1;
				}
			}
			
		}
		return 1;
	}

}
