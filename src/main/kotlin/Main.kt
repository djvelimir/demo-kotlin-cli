import display.Terminal
import display.TerminalImpl
import generator.PasswordGenerator
import generator.PasswordGeneratorImpl
import generator.RandomCharacterGenerator
import generator.RandomCharacterGeneratorImpl
import processor.ArgumentProcessor
import processor.ArgumentProcessorImpl
import shuffler.StringShuffler
import shuffler.StringShufflerImpl
import validator.ArgumentValidator
import validator.ArgumentValidatorImpl

fun main(args: Array<String>) {
    val argumentValidator: ArgumentValidator = ArgumentValidatorImpl()
    val randomCharacterGenerator: RandomCharacterGenerator = RandomCharacterGeneratorImpl()
    val stringShuffler: StringShuffler = StringShufflerImpl()
    val passwordGenerator: PasswordGenerator = PasswordGeneratorImpl(randomCharacterGenerator, stringShuffler)
    val terminal: Terminal = TerminalImpl()
    val argumentProcessor: ArgumentProcessor = ArgumentProcessorImpl(argumentValidator, passwordGenerator, terminal)

    argumentProcessor.process(args)
}