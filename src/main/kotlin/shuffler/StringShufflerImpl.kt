package shuffler

import java.util.*


class StringShufflerImpl : StringShuffler {
    override fun shuffle(characters: String): String {
        val list = listOf(*characters.split("".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray())

        Collections.shuffle(list)

        return list.joinToString("")
    }
}