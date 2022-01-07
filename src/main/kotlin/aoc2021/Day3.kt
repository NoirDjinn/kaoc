package aoc2021

fun mostCommonBits(input: List<List<Int>>): List<Int> {
    val counts = IntArray(input[0].size) { 0 }
    input.forEach {
        for (ind in it.indices) {
            if (it[ind] == 1) {
                counts[ind] += 1
            }
        }
    }
    return counts.map { if (it >= input.size / 2.0) 1 else 0 }
}

fun filterList(input: List<List<Int>>, useLeast: Boolean): List<Int> {
    var remaining = input
    var idx = 0

    while (remaining.size > 1) {
        val counts = mostCommonBits(remaining)
        if (!useLeast) {
            remaining = remaining.filter {
                it[idx] == counts[idx]
            }
        } else {
            remaining = remaining.filter {
                it[idx] != counts[idx]
            }
        }
        idx++
    }
    return remaining.first()
}


fun main() {
    val report = util.getInputForDay(3, 2021).split(System.lineSeparator()).map {
        it.toList().map(Character::getNumericValue)
    }

    val counts = mostCommonBits(report)
    val gamma = counts.joinToString("").toInt(2)
    val epsilon = (counts.joinToString("") { if (it == 0) "1" else "0" }).toInt(2)

    val oxygenRating = filterList(report, false).joinToString("").toInt(2)
    val scrubberRating = filterList(report, true).joinToString("").toInt(2)

    val partOne = gamma * epsilon
    val partTwo = oxygenRating * scrubberRating

    println("2021-03-01 - ${partOne}")
    println("2021-03-02 - ${partTwo}")
}