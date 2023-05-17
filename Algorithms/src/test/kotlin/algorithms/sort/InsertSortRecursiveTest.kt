package algorithms.sort

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

internal class InsertSortRecursiveTest {

    val sorter: InsertSortRecursive = InsertSortRecursive()

    @Test
    fun testSort() {
        //given
        val elements = mutableListOf(3,8,6,9,6,0)

        //when
        print(sorter.sort(elements))

        //then
        val lastElement: Optional<Int> = elements.stream()
            .reduce { a, b ->
                assertTrue(
                    isEqualOrGreaterThan(b, a),
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

    private fun isEqualOrGreaterThan(next: Int, prev: Int): Boolean {
        return next >= prev
    }

}
