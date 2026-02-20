package com;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UC5Test {
	
	
	
	@Test
	public void TestFeetEquality() {
		Length l1=new Length(1.0,LengthUnit.FEET);
		Length l2=new Length(1.0,LengthUnit.FEET);
		assertTrue(l1.equals(l2));
		
	}
	@Test
	public void TestInchesEquality() {
		Length l1=new Length(2.0,LengthUnit.INCHES);
		Length l2=new Length(2.0,LengthUnit.INCHES);
		assertTrue(l1.equals(l2));
		
	}
	@Test
	public void TestFeetInchesComparison() {
		Length l1=new Length(2.0,LengthUnit.FEET);
		Length l2=new Length(24.0,LengthUnit.INCHES);
		assertTrue(l1.equals(l2));
		
	}
	@Test
	public void TestFeetInequality() {
		Length l1=new Length(2.0,LengthUnit.FEET);
		Length l2=new Length(20.0,LengthUnit.FEET);
		assertTrue(l1.equals(l2));
		
	}
	@Test
	public void testInchesInequality() {
	        Length l1 = new Length(1.0, LengthUnit.INCHES);
	        Length l2 = new Length(2.0, LengthUnit.INCHES);
	        assertFalse(l1.equals(l2));
	    }
	
	@Test
	public void testCrossUnitInequality() {
	        Length feet = new Length(1.0, LengthUnit.FEET);
	        Length inches = new Length(10.0, LengthUnit.INCHES);

	        assertFalse(feet.equals(inches));
	    }
	@Test
	public void testMultipleFeetComparison() {
	        Length feet = new Length(3.0, LengthUnit.FEET);
	        Length inches = new Length(36.0,LengthUnit.INCHES);

	        assertTrue(feet.equals(inches));
	    }
	
	@Test
	public void yardEqual36Inches() {
		Length yards = new Length(1.0, LengthUnit.YARDS);
		Length inches = new Length(36.0, LengthUnit.INCHES);
		assertTrue(yards.equals(inches));
	}
	@Test
    public void threeFeetEqualsOneYard() {
        Length feet = new Length(3.0, LengthUnit.FEET);
        Length yard = new Length(1.0, LengthUnit.YARDS);

        assertTrue(feet.equals(yard));
    }

    @Test
    public void thirtySixInchEqualsOneYard() {
        Length inches = new Length(36.0, LengthUnit.INCHES);
        Length yard = new Length(1.0, LengthUnit.YARDS);

        assertTrue(inches.equals(yard));
    }
    @Test
    public void cmEqualsInches() {
        Length cm = new Length(1.0, LengthUnit.CENTIMETERS);
        Length inches = new Length(0.393701, LengthUnit.INCHES);

        assertTrue(cm.equals(inches));
    }

    

    @Test
    public void reflexiveEquality() {
        Length l = new Length(5.0, LengthUnit.FEET);
        assertTrue(l.equals(l));
    }

    @Test
    public void equalsReturnsFalseForNull() {
        Length l = new Length(5.0, LengthUnit.FEET);
        assertFalse(l.equals(null));
    }
    
    @Test
    public void reflexiveSymmetricAndTransitiveProperty() {

        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(3.0, LengthUnit.FEET);
        Length inches = new Length(36.0, LengthUnit.INCHES);

        // symmetric(if a==b && b==c then a==c as well)
        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(yard));

        // Transitive
        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inches));
        assertTrue(yard.equals(inches));
    }
    
    @Test
    public void differentValuesRemainInequal() {
        Length l1 = new Length(2.0, LengthUnit.YARDS);
        Length l2 = new Length(3.0, LengthUnit.YARDS);

        assertFalse(l1.equals(l2));
    }
    
    @Test 
    public void convertFeettoInches() {
    	Length l1 = new Length(2.0, LengthUnit.FEET);
        Length l2 = new Length(24.0, LengthUnit.INCHES);
        
        Length length=l1.convertTo(LengthUnit.INCHES);
        assertTrue(length.equals(l2));
    }
    
    @Test 
    public void convertYardtoInches() {
    	Length l1 = new Length(1.0, LengthUnit.YARDS);
        Length l2 = new Length(36.0, LengthUnit.INCHES);
        
        Length length=l1.convertTo(LengthUnit.INCHES);
        assertTrue(length.equals(l2));
    }
    
    @Test
    public void convertRawValue() {
    	Length l=QuantityMeasurementApp.demonstrateLengthConversion(1.0, LengthUnit.YARDS, LengthUnit.INCHES);
    	Length l2=new Length(36.0,LengthUnit.INCHES);
    	assertTrue(l.equals(l2));
    }
    
}
