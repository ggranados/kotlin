package algorithms.sort

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

internal class InsertSortIterativeKtTest {

    @Test
    fun testSort() {
        //given
        val elements = mutableListOf(3, 8, 6, 9, 6, 0)

        //when
        print(sort(elements))

        //then
        val lastElement: Optional<Int> = elements.stream()
            .reduce { a, b ->
                assertTrue(
                    b >= a,
                    "$b element is not equal or greater than previous $a"
                )
                b
            }

        val max = elements.stream()
            .mapToInt { v: Int? -> v!! }.max()

        assertTrue(lastElement.isPresent, "last element must be present")
        assertTrue(max.isPresent, "max element must be present")
        assertEquals(
            max.asInt,
            lastElement.get(),
            "Last element should be the max value"
        )
    }


}
