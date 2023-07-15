package generator

import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import shuffler.StringShuffler

class PasswordGeneratorImplTest {
    private val randomCharacterGenerator: RandomCharacterGenerator = mockk<RandomCharacterGenerator>(relaxed = true)
    private val stringShuffler: StringShuffler = mockk<StringShuffler>(relaxed = true)
    private val sut: PasswordGenerator = PasswordGeneratorImpl(randomCharacterGenerator, stringShuffler)

    @Test
    fun generateShouldCallGenerateUppercaseCharacter() {
        sut.generate()

        verify(exactly = 1) {
            randomCharacterGenerator.generateUppercaseCharacter()
        }
    }

    @Test
    fun generateShouldCallGenerateLowercaseCharacter() {
        sut.generate()

        verify(exactly = 1) {
            randomCharacterGenerator.generateLowercaseCharacter()
        }
    }

    @Test
    fun generateShouldCallGenerateDigitCharacter() {
        sut.generate()

        verify(exactly = 1) {
            randomCharacterGenerator.generateDigitCharacter()
        }
    }

    @Test
    fun generateShouldCallGenerateSpecialCharacter() {
        sut.generate()

        verify(exactly = 1) {
            randomCharacterGenerator.generateSpecialCharacter()
        }
    }

    @Test
    fun generateShouldCallGenerateAllowedCharacter12Times() {
        sut.generate()

        verify(exactly = 12) {
            randomCharacterGenerator.generateAllowedCharacter()
        }
    }

    @Test
    fun generateShouldCallShuffle() {
        sut.generate()

        verify(exactly = 1) {
            stringShuffler.shuffle(any())
        }
    }
}