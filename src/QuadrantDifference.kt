interface QuadrantDifference {

    fun value():Long

    class Base(private val numbers:Numbers):QuadrantDifference {

        override fun value(): Long {
           val sum = if(numbers.isSumLong())
               numbers.sumLong()
           else
               numbers.sumInt().toLong()
         return sum * numbers.difference()
        }

    }

}