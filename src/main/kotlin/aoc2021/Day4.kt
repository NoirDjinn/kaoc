package aoc2021

data class BingoNumber(val num: Int, var isMarked: Boolean)

fun createBoards(inp: List<String>): MutableList<List<List<BingoNumber>>> {
    val boards = mutableListOf<List<List<BingoNumber>>>()
    var board = MutableList(5) { MutableList(5) { BingoNumber(0, false) } }
    var currInd = 0

    for (idx in 2 until inp.size) {
        if (currInd > 4) {
            boards.add(board)
            board = MutableList(5) { MutableList(5) { BingoNumber(0, false) } }
            currInd = 0
        } else {
            board[currInd] =
                inp[idx].split(' ').filter { it.isNotEmpty() }.map { BingoNumber(it.toInt(), false) }.toMutableList()
            currInd += 1
        }
    }

    return boards
}

fun markBoard(board: List<List<BingoNumber>>, number: Int): List<List<BingoNumber>> {
    for (line in board) {
        for (num in line) {
            if (num.num == number) {
                num.isMarked = true
            }
        }
    }
    return board
}

fun getFinalScore(board: List<List<BingoNumber>>): Long {
    return board.map { it.filter { num -> !num.isMarked }.map { num -> num.num }.sum() }.sum().toLong()
}

fun checkWin(board: List<List<BingoNumber>>): Boolean {
    var rowCount: Int
    var columnCount: Int

    for (idx in board[0].indices) {
        rowCount = board[idx].filter { it.isMarked }.count()
        columnCount = board.map { it[idx] }.filter { it.isMarked }.count()
        if (rowCount == board[0].size || columnCount == board[0].size) {
            return true
        }
    }

    return false
}

fun main() {
    val inp = util.getInputForDay(4, 2021).split(System.lineSeparator())
    val numbers = inp[0].split(',').map { it.toInt() }

    val boards = createBoards(inp)
    var partOne = -1L
    var partTwo = -1L
    val wonBoards = mutableSetOf<Int>()

    numbers.forEach {
        for (idx in boards.indices) {
            boards[idx] = markBoard(boards[idx], it)
            if (checkWin(boards[idx])) {
                val score = it * getFinalScore(boards[idx])
                if (partOne == -1L) {
                    partOne = score
                }
                if (!wonBoards.contains(idx)) {
                    partTwo = score
                    wonBoards.add(idx)
                }
            }
        }
    }

    println("2021-04-01 - ${partOne}")
    println("2021-04-02 - ${partTwo}")
}