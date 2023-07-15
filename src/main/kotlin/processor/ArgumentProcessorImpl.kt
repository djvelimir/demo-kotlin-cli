package processor

import display.Terminal
import generator.PasswordGenerator

import validator.ArgumentValidator

class ArgumentProcessorImpl(
    private val argumentValidator: ArgumentValidator,
    private val passwordGenerator: PasswordGenerator,
    private val terminal: Terminal
) : ArgumentProcessor {
    override fun process(args: Array<String>) {
        if (!argumentValidator.validate(args)) {
            val usage = "Usage:" + System.getProperty("line.separator") +
                    "java -jar ./demo-kotlin-cli.jar generate password"
            terminal.show(usage)
            return
        }

        val password = passwordGenerator.generate()
        terminal.show(password)
    }
}