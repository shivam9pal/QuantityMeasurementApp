package com;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class InchTest {

		
	@Test
    void testEquality_SameValue() {
        Inches inch1 = new Inches(1.0);
        Inches inch2 = new Inches(1.0);

        assertTrue(inch1.equals(inch2),
                "1.0 inch should be equal to 1.0 inch");
    }

    @Test
    void testEquality_DifferentValue() {
        Inches inch1 = new Inches(1.0);
        Inches inch2 = new Inches(2.0);

        assertFalse(inch1.equals(inch2),
                "1.0 inch should not be equal to 2.0 inch");
    }

    @Test
    void testEquality_NullComparison() {
        Inches inch = new Inches(1.0);

        assertFalse(inch.equals(null),
                "Inches should not be equal to null");
    }

    @Test
    void testEquality_NonNumericInput() {
        Inches inch = new Inches(1.0);
        String invalid = "abc";

        assertFalse(inch.equals(invalid),
                "Inches should not be equal to non-Inches object");
    }

    @Test
    void testEquality_SameReference() {
        Inches inch = new Inches(1.0);

        assertTrue(inch.equals(inch),
                "Object should be equal to itself (reflexive property)");
    }

   

    @Test
    void testCompareInches_SameValue() {
        Inches inch = new Inches(0.0);

        assertTrue(inch.compareInches(1.0, 1.0),
                "compareInches should return true for same values");
    }

    @Test
    void testCompareInches_DifferentValue() {
        Inches inch = new Inches(0.0);

        assertFalse(inch.compareInches(1.0, 2.0),
                "compareInches should return false for different values");
    }
}
