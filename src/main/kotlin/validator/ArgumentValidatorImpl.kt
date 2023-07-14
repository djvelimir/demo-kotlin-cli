package validator

class ArgumentValidatorImpl : ArgumentValidator {
    override fun validate(args: Array<String>): Boolean {
        return args.isNotEmpty() && args.size == 2 && args[0] == "generate" && args[1] == "password"
    }
}