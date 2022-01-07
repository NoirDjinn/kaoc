package aoc2021

fun main() {
    val commands = util.getInputForDay(2, 2021).split(System.lineSeparator()).map {
        it.split(" ")
    }
    var aim = 0
    var depth = 0
    var depthWithAim = 0
    var horizontal = 0
    commands.forEach {
        val diff = it[1].toInt()
        when (it[0]) {
            "forward" -> {
                horizontal += diff
                depthWithAim += diff * aim
            }
            "down" -> {
                depth += diff
                aim += diff
            }
            "up" -> {
                depth -= diff
                aim -= diff
            }
            else -> {
                println("Unknown command!")
            }
        }
    }

    val partOne = horizontal * depth
    val partTwo: Long = horizontal.toLong() * depthWithAim.toLong()

    println("2021-02-01 - ${partOne}")
    println("2021-02-02 - ${partTwo}")
}