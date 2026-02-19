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

    public static void main(String[] args) {

        demonstrateLengthComparison(1.0, LengthUnit.YARDS,
                                    3.0, LengthUnit.FEET);

        demonstrateLengthComparison(1.0, LengthUnit.YARDS,
                                    36.0, LengthUnit.INCHES);

        demonstrateLengthComparison(2.0, LengthUnit.YARDS,
                                    2.0, LengthUnit.YARDS);

        demonstrateLengthComparison(2.0, LengthUnit.CENTIMETERS,
                                    2.0, LengthUnit.CENTIMETERS);

        demonstrateLengthComparison(1.0, LengthUnit.CENTIMETERS,
                                    0.393701, LengthUnit.INCHES);
    }
	
	

}
