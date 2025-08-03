import org.junit.Test
import junit.framework.TestCase.assertEquals

class NumbersTest {

    @Test
    fun test_sum_long(){
        val numbers : Numbers = Numbers.Base(number1 = 2_000_000_000, number2 = 147_483_648)
        val isSumLong = numbers.isSumLong()
        val expected = true
        assertEquals(expected,isSumLong)

        val actual:Long = numbers.sumLong()
        val expectedNumber : Long = Int.MAX_VALUE + 1L
        assertEquals(expectedNumber,actual)
    }

    @Test
    fun test_sum_int() {
        val numbers : Numbers = Numbers.Base(number1 = 2_000_000_000, number2 = 147_483_647)
        val isSumLong = numbers.isSumLong()
        val expected = false
        assertEquals(expected,isSumLong)

        val actual:Int = numbers.sumInt()
        val expectedNumber : Int = Int.MAX_VALUE
        assertEquals(expectedNumber,actual)
    }

    @Test(expected = IllegalAccessException::class)
    fun test_sum_int_no_check(){
        val numbers : Numbers = Numbers.Base(number1 = 2_000_000_000, number2 = 2_000_000_000)
        numbers.sumInt()
    }

    @Test(expected = IllegalAccessException::class)
    fun test_sum_long_check(){
        val numbers : Numbers = Numbers.Base(number1 = 2_000_000_000, number2 = 2_000_000_000)
        numbers.sumLong()
    }

    @Test(expected = IllegalStateException::class)
    fun test_sum_long_called_for_long_sum(){
        val numbers : Numbers = Numbers.Base(number1 = 2_000_000_000, number2 = 2_000_000_000)
        val actual = numbers.isSumLong()
        val expected = true
        assertEquals(expected,actual)
        numbers.sumInt()
    }


    @Test(expected = IllegalStateException::class)
    fun test_sum_long_called_for_int_sum(){
        val numbers : Numbers = Numbers.Base(number1 = 2_000_000_000, number2 = 1_000_000)
        val actual = numbers.isSumLong()
        val expected = false
        assertEquals(expected,actual)
        numbers.sumLong()
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
        val numbers: Numbers = Numbers.Base(10,5)
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
        number.divide()
    }

}