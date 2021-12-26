import org.junit.Assert
import org.junit.Test

class CalculatorTests {

    private val calculator = Calculator()

    @Test
    fun calculateSumTest() {
        val result = calculator.calculate(10, "+", 5)
        Assert.assertEquals(result, 15)
    }

    @Test
    fun calculateDifferenceTest() {
        val result = calculator.calculate(10, "-", 5)
        Assert.assertEquals(result, 5)
    }

    @Test
    fun calculateMultiplicationTest() {
        val result = calculator.calculate(10, "*", 5)
        Assert.assertEquals(result, 50)
    }

    @Test
    fun calculateDivisionTest() {
        val result = calculator.calculate(10, "/", 5)
        Assert.assertEquals(result, 2)
    }
}