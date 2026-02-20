package com;

public class QuantityMeasurementApp {

	
	
	public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }
	

    public static void demonstrateLengthComparison(
            double value1, LengthUnit unit1,
            double value2, LengthUnit unit2) {

        Length l1 = new Length(value1, unit1);
        Length l2 = new Length(value2, unit2);

        System.out.println(l1 + " and " + l2 +
                " -> Equal (" + l1.equals(l2) + ")");
    }
    
    
    public static Length demonstrateLengthConversion(double value, LengthUnit fromUnit, LengthUnit toUnit) {
    	Length length=new Length(value,fromUnit);
    	return length.convertTo(toUnit);
    }
    
    
    /**
     * overloaded method 2
     * convert using existing Length object.
     */
    public static Length demonstrateLengthConversion(
            Length length,
            LengthUnit toUnit) {

        return length.convertTo(toUnit);
    }
    
    //UC6
    public static Length demonstrateAddition(Length l1, Length l2) {
    	return l1.add(l2);
    }
    
    //UC7 Target Unit addition
    public static Length demonstrateLengthAddition(
            Length length1,
            Length length2,
            LengthUnit targetUnit) {

        return length1.add(length2, targetUnit);
    }

    public static void main(String[] args) {


    	System.out.println(
                demonstrateLengthAddition(
                        new Length(1.0, LengthUnit.FEET),
                        new Length(12.0, LengthUnit.INCHES),
                        LengthUnit.YARDS));
        
        
    }
	//UC8 is Standalone LengthUnit class patter or we can say top level class 
    // which pattern is already followed in the QuantityMeasurementApp from begining
    
    //UC9
	

}
