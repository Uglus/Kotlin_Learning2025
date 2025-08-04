import org.junit.Assert.assertEquals
import org.junit.Test


class QuadrantDifferenceTest {

    @Test
    fun test_long() {
        val numbers = FakeNumbers.Base(true)
        val quadrantDifferenceTest = QuadrantDifference.Base(numbers)
        val actual:Long = quadrantDifferenceTest.value()
        val expected : Long = 6
        assertEquals(true, numbers.differenceCalled())
        assertEquals(true, numbers.isSumLongCalled())
        assertEquals(true, numbers.sumLongCalled())
        assertEquals(false, numbers.sumIntCalled())
        assertEquals(expected,actual)
    }

    @Test
    fun test_int() {
        val numbers = FakeNumbers.Base(false)
        val quadrantDifferenceTest = QuadrantDifference.Base(numbers)
        val actual:Long = quadrantDifferenceTest.value()
        val expected : Long = 6
        assertEquals(true, numbers.differenceCalled())
        assertEquals(true, numbers.isSumLongCalled())
        assertEquals(false, numbers.sumLongCalled())
        assertEquals(true, numbers.sumIntCalled())
        assertEquals(expected,actual)
    }

    private interface FakeNumbers : Numbers{

        fun differenceCalled() : Boolean
        fun sumIntCalled() : Boolean
        fun sumLongCalled() : Boolean
        fun isSumLongCalled() : Boolean

        class Base(private val isSumLong: Boolean) : FakeNumbers{

            private var differenceCalled: Boolean = false
            private var sumIntCalled: Boolean = false
            private var sumLongCalled: Boolean = false
            private var isSumLongCalled: Boolean = false

            override fun sumInt(): Int {
                sumIntCalled = true
                return 3
            }

            override fun sumLong(): Long {
                sumLongCalled = true
                return  3L
            }

            override fun difference(): Int {
                differenceCalled = true
                return 2
            }

            override fun divide(): Double {
                throw IllegalAccessException("Not needed in this tests")
            }


            override fun isSumLong(): Boolean {
                isSumLongCalled = true
                return isSumLong
            }

            override fun differenceCalled(): Boolean {
                return differenceCalled
            }

            override fun sumIntCalled(): Boolean {
                return sumIntCalled
            }

            override fun sumLongCalled(): Boolean {
                isSumLongCalled = true
                return sumLongCalled
            }

            override fun isSumLongCalled(): Boolean {
                return isSumLongCalled
            }

        }

    }



}