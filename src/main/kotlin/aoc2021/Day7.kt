package aoc2021

import kotlin.math.abs
import kotlin.math.min

fun sumOfProgression(n: Long): Long {
    return n * (n + 1) / 2
}

fun getAlignmentPrice(pos: Long, brachyuras: List<Long>): Long {
    return brachyuras.map { abs(it - pos) }.sum()
}

fun getAlignmentPriceNonLinear(pos: Long, brachyuras: List<Long>): Long {
    return brachyuras.map { sumOfProgression(abs(it - pos)) }.sum()
}

fun main() {
    val crabs = util.getInputForDay(7, 2021).split(",").map { it.toLong() }
    val highestCrab = crabs.maxOf { it }
    var minPrice = Long.MAX_VALUE
    var minPriceNonLinear = Long.MAX_VALUE

    for (i in 0..highestCrab) {
        minPrice = min(getAlignmentPrice(i, crabs), minPrice)
        minPriceNonLinear = min(getAlignmentPriceNonLinear(i, crabs), minPriceNonLinear)
    }

    val partOne = minPrice
    val partTwo = minPriceNonLinear

    println("2021-07-01 - $partOne")
    println("2021-07-02 - $partTwo")
}