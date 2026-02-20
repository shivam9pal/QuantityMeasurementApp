package com;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 0.01;

   

    @Test
    public void testFeetEquality() {
        assertTrue(new Length(1.0, LengthUnit.FEET)
                .equals(new Length(1.0, LengthUnit.FEET)));
    }

    @Test
    public void testInchesEquality() {
        assertTrue(new Length(1.0, LengthUnit.INCHES)
                .equals(new Length(1.0, LengthUnit.INCHES)));
    }

    @Test
    public void testFeetInchesComparison() {
        assertTrue(new Length(1.0, LengthUnit.FEET)
                .equals(new Length(12.0, LengthUnit.INCHES)));
    }

    @Test
    public void testFeetInequality() {
        assertFalse(new Length(1.0, LengthUnit.FEET)
                .equals(new Length(2.0, LengthUnit.FEET)));
    }

    @Test
    public void testInchesInequality() {
        assertFalse(new Length(1.0, LengthUnit.INCHES)
                .equals(new Length(2.0, LengthUnit.INCHES)));
    }

    @Test
    public void testCrossUnitInequality() {
        assertFalse(new Length(1.0, LengthUnit.FEET)
                .equals(new Length(10.0, LengthUnit.INCHES)));
    }

    @Test
    public void testMultipleFeetComparison() {
        assertTrue(new Length(3.0, LengthUnit.FEET)
                .equals(new Length(36.0, LengthUnit.INCHES)));
    }

    @Test
    public void yardEquals36Inches() {
        assertTrue(new Length(1.0, LengthUnit.YARDS)
                .equals(new Length(36.0, LengthUnit.INCHES)));
    }

    @Test
    public void centimeterEqualsInches() {
        assertTrue(new Length(1.0, LengthUnit.CENTIMETERS)
                .equals(new Length(0.393701, LengthUnit.INCHES)));
    }

    @Test
    public void threeFeetEqualOneYard() {
        assertTrue(new Length(3.0, LengthUnit.FEET)
                .equals(new Length(1.0, LengthUnit.YARDS)));
    }

    // ---------------- Equality ----------------

    @Test
    public void referenceEqualitySameObject() {
        Length l = new Length(5.0, LengthUnit.FEET);
        assertTrue(l.equals(l));
    }

    @Test
    public void equalsReturnsFalseForNull() {
        assertFalse(new Length(5.0, LengthUnit.FEET)
                .equals(null));
    }

    @Test
    public void reflexiveSymmetricAndTransitiveProperty() {

        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(3.0, LengthUnit.FEET);
        Length inches = new Length(36.0, LengthUnit.INCHES);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inches));
        assertTrue(yard.equals(inches));
    }

    @Test
    public void differentValuesSameUnitNotEqual() {
        assertFalse(new Length(2.0, LengthUnit.FEET)
                .equals(new Length(3.0, LengthUnit.FEET)));
    }

    // UC5 CONVERSION TESTS 

    @Test
    public void convertFeetToInches() {
        Length result = QuantityMeasurementApp
                .demonstrateLengthConversion(
                        10.0,
                        LengthUnit.FEET,
                        LengthUnit.INCHES);

        assertEquals(120.0, result.getValue(), EPSILON);
    }

    @Test
    public void convertYardsToInchesUsingOverloadedMethod() {

        Length result = QuantityMeasurementApp
                .demonstrateLengthConversion(
                        new Length(2.0, LengthUnit.YARDS),
                        LengthUnit.INCHES);

        assertEquals(72.0, result.getValue(), EPSILON);
    }

    //UC6 ADDITION TESTS 

    @Test
    public void addFeetAndInches() {

        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        Length sumLength =
                QuantityMeasurementApp.demonstrateAddition(length1, length2);

        Length expectedLength =
                new Length(2.0, LengthUnit.FEET);

        assertTrue(QuantityMeasurementApp
                .demonstrateLengthEquality(sumLength, expectedLength));
    }

    @Test
    public void testAddition_SameUnit() {

        Length result = new Length(1.0, LengthUnit.FEET)
                .add(new Length(2.0, LengthUnit.FEET));

        assertEquals(3.0, result.getValue(), EPSILON);
    }

    @Test
    public void testAddition_Commutativity() {

        Length a = new Length(1.0, LengthUnit.FEET);
        Length b = new Length(12.0, LengthUnit.INCHES);

        assertTrue(a.add(b).equals(b.add(a)));
    }

    @Test
    public void testAddition_WithZero() {

        Length result = new Length(5.0, LengthUnit.FEET)
                .add(new Length(0.0, LengthUnit.INCHES));

        assertEquals(5.0, result.getValue(), EPSILON);
    }

    @Test
    public void testAddition_NegativeValues() {

        Length result = new Length(5.0, LengthUnit.FEET)
                .add(new Length(-2.0, LengthUnit.FEET));

        assertEquals(3.0, result.getValue(), EPSILON);
    }

}
