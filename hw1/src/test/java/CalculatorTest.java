import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import static org.junit.Assert.*;

public class CalculatorTest {
    private Integer x;
    private Integer y;
    private Calculator calculator;

    @Before
    public void prepareArguments(){
        this.calculator = new Calculator();
        this.x = 1;
        this.y = 3;
    }


    @Test
    public void plus(){
        Assert.assertEquals(x+y, calculator.calculate(x,"+", y));
    }

    @Test
    public void minus(){
        Assert.assertEquals(x-y, calculator.calculate(x,"-", y));
    }

    @Test
    public void multiply(){
        Assert.assertEquals(x*y, calculator.calculate(x,"*", y));
    }

    @Test
    public void divide(){
        Assert.assertEquals(x/y, calculator.calculate(x,"/", y));
    }

    @Test
    public void divisionForbidden() throws ArithmeticException {
        Assert.assertThrows(ArithmeticException.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                calculator.calculate(0,"/",5);
            }
        });
    }

    @Test
    public void calculateWithWrongOperator(){
        Assert.assertThrows(ArithmeticException.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                calculator.calculate(2,"%",5);
            }
        });
    }

}