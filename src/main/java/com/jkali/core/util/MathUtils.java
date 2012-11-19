package com.jkali.core.util;


/**
 *
 */
public class MathUtils {
	/** 
	 * Collapse number down to +1 0 or -1 depending on sign. 
	 * Typically used in compare routines to collapse a difference 
	 * of two longs to an int. 
	 * 
	 * @param diff usually represents the difference of two longs. 
	 * 
	 * @return signum of diff, +1, 0 or -1. 
	 */ 
	public static final int signum( long diff ) 
	{ 
		if ( diff > 0 ) return 1; 
		if ( diff < 0 ) return -1 ; 
		else return 0; 
	} // end signum 

	public static final int signum( double diff ) 
	{ 
		if ( diff > 0 ) return 1; 
		if ( diff < 0 ) return -1 ; 
		else return 0; 
	} // end signum 

	public static final double inRange(double value, double min, double max) {
		if (value < min)
			return min;
		if (value > max)
			return max;
		return value;
	}
	
	private static double roundValue = 1000000.0D;
	public static double roundToDecentPrecision(double value) {
		double z = Math.round(roundValue * value);
		return z / roundValue;
	}
}

