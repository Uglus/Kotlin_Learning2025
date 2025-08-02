import org.junit.Test
import junit.framework.TestCase.assertEquals

class NumbersTest {
    @Test
    fun sum() {
        val numbers : Numbers = Numbers.Base(number1 = 10, number2 = 5)
        val actual = numbers.sum()
        val expected = 15
        assertEquals(expected,actual)
    }

    @Test
    fun difference() {
        val numbers : Numbers = Numbers.Base(number1 = 10, number2 = 5)
        val actual = numbers.difference()
        val expected = 5
        assertEquals(actual,expected)
    }

}