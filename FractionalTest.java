import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FractionalTest {

    @Test
    void constructorTest() {
        Assertions.assertDoesNotThrow(() -> {
            new Fractional(14, 7);
        });
        Assertions.assertDoesNotThrow(() -> {
            new Fractional(-1, -1);
        });
        Assertions.assertDoesNotThrow(() -> {
            new Fractional(0, 1);
        });
        Assertions.assertDoesNotThrow(() -> {
            new Fractional(1, 0);
        });

    }
    
    @Test
    void isInfinityTest () {
    	assertEquals(Fractional.NegativeInfinity, new Fractional(-1, 0).toString());
        assertEquals(Fractional.PositiveInfinity, new Fractional(+1, 0).toString());
     }
    
    @Test
    void toStringTest() {
        Assertions.assertEquals("3", new Fractional(21, 7).simplify().toString());
        Assertions.assertEquals("0", new Fractional(0, 2).simplify().toString());
        Assertions.assertEquals("2/3", new Fractional(2, 3).toString());
        Assertions.assertEquals("2/5", new Fractional(8, 40).simplify().toString());
        Assertions.assertEquals("-3/5", new Fractional(-9, 15).simplify().toString());
        Assertions.assertEquals("-4/9", new Fractional(4, -9).toString());
        Assertions.assertEquals("3/5", new Fractional(3, 5).toString());
        Assertions.assertEquals("3/7", new Fractional(-18, -42).simplify().toString());
    }
	@Test
	void equalsTest() {
	Fractional num1= new Fractional(8,8);
	Fractional num2= new Fractional(12,18);
	Fractional num3= new Fractional(2,3);
	Fractional num4= new Fractional(0,9);
	Fractional num5= new Fractional(0,5);
	Fractional num6= new Fractional(0,0);
		
	 Assertions.assertThrows(ArithmeticException.class, () -> {num6.equals(num6);});
     Assertions.assertEquals(true, num1.equals(num1));
     Assertions.assertEquals(false, num1.equals(num2));
     Assertions.assertEquals(true, num3.equals(num2));
     Assertions.assertEquals(false, num1.equals(num3));
     Assertions.assertEquals(true, num4.equals(num5));
     Assertions.assertEquals(false, num4.equals(num1));

	     
		
	}
    @Test
    void getValueTest() {
        Assertions.assertEquals(6, new Fractional(18, 3).getValue());
        Assertions.assertEquals(4.0d / 5.0d, new Fractional(4, 5).getValue());
    }
    
    @Test
    void simplifyTest() {
	    Assertions.assertThrows(ArithmeticException.class, () -> new Fractional(0, 0).simplify()); 
	    Assertions.assertThrows(ArithmeticException.class, () -> new Fractional(1, 0).simplify());
        Assertions.assertThrows(ArithmeticException.class, () -> new Fractional(-1, 0).simplify());
        Assertions.assertEquals("2", new Fractional(10, 5).simplify().toString());
        Assertions.assertEquals("2/5", new Fractional(2, 5).simplify().toString());
        Assertions.assertEquals("3/7", new Fractional(6, 14).simplify().toString());
        Assertions.assertEquals("0", new Fractional(0, 2).simplify().toString());
        Assertions.assertEquals("1/11", new Fractional(-2, -22).simplify().toString());
        Assertions.assertEquals("-5/8", new Fractional(-20, 32).simplify().toString());
        Assertions.assertEquals("-1/4", new Fractional(6, -24).simplify().toString());
    }
    

    @Test
    void signTest() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            new Fractional(0, 0).sign();
        });

        assertEquals(0, new Fractional(0, 2).sign());
        assertEquals(+1, new Fractional(2, 0).sign());
    }
    
    @Test
    void isNaNTest() {
    	assertEquals(Fractional.NotANumber, new Fractional(0, 0).toString());
    }

}
