
public class Fractional {
	public final long numerator;
	public final long denominator;
	public static final String NotANumber = "Not a Number";
	public static final String PositiveInfinity = "+Infinity";
	public static final String NegativeInfinity = "-Infinity";
	
	Fractional(long numerator, long denominator) {	
	}
	
	Fractional simplify() {
		long num = numerator;
		long den = denominator;
		long temp;
		if(numerator < 0) {
			num = -numerator;
		}
		if(num > den) {
		    temp = num;
		}
		else {
			temp = den;
		}
		int divisor = 0;
		for(int i = (int) temp; i>=2; i--) {
			if(numerator % i == 0 && denominator % i == 0) {
				divisor = i;
				break;
			}
		}
		if (divisor != 0) {
			numerator = numerator/divisor;
			denominator = denominator / divisor; 
		}
		return (new Fractional(numerator, denominator));
	}
	
	// Not a Number (NaN) 
	boolean isNaN() {
		// student code
	}

	boolean isInfinity() {
		//returns true if denominator is zero, returns false otherwise.
		if(this.denominator == 0)
			return true;
		else
			return false;
	}
	
	int sign(long numerator, long denominator) {
		// student code
	}
	
	int sign() {
		// student code
	}

	@Override
	public boolean equals(Object obj) {
		// student code
	}
	
	@Override
	public String toString() {
		if(this.isNaN()) {
			return Fractional.NotANumber;
}
		return this.numerator + ((this.denominator != 1) ? "/" + this.denominator : "");

		
	}

}
