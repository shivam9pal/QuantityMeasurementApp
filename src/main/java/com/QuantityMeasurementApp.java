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

    public static void main(String[] args) {


    	 System.out.println(
                 demonstrateAddition(
                         new Length(1.0, LengthUnit.FEET),
                         new Length(12.0, LengthUnit.INCHES)));

         System.out.println(
                 demonstrateAddition(
                         new Length(12.0, LengthUnit.INCHES),
                         new Length(1.0, LengthUnit.FEET)));

         System.out.println(
                 demonstrateAddition(
                         new Length(1.0, LengthUnit.YARDS),
                         new Length(3.0, LengthUnit.FEET)));
        
        
    }
	
	

}
