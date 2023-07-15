package shuffler

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class StringShufflerImplTest {
    private val sut: StringShuffler = StringShufflerImpl()

    @Test
    fun shuffle() {
        val sample = "A8!(,wV5YuI[Vr^>"
        val actual: String = sut.shuffle(sample)

        assertNotEquals(sample, actual)
        assertEquals(sample.length, actual.length)

        for (item in sample.toCharArray()) {
            assertTrue(actual.contains(item.toString()))
        }
    }
}