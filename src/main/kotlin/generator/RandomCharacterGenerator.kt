package generator

interface RandomCharacterGenerator {
    fun generateUppercaseCharacter(): Char

    fun generateLowercaseCharacter(): Char

    fun generateDigitCharacter(): Char

    fun generateSpecialCharacter(): Char

    fun generateAllowedCharacter(): Char
}