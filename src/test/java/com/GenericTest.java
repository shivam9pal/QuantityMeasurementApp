package com;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GenericTest {

    // YARD TESTS

    @Test
    public void testEquality_YardToYard_SameValue() {
        assertTrue(new Length(1.0, LengthUnit.YARDS)
                .equals(new Length(1.0, LengthUnit.YARDS)));
    }

    @Test
    public void testEquality_YardToYard_DifferentValue() {
        assertFalse(new Length(1.0, LengthUnit.YARDS)
                .equals(new Length(2.0, LengthUnit.YARDS)));
    }

    @Test
    public void testEquality_YardToFeet_EquivalentValue() {
        assertTrue(new Length(1.0, LengthUnit.YARDS)
                .equals(new Length(3.0, LengthUnit.FEET)));
    }

    @Test
    public void testEquality_FeetToYard_EquivalentValue() {
        assertTrue(new Length(3.0, LengthUnit.FEET)
                .equals(new Length(1.0, LengthUnit.YARDS)));
    }

    @Test
    public void testEquality_YardToInches_EquivalentValue() {
        assertTrue(new Length(1.0, LengthUnit.YARDS)
                .equals(new Length(36.0, LengthUnit.INCHES)));
    }

    @Test
    public void testEquality_InchesToYard_EquivalentValue() {
        assertTrue(new Length(36.0, LengthUnit.INCHES)
                .equals(new Length(1.0, LengthUnit.YARDS)));
    }

    @Test
    public void testEquality_YardToFeet_NonEquivalentValue() {
        assertFalse(new Length(1.0, LengthUnit.YARDS)
                .equals(new Length(2.0, LengthUnit.FEET)));
    }

    //CENTIMETER TESTS

    @Test
    public void testEquality_CentimetersToCentimeters_SameValue() {
        assertTrue(new Length(2.0, LengthUnit.CENTIMETERS)
                .equals(new Length(2.0, LengthUnit.CENTIMETERS)));
    }

    @Test
    public void testEquality_CentimetersToInches_EquivalentValue() {
        assertTrue(new Length(1.0, LengthUnit.CENTIMETERS)
                .equals(new Length(0.393701, LengthUnit.INCHES)));
    }

    @Test
    public void testEquality_CentimetersToFeet_NonEquivalentValue() {
        assertFalse(new Length(1.0, LengthUnit.CENTIMETERS)
                .equals(new Length(1.0, LengthUnit.FEET)));
    }

    // ---------------- TRANSITIVE PROPERTY 

    @Test
    public void testEquality_MultiUnit_TransitiveProperty() {

        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(3.0, LengthUnit.FEET);
        Length inches = new Length(36.0, LengthUnit.INCHES);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inches));
        assertTrue(yard.equals(inches));
    }

    //NULL + REFLEXIVE 
    @Test
    public void testEquality_YardSameReference() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        assertTrue(yard.equals(yard));
    }

    @Test
    public void testEquality_YardNullComparison() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        assertFalse(yard.equals(null));
    }

    @Test
    public void testEquality_YardWithNullUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> new Length(1.0, null));
    }

    @Test
    public void testEquality_AllUnits_ComplexScenario() {

        Length yard = new Length(2.0, LengthUnit.YARDS);
        Length feet = new Length(6.0, LengthUnit.FEET);
        Length inches = new Length(72.0, LengthUnit.INCHES);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inches));
        assertTrue(yard.equals(inches));
    }
}
