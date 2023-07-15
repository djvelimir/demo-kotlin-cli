package validator

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ArgumentValidatorImplTest {
    private val sut: ArgumentValidator = ArgumentValidatorImpl()

    @Test
    fun validateCheckForGeneratePassword() {
        assertTrue(sut.validate(arrayOf("generate", "password")))
    }

    @Test
    fun validateCheckForInvalidArguments() {
        assertFalse(sut.validate(emptyArray()))
    }
}