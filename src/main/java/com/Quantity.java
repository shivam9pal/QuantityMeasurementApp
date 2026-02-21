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
