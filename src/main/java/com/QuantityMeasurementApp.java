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
    
  //UC8 is Standalone LengthUnit class patter or we can say top level class 
    // which pattern is already followed in the QuantityMeasurementApp from beginning

  //UC9 adding weight  as well 
    
    public static  void demonstrateWeightImpl() {
    	System.out.println("\n Equality Comparisons ===");

        System.out.println(new Weight(1.0, WeightUnit.KILOGRAMS)
                .equals(new Weight(1.0, WeightUnit.KILOGRAMS)));
        System.out.println(new Weight(1.0, WeightUnit.KILOGRAMS)
                .equals(new Weight(1000.0, WeightUnit.GRAMS)));
        System.out.println(new Weight(2.0, WeightUnit.POUNDS)
                .equals(new Weight(2.0, WeightUnit.POUNDS)));
        System.out.println(new Weight(1.0, WeightUnit.KILOGRAMS)
                .equals(new Weight(2.20462, WeightUnit.POUNDS)));
        System.out.println(new Weight(500.0, WeightUnit.GRAMS)
                .equals(new Weight(0.5, WeightUnit.KILOGRAMS)));
        System.out.println(new Weight(1.0, WeightUnit.POUNDS)
                .equals(new Weight(453.592, WeightUnit.GRAMS)));



        System.out.println("\nUnit Conversions ===");

        System.out.println(new Weight(1.0, WeightUnit.KILOGRAMS)
                .convertTo(WeightUnit.GRAMS));
        System.out.println(new Weight(2.0, WeightUnit.POUNDS)
                .convertTo(WeightUnit.KILOGRAMS));
        System.out.println(new Weight(500.0, WeightUnit.GRAMS)
                .convertTo(WeightUnit.POUNDS));
        System.out.println(new Weight(0.0, WeightUnit.KILOGRAMS)
                .convertTo(WeightUnit.GRAMS));



        System.out.println(" Addition (Implicit Target Unit) ===");
        System.out.println(new Weight(1.0, WeightUnit.KILOGRAMS)
                .add(new Weight(2.0, WeightUnit.KILOGRAMS)));
        System.out.println(new Weight(1.0, WeightUnit.KILOGRAMS)
                .add(new Weight(1000.0, WeightUnit.GRAMS)));
        System.out.println(new Weight(500.0, WeightUnit.GRAMS)
                .add(new Weight(0.5, WeightUnit.KILOGRAMS)));



        System.out.println("\nAddition (Explicit Target Unit) ===");
        System.out.println(new Weight(1.0, WeightUnit.KILOGRAMS)
                .add(new Weight(1000.0, WeightUnit.GRAMS),
                        WeightUnit.GRAMS));
        System.out.println(new Weight(1.0, WeightUnit.POUNDS)
                .add(new Weight(453.592, WeightUnit.GRAMS),
                        WeightUnit.POUNDS));
        System.out.println(new Weight(2.0, WeightUnit.KILOGRAMS)
                .add(new Weight(4.0, WeightUnit.POUNDS),
                        WeightUnit.KILOGRAMS));



        System.out.println("\nCategory Incompatibility ");

        System.out.println(new Weight(1.0, WeightUnit.KILOGRAMS)
                .equals(new Length(1.0, LengthUnit.FEET)));
    }
    
    
    
    
    
    
    public static void main(String[] args) {

    	demonstrateWeightImpl();
    	
        
        
    }
	
    
    
    
    
    
    

}
