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
     * overloaded Method 2:
     * c	onvert using existing Length object.
     */
    public static Length demonstrateLengthConversion(
            Length length,
            LengthUnit toUnit) {

        return length.convertTo(toUnit);
    }

    public static void main(String[] args) {

    	  // conversion examples
        System.out.println(demonstrateLengthConversion(
                3.0, LengthUnit.FEET,
                LengthUnit.INCHES));  

        System.out.println(demonstrateLengthConversion(
                2.0,LengthUnit.YARDS,
                LengthUnit.INCHES));  

        Length cm = new Length(10.0, LengthUnit.CENTIMETERS);
        System.out.println(demonstrateLengthConversion(
                cm, LengthUnit.INCHES));

        // equality example
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(3.0, LengthUnit.FEET);

        System.out.println("Equal? " + demonstrateLengthEquality(yard, feet));
    }
	
	

}
