package org.umsf.labs.lab2.task2

public fun main() {
    println("Enter line:")
    val line = readln().trim()
    println("Enter char for computation its rate in passed line:")
    val target = readln().trim()[0]
    println("Frequency of occurrence of '$target' char in \"$line\": ${line.rate(target)}")
}

private fun String.rate(lexeme: Char): Double {
    val ignore = listOf('\n', '\r')
    var count = 0
    var len = 0
    forEach {
        if (!ignore.contains(it)) {
            len++
            if (it == lexeme) count++
        }
    }
    return count / len.toDouble()
}
