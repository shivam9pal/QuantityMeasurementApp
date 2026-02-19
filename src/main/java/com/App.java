package com;

import com.QuantityMeasurementApp.Feet;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	QuantityMeasurementApp.Feet value1 = new Feet(1.0);
    	QuantityMeasurementApp.Feet value2 = new Feet(1.0);

    	boolean inchResult = QuantityMeasurementApp.compareInches(1.0, 1.0);
        System.out.println("Input: 1.0 inch and 1.0 inch");
        System.out.println("Output: Equal (" + inchResult + ")");

        boolean feetResult = QuantityMeasurementApp.compareFeet(1.0, 1.0);
        System.out.println("Input: 1.0 ft and 1.0 ft");
        System.out.println("Output: Equal (" + feetResult + ")");
        
        
        

        
        
    }
}
