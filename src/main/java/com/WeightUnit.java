package com;

public enum WeightUnit {
	KILOGRAMS(1.0),
	GRAMS(0.001),
	POUNDS(0.453592);
	
	private final double conversionFactor;
	
	WeightUnit(double value) {
		this.conversionFactor=value;
	}
	
	public double getConversionFactor() {
		return conversionFactor;
	}
	
	public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }
}
