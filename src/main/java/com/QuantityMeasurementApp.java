package com;

public class QuantityMeasurementApp {

	
	
	public static void main(String[] args) {
		Length q1 = new Length(1.0, LengthUnit.FEET);
        Length q2 = new Length(12.0, LengthUnit.INCHES);

        System.out.println("Input: " + q1 + " and " + q2);
        System.out.println("Output: Equal (" + q1.equals(q2) + ")");

        Length q3 = new Length(1.0, LengthUnit.INCHES);
        Length q4 = new Length(1.0, LengthUnit.INCHES);

        System.out.println("Input: " + q3 + " and " + q4);
        System.out.println("Output: Equal (" + q3.equals(q4) + ")");
	}
	
	

}
