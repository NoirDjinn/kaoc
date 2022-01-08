package aoc2021

fun processDayPart2(lanternfish: MutableList<Int>, days: Int): Long {
    val mutated: MutableMap<Long, Long> = mutableMapOf()

    lanternfish.forEach {
        mutated[it.toLong()] = mutated.getOrDefault(it.toLong(), 0) + 1L
    }

    for (i in 0 until days) {
        val idx = i.toLong()
        mutated[(idx + 7) % 9] =
            mutated.getOrDefault((idx + 7) % 9, 0L) + mutated.getOrDefault(idx % 9, 0L)
    }

    return mutated.values.sum()
}

fun main() {
    val fishes = util.getInputForDay(6, 2021).split(',').map { it.toInt() }.toMutableList()

    val partOne = processDayPart2(fishes, 80)
    val partTwo = processDayPart2(fishes, 256)

    println("2021-06-01 - $partOne")
    println("2021-06-02 - $partTwo")
}