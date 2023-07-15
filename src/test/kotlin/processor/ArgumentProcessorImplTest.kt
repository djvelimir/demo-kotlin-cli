package processor

import display.Terminal
import generator.PasswordGenerator
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import validator.ArgumentValidator

class ArgumentProcessorImplTest {
    private val argumentValidator: ArgumentValidator = mockk<ArgumentValidator>()
    private val passwordGenerator: PasswordGenerator = mockk<PasswordGenerator>()
    private val terminal: Terminal = mockk<Terminal>(relaxed = true)
    private val sut: ArgumentProcessor = ArgumentProcessorImpl(argumentValidator, passwordGenerator, terminal)

    @Test
    fun processGeneratePassword() {
        val args = arrayOf("generate", "password")
        every { argumentValidator.validate(args) } returns true

        val sample = "A8!(,wV5YuI[Vr^>"
        every { passwordGenerator.generate() } returns sample

        sut.process(args)

        verify(exactly = 1) {
            argumentValidator.validate(args)
            passwordGenerator.generate()
            terminal.show(sample)
        }
    }

    @Test
    fun processInvalidArguments() {
        val usage = "Usage:" + System.getProperty("line.separator") +
                "java -jar ./demo-kotlin-cli.jar generate password"
        val args = arrayOf<String>()
        every { argumentValidator.validate(args) } returns false

        sut.process(args)

        verify(exactly = 1) {
            argumentValidator.validate(args)
            terminal.show(usage)
        }
    }
}