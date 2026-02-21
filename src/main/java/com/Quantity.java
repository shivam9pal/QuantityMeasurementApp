package com;

public class Quantity<U extends IMeasurable> {
	private double value;
	private U unit;
	
	
	private static final double EPSILON = 1e-5;

	public Quantity(double value, U unit){
		if (unit == null)
		    throw new IllegalArgumentException("Unit cannot be null");

		if (!Double.isFinite(value))
		    throw new IllegalArgumentException("Value must be finite");
		
		this.value=value;
		this.unit=unit;
	}
	
	public double getValue() {
		return value;
	}
	
	public U getUnit() {
		return unit;
	}
	
	public double toBaseUnit() {
		return unit.convertToBaseUnit(value);
	}
	
	public Quantity<U> convertTo(U targetUnit) {
		if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null");
		
		 double base = toBaseUnit();
	        double converted = targetUnit.convertFromBaseUnit(base);

	        return new Quantity<>(converted, targetUnit);
            
		
	}
	
	public Quantity<U> add(Quantity<U> other) {
        if (other == null)
            throw new IllegalArgumentException("Other cannot be null");

        double sumBase = this.toBaseUnit() + other.toBaseUnit();
        double result = unit.convertFromBaseUnit(sumBase);

        return new Quantity<>(result, unit);
    }
	
	public Quantity<U> add(Quantity<U> other, U targetUnit) {
        if (other == null)
            throw new IllegalArgumentException("Other cannot be null");
        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double sumBase = this.toBaseUnit() + other.toBaseUnit();
        double result = targetUnit.convertFromBaseUnit(sumBase);

        return new Quantity<>(result, targetUnit);
    }
	
	//Subtraction Methods 
	public Quantity<U> subtract(Quantity<U> other){
		if (other == null) throw new IllegalArgumentException("Other cannot be null");
		
		validateSameCategory(other);
		double baseResult = this.toBaseUnit() - other.toBaseUnit();
        double converted = unit.convertFromBaseUnit(baseResult);

        return new Quantity<>(round(converted), unit);
	}
	
	public Quantity<U> subtract(Quantity<U> other, U targetUnit) {
        if (other == null)
            throw new IllegalArgumentException("Other cannot be null");

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        validateSameCategory(other);

        double baseResult = this.toBaseUnit() - other.toBaseUnit();
        double converted = targetUnit.convertFromBaseUnit(baseResult);

        return new Quantity<>(round(converted), targetUnit);
    }
	
	//division
	 public double divide(Quantity<U> other) {
	        if (other == null)
	            throw new IllegalArgumentException("Other cannot be null");

	        validateSameCategory(other);

	        double divisor = other.toBaseUnit();

	        if (Math.abs(divisor) < EPSILON)
	            throw new ArithmeticException("Division by zero");

	        return this.toBaseUnit() / divisor;
	    }
	
	
	
	
	
	
	
	
	private double round(double value) {
		return Math.round(value*100.0)/100.0; // for two decimal places 
	}

	private void validateSameCategory(Quantity<U> other) {
		if (!this.unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Cross-category operation not allowed");	
	}

	@Override
	public boolean equals(Object obj) {

	    if (this == obj) return true;
	    if (!(obj instanceof Quantity<?> other)) return false;

	    // Prevent cross category comparison
	    if (!unit.getClass().equals(other.unit.getClass()))
	        return false;

	    return Math.abs(this.toBaseUnit() - other.toBaseUnit()) <= EPSILON;
	}
	
	@Override
    public int hashCode() {
        long rounded = Math.round(toBaseUnit() / EPSILON);
        return Long.hashCode(rounded);
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit.getUnitName() + ")";
    }
	
	

}
