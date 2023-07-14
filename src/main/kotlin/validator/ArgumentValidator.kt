package validator

interface ArgumentValidator {
    fun validate(args: Array<String>): Boolean
}