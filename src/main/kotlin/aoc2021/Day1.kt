package aoc2021

fun main() {
    val depths = util.getInputForDay(1, 2021).split(System.lineSeparator()).map {
        it.toInt()
    }
    val partOne = depths.windowed(2, 1).filter {it[1] > it [0]}.count()
    val partTwo = depths.windowed(3, 1).map {it.sum()}.windowed(2,1).filter {it[1] > it [0]}.count()

    println("2021-01-01 - ${partOne}")
    println("2021-01-02 - ${partTwo}")
}