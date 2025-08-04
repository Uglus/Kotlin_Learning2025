import junit.framework.TestCase.assertEquals
import org.junit.Test

class CounterTest {

    @Test
    fun test_click(){
        val callback: FakeCallback = FakeCallback.Base()
        val counter : Counter = Counter.Base(callback)
        counter.click()
        assertEquals("1", callback.count())
        counter.click()
        assertEquals("2", callback.count())
        counter.click()
        assertEquals("3", callback.count())
    }


    private interface FakeCallback : Counter.Callback{

        fun count():String

        class Base: FakeCallback{
            private var value = ""

            override fun provide(value: String) {
                this.value = value
            }

            override fun count(): String {
                return value
            }
        }

    }

}