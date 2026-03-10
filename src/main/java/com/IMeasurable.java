package com;


@FunctionalInterface
interface SupportsArithmetic{
	boolean isSupported();
}


public interface IMeasurable {
	
	
	// Default lambda – arithmetic supported
    SupportsArithmetic supportsArithmetic = () -> true;
	
	
	double getConversionFactor();
	
	double convertToBaseUnit(double value);
	
	double convertFromBaseUnit(double baseValue);
	
	String getUnitName();
	
	
	// Optional capability check
    default boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }
    
    // Runtime validation hook
    default void validateOperationSupport(String operation) {
        // Default: allow operations
    }
	
	
}

