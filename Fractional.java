

public class Fractional {
	public long numerator;
	public long denominator;
	public static final String NotANumber = "Not a Number";
	public static final String PositiveInfinity = "+Infinity";
	public static final String NegativeInfinity = "-Infinity";
	
	Fractional(long numerator, long denominator) {	
		this.numerator = numerator;
		this.denominator = denominator;
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
		return this.numerator == 0 && this.denominator == 0;
		
	}

	boolean isInfinity() {
		//returns true if denominator is zero, returns false otherwise.
		if(this.denominator == 0)
			return true;
		else
			return false;
		
	}
	
	static int sign(long numerator, long denominator) {
		// 0/0 is undefined so we'll throw exception if it happens
		if(numerator == 0 && denominator == 0) {
			throw new ArithmeticException(Fractional.NotANumber);
		}
		if(denominator == 0 && numerator != 0) {
			if(numerator > 0) {
				return 1;
			}
			return -1;
		}
				
		
	if (denominator != 0 && numerator == 0){
			if(denominator > 0) {
				return (int) (numerator * denominator);
			}
			return (int) (-(numerator) * denominator);
			}
	return 0;
	}
		

	
	int sign() {
		return Fractional.sign(this.numerator, this.denominator);
	}

	double getValue() {
		return (double)numerator / denominator;
	}
	
	@Override
	public boolean equals(Object obj) {
		// student code
		if(((Fractional) obj).isNaN()) {
			if(this.isNaN()) {
				throw new ArithmeticException(Fractional.NotANumber);
			}
			}
		if(obj instanceof Fractional) {
			return this.getValue() == (((Fractional) obj).getValue());
		}
		return false;
	}
	
	@Override
	public String toString() {
		if(this.isNaN()) {
			return Fractional.NotANumber;
}
		return this.numerator + ((this.denominator != 1) ? "/" + this.denominator : "");

		
	}
public static void main(String[] args) {
		
		System.out.println(new Fractional(6, 2).toString());
		System.out.println(new Fractional(6, 2).simplify().toString());
		System.out.println(new Fractional(14, 4).simplify().toString());
		System.out.println(new Fractional(-14, 4).simplify().toString());
		System.out.println((new Fractional(2, 3).equals(new Fractional(4, 6))));
		
	}

}