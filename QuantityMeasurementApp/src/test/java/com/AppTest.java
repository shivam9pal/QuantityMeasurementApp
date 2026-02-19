package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.QuantityMeasurementApp.Feet;

/**
 * Unit test for simple App.
 */
public class AppTest 
    
{
	@Test
    void testEquality_SameValue() {
        QuantityMeasurementApp.Feet feet1 = new Feet(1.0);
        QuantityMeasurementApp.Feet feet2 = new Feet(1.0);

        assertTrue(feet1.equals(feet2), 
                "1.0 ft should be equal to 1.0 ft");
    }

    @Test
    void testEquality_DifferentValue() {
    	QuantityMeasurementApp.Feet feet1 = new Feet(1.0);
    	QuantityMeasurementApp.Feet feet2 = new Feet(2.0);

        assertEquals(feet1.equals(feet2), 
                "1.0 ft should not be equal to 2.0 ft");
    }

    @Test
    void testEquality_NullComparison() {
    	QuantityMeasurementApp.Feet feet = new Feet(1.0);

        assertEquals(feet.equals(null), 
                "Feet value should not be equal to null");
    }

    @Test
    void testEquality_NonNumericInput() {
    	QuantityMeasurementApp.Feet feet = new Feet(1.0);
        String nonNumeric = "1.0";

        assertFalse(feet.equals(nonNumeric), 
                "Feet value should not be equal to non-numeric input");
    }

    @Test
    void testEquality_SameReference() {
    	QuantityMeasurementApp.Feet feet = new Feet(1.0);

        assertTrue(feet.equals(feet), 
                "Feet value should be equal to itself (reflexive property)");
    }
}
