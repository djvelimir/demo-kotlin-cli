package display

class TerminalImpl : Terminal {
    override fun show(message: String?) {
        println(message)
    }
}