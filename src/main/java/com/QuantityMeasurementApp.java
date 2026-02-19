package com;

public class QuantityMeasurementApp {


	public static  class Feet {
		
	    private final double value;

	    
	    public Feet(double value) {
	        this.value = value;
	    }

	    public double getValue() {
	        return value;
	    }

	    
	    @Override
	    public boolean equals(Object obj) {

	        //Check same reference 
	        if (this == obj) {
	            return true;
	        }

	        //  Check null or type mismatch
	        if (obj == null || getClass() != obj.getClass()) {
	            return false;
	        }

	        //  Cast safely
	        Feet other = (Feet) obj;

	        // Compare double values correctly
	        return Double.compare(this.value, other.value) == 0;
	    }

	    
	    @Override
	    public int hashCode() {
	        return Double.hashCode(value);
	    }
	}
	
	
	


	public static class Inches {

	    private final double value;

	    public Inches(double value) {
	        this.value = value;
	    }

	    @Override
	    public boolean equals(Object obj) {

	        if (this == obj) return true;

	        if (obj == null || getClass() != obj.getClass()) return false;

	        Inches other = (Inches) obj;

	        return Double.compare(this.value, other.value) == 0;
	    }

	    @Override
	    public int hashCode() {
	        return Double.hashCode(value);
	    }
	    
	    public boolean compareInches(double value1, double value2) {
	        Inches inch1 = new Inches(value1);
	        Inches inch2 = new Inches(value2);
	        return inch1.equals(inch2);
	    }
	}



	//static methods
	
	 public static boolean compareFeet(double value1, double value2) {
	        Feet feet1 = new Feet(value1);
	        Feet feet2 = new Feet(value2);
	        return feet1.equals(feet2);
	    }

	    public static boolean compareInches(double value1, double value2) {
	        Inches inch1 = new Inches(value1);
	        Inches inch2 = new Inches(value2);
	        return inch1.equals(inch2);
	    }


}
