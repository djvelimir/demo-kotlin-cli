package generator

import shuffler.StringShuffler

class PasswordGeneratorImpl(
    private val randomCharacterGenerator: RandomCharacterGenerator,
    private val stringShuffler: StringShuffler
) : PasswordGenerator {
    private var passwordLength = 0

    init {
        passwordLength = 16
    }

    override fun generate(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append(randomCharacterGenerator.generateUppercaseCharacter())
        stringBuilder.append(randomCharacterGenerator.generateLowercaseCharacter())
        stringBuilder.append(randomCharacterGenerator.generateDigitCharacter())
        stringBuilder.append(randomCharacterGenerator.generateSpecialCharacter())

        for (i in 0..<passwordLength - 4) {
            stringBuilder.append(randomCharacterGenerator.generateAllowedCharacter())
        }

        return stringShuffler.shuffle(stringBuilder.toString())
    }
}