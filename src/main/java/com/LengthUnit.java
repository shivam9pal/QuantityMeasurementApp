package com;

public enum LengthUnit {
	FEET(1.0),
	INCHES(12.0),
	YARDS(36.0),             // 1 yd = 36 inches 
    CENTIMETERS(0.393701);// 1 cm=0.3 inches 
	
	private final double conversionFactor;
	
	LengthUnit(double conversionFactor){
		this.conversionFactor=conversionFactor;
	}
	
	public double getConversionFactor() {
		return conversionFactor;
	}
}
