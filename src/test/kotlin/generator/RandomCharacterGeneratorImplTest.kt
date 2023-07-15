package generator

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RandomCharacterGeneratorImplTest {
    private val uppercaseCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    private val lowercaseCharacters = "abcdefghijklmnopqrstuvwxyz"
    private val digitCharacters = "0123456789"
    private val specialCharacters = "~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?"
    private val allowedCharacters = uppercaseCharacters
        .plus(lowercaseCharacters)
        .plus(digitCharacters)
        .plus(specialCharacters)

    private val sut: RandomCharacterGenerator = RandomCharacterGeneratorImpl()

    @Test
    fun generateUppercaseCharacter() {
        assertTrue(uppercaseCharacters.contains(sut.generateUppercaseCharacter()))
    }

    @Test
    fun generateLowercaseCharacter() {
        assertTrue(lowercaseCharacters.contains(sut.generateLowercaseCharacter()))
    }

    @Test
    fun generateDigitCharacter() {
        assertTrue(digitCharacters.contains(sut.generateDigitCharacter()))
    }

    @Test
    fun generateSpecialCharacter() {
        assertTrue(specialCharacters.contains(sut.generateSpecialCharacter()))
    }

    @Test
    fun generateAllowedCharacter() {
        assertTrue(allowedCharacters.contains(sut.generateAllowedCharacter()))
    }
}