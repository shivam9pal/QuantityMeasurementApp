package com;

public class QuantityMeasurementApp {
	

	public static class Feet {

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

	        //Check null or type mismatch
	        if (obj == null || getClass() != obj.getClass()) {
	            return false;
	        }

	        //Cast safely
	        Feet other = (Feet) obj;

	        //Compare double values correctly
	        return Double.compare(this.value, other.value) == 0;
	    }

	    
	    @Override
	    public int hashCode() {
	        return Double.hashCode(value);
	    }
	}

}
