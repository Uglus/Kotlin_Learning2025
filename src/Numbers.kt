interface Numbers {

    fun sum(): Int

    fun difference(): Int
    fun divide() : Double

    class Base(
        private val number1: Int,
        private val number2: Int
        ) : Numbers{
        override fun sum(): Int = number1 + number2

        override fun difference(): Int = number1 - number2
        override fun divide(): Double {
            if(number2==0)
                throw IllegalArgumentException("На 0 ділити не можна")
            return number1.toDouble()/number2
        }
    }



}