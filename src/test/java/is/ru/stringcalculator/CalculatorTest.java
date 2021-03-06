package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void testNewLine(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    }

    @Test
    public void testNegativeNumber(){
    	RuntimeException exception = null;
    	try{
    		Calculator.add("-1,2");
    	} catch(RuntimeException e){
    		exception = e;
    	}
    	assertEquals("Negatives not allowed: -1", exception.getMessage());
    }

    @Test
    public void testMultipleNegativeNumber(){
    	RuntimeException exception = null;
    	try{
    		Calculator.add("2,-4,3,-5");
    	} catch(RuntimeException e){
    		exception = e;
    	}
    	assertEquals("Negatives not allowed: -4,-5", exception.getMessage());
    }

    @Test
    public void testBiggerNumbers(){
    	assertEquals(2, Calculator.add("1001,2"));
    }

    @Test
    public void testMultipleBiggerNumbers(){
    	assertEquals(1008, Calculator.add("1001,2,6,1000,1500"));
    }

    @Test
    public void testAllowOtherDelimiters(){
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }

    @Test
    public void testThirdDelimiters(){
    	assertEquals(5, Calculator.add("//_\n1_4"));
    }
}