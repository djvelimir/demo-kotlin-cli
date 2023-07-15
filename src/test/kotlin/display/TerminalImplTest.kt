package display

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class TerminalImplTest {
    private val sut: Terminal = TerminalImpl()

    @Test
    fun show() {
        val message = "Test Message"
        val expected = message + System.getProperty("line.separator")

        val standardOut = System.out
        val outputStreamCaptor = ByteArrayOutputStream()

        System.setOut(PrintStream(outputStreamCaptor))
        sut.show(message)
        System.setOut(standardOut)

        assertEquals(expected, outputStreamCaptor.toString())
    }
}