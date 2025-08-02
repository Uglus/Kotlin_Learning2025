interface Numbers {

    fun sum(): Int

    fun difference(): Int

    class Base(
        private val number1: Int,
        private val number2: Int
        ) : Numbers{
        override fun sum(): Int = number1 + number2

        override fun difference(): Int = number1 - number2

    }

}