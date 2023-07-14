package generator

import kotlin.random.Random

class RandomCharacterGeneratorImpl() : RandomCharacterGenerator {
    private val uppercaseCharacters: String
    private val lowercaseCharacters: String
    private val digitCharacters: String
    private val specialCharacters: String
    private var allowedCharacters: String
    private val random: Random = Random.Default

    init {
        uppercaseCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        lowercaseCharacters = "abcdefghijklmnopqrstuvwxyz"
        digitCharacters = "0123456789"
        specialCharacters = "~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?"
        allowedCharacters = uppercaseCharacters
            .plus(lowercaseCharacters)
            .plus(digitCharacters)
            .plus(specialCharacters)
    }

    override fun generateUppercaseCharacter(): Char {
        return uppercaseCharacters[random.nextInt(uppercaseCharacters.length)]
    }

    override fun generateLowercaseCharacter(): Char {
        return lowercaseCharacters[random.nextInt(lowercaseCharacters.length)]
    }

    override fun generateDigitCharacter(): Char {
        return digitCharacters[random.nextInt(digitCharacters.length)]
    }

    override fun generateSpecialCharacter(): Char {
        return specialCharacters[random.nextInt(specialCharacters.length)]
    }

    override fun generateAllowedCharacter(): Char {
        return allowedCharacters[random.nextInt(allowedCharacters.length)]
    }
}