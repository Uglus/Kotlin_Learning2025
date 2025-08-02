import org.junit.Test
import junit.framework.TestCase.assertEquals
import kotlin.math.exp

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
        assertEquals(expected,actual)
    }

    @Test
    fun test_divide(){
        val numbers: Numbers = Numbers.Base(10,5);
        val actual = numbers.divide()
        val expected = 2.0
        assertEquals(expected,actual,0.01)
    }

    @Test
    fun test_divide_double() {
        val numbers: Numbers = Numbers.Base(10,4)
        val actual = numbers.divide()
        val expected = 2.5
        assertEquals(expected,actual,0.01)
    }

    @Test(expected = IllegalArgumentException::class)
    fun test_divide_zero(){
        val number: Numbers = Numbers.Base(number1= 12, number2 = 0)
        number.divide();
    }

}