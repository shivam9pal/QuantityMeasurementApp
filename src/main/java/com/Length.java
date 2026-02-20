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
    
    public Length convertTo(LengthUnit targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null.");
        }

        double baseValue = toBaseUnit();

        double convertedValue = baseValue / targetUnit.getConversionFactor();

        return new Length(round(convertedValue), targetUnit);
    }
    
    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
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
    
    
    //UC6
    
    public Length add(Length other) {
    	if(other==null) {
    		throw new IllegalArgumentException("other cant be null");
    	}
    	
    	
    	double baseSum=this.toBaseUnit()+other.toBaseUnit();
    	double thisSum=baseSum/this.unit.getConversionFactor();
    	return new Length(round(thisSum),this.unit);
    }
    //uc6 static overload method
    public static Length add(Length l1, Length l2) {
    	return l1.add(l2);
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
