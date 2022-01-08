package aoc2021

import kotlin.math.max
import kotlin.math.abs

fun coordsToRange(x1: Int, x2: Int, y1: Int, y2: Int): List<Pair<Int, Int>> {
    val steps = max(abs(x2 - x1), abs(y2 - y1))
    val dx = if (x1 == x2) 0 else (x2 - x1) / abs(x2 - x1)
    val dy = if (y1 == y2) 0 else (y2 - y1) / abs(y2 - y1)
    return (0..steps).map { i -> (x1 + i * dx) to (y1 + i * dy) }
}


fun main() {
    val inp = util.getInputForDay(5, 2021).split(System.lineSeparator())
    val diagram: HashMap<Pair<Int, Int>, Int> = hashMapOf()
    val diagramWithDiagonal: HashMap<Pair<Int, Int>, Int> = hashMapOf()

    inp.forEach {
        val lines = it.split("-> ").map { it.trim().split(',').map { it.toInt() } }
        val rng = coordsToRange(lines[0][0], lines[1][0], lines[0][1], lines[1][1])

        rng.forEach {
            if (lines[0][0] == lines[1][0] || lines[0][1] == lines[1][1]) {
                diagram[it] = diagram.getOrDefault(it, 0) + 1
            }
            diagramWithDiagonal[it] = diagramWithDiagonal.getOrDefault(it, 0) + 1
        }
    }


    val partOne = diagram.values.filter { it >= 2 }.count()
    val partTwo = diagramWithDiagonal.values.filter { it >= 2 }.count()

    println("2021-05-01 - ${partOne}")
    println("2021-05-02 - ${partTwo}")
}