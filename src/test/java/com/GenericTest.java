package com;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
public class GenericTest 
    
{
	 @Test
	    public void testFeetEquality() {
	        Length feet1 = new Length(1.0, LengthUnit.FEET);
	        Length feet2 = new Length(1.0, LengthUnit.FEET);

	        assertTrue(feet1.equals(feet2),
	                "1.0 feet should be equal to 1.0 feet");
	    }

	    @Test
	    public void testInchesEquality() {
	        Length inches1 = new Length(1.0, LengthUnit.INCHES);
	        Length inches2 = new Length(1.0, LengthUnit.INCHES);

	        assertTrue(inches1.equals(inches2),
	                "1.0 inches should be equal to 1.0 inches");
	    }

	    @Test
	    public void testFeetInchesComparison() {
	        Length feet = new Length(1.0, LengthUnit.FEET);
	        Length inches = new Length(12.0, LengthUnit.INCHES);

	        assertTrue(feet.equals(inches),
	                "1 foot should be equal to 12 inches");
	    }

	    @Test
	    public void testFeetInequality() {
	        Length feet1 = new Length(1.0, LengthUnit.FEET);
	        Length feet2 = new Length(2.0, LengthUnit.FEET);

	        assertFalse(feet1.equals(feet2),
	                "1.0 feet should not be equal to 2.0 feet");
	    }

	    @Test
	    public void testInchesInequality() {
	        Length inches1 = new Length(1.0, LengthUnit.INCHES);
	        Length inches2 = new Length(2.0, LengthUnit.INCHES);

	        assertFalse(inches1.equals(inches2),
	                "1.0 inches should not be equal to 2.0 inches");
	    }

	    @Test
	    public void testCrossUnitInequality() {
	        Length feet = new Length(1.0, LengthUnit.FEET);
	        Length inches = new Length(10.0, LengthUnit.INCHES);

	        assertFalse(feet.equals(inches),
	                "1 foot should not be equal to 10 inches");
	    }

	    @Test
	    public void testMultipleFeetComparison() {
	        Length feet1 = new Length(3.0, LengthUnit.FEET);
	        Length inches = new Length(36.0, LengthUnit.INCHES);

	        assertTrue(feet1.equals(inches),
	                "3 feet should be equal to 36 inches");
	    }
}
