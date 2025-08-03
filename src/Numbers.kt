interface Numbers {

    fun sumInt(): Int
    fun sumLong(): Long
    fun difference(): Int
    fun divide() : Double
    fun isSumInt() : Boolean
    fun isSumLong() : Boolean

    class Base(
        private val number1: Int,
        private val number2: Int
        ) : Numbers{

        private var wasSumLongCalled: Boolean = false
        private var wasSumLong: Boolean = false

        override fun sumInt(): Int {
            if(wasSumLongCalled) {
                if (wasSumLong)
                    throw IllegalStateException("you shouldn`t use this method: sumInt() ")
                wasSumLongCalled = false
                wasSumLong = false
                return number1 + number2
            }
            throw IllegalAccessException("First you should check the sum by method isSumLong()")

        }
        override fun sumLong() : Long {
            if(wasSumLongCalled) {
                if (wasSumLong) {
                    wasSumLongCalled = false
                    wasSumLong = false
                    return number1.toLong() + number2
                }
                throw IllegalStateException("you shouldn`t use this method: sumLong() ")
            }
            throw IllegalAccessException("First you should check the sum by method isSumLong()")

        }

        override fun difference(): Int = number1 - number2
        override fun divide(): Double {
            if(number2==0)
                throw IllegalArgumentException("На 0 ділити не можна")
            return number1.toDouble()/number2
        }

        override fun isSumInt(): Boolean {
            val rest = Int.MAX_VALUE - number1
            return number2 < rest
        }

        override fun isSumLong(): Boolean {
            wasSumLongCalled = true
            val rest = Int.MAX_VALUE - number1
            val result = number2 > rest
            wasSumLong = result
            return result
        }
    }



}