package com;

import java.util.Objects;

public class Length {
    	
	private final double value;
    private final LengthUnit unit;

    public Length(double value, LengthUnit unit) {

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    private double toBaseUnit() {
        return unit.getConversionFactor()*value;
    }

    public Boolean compare(Length that) {
    	return Double.compare(this.toBaseUnit(), that.toBaseUnit())==0;
    }
    
    @Override
    public boolean equals(Object obj) {

        // reflexive
        if (this == obj) return true;

        // null + Type check
        if (obj == null || getClass() != obj.getClass()) return false;

        Length other = (Length) obj;

        // convert both to base unit before comparing
        return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(toBaseUnit());
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
	
}
