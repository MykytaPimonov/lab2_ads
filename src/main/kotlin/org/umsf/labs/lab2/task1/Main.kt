package org.umsf.labs.lab2.task1

public fun main() {
    println("Enter sorted array:")
    val arr = readln().trim().split(" ")
        .map { it.toInt() }
        .toTypedArray()
    println("Enter target element:")
    val target = readln().trim().toInt()

    val index = arr.customIndexOf(target)
    if (index == null) {
        println("$target is not contained in the entered array: ${arr.toList()}.")
    } else {
        println("arr[$index] = $target")
    }
}

private fun Array<Int>.customIndexOf(target: Int): Int? {
    var iterations = 0
    val log = { println("Was done $iterations iterations.") }
    var low = 0
    var high = size - 1
    var middle: Int

    while (this[low] < this[high]
        && this[low] <= target
        && target <= this[high]
    ) {
        iterations++
        middle = low + ((target - this[low]) * (high - low)) /
                (this[high] - this[low])

        if (target > this[middle]) {
            low = middle + 1
        } else if (target < this[high]) {
            high = middle
        } else {
            log()
            return middle
        }
    }

    log()
    return if (target == this[low]) low else null
}
