import org.junit.Assert
import org.junit.Test

class ParserTests {

    val parser = Parser()

    @Test
    fun parseIntOrErrorFail() {
        try {
            parser.parseIntOrError("l")
            Assert.fail()
        } catch (e: NumberFormatException) {
            Assert.assertTrue(true)
        }
    }

    @Test
    fun parseIntOrErrorCorrect() {
        val i: Int = parser.parseIntOrError("1")
        Assert.assertEquals(1, i)
    }

    @Test
    fun checkNumberOfArgumentsFail() {
        try {
            parser.checkNumberOfArguments(2)
            Assert.fail()
        } catch (e: IllegalArgumentException) {
            Assert.assertTrue(true)
        }
    }

    @Test
    fun parseOperatorOrErrorFail() {
        try {
            parser.parseOperatorOrError("l")
            Assert.fail()
        } catch (e: IllegalArgumentException) {
            Assert.assertTrue(true)
        }
    }

    @Test
    @Throws(IllegalAccessError::class)
    fun parseOperatorOrErrorCorrect() {
        val s: Any = parser.parseOperatorOrError("+")
        Assert.assertSame("+", s)
    }
}