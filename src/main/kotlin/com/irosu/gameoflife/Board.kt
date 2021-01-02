package com.irosu.gameoflife

fun setEmptyBoard(board: ArrayList<ArrayList<Char>>, side: Int) {
    repeat((1..side).count()) {
        val column = ArrayList<Char>()
        repeat((1..side).count()) { column.add('.') }
        board.add(column)
    }
}

/**
 * Applies the rules in a loop
 */
fun live(board: ArrayList<ArrayList<Char>>, loops: Int) {
    repeat((1..loops).count()) {
        for ((i) in board.withIndex()) {
            for ((j) in board.withIndex()) {
                applyRules(board, i, j)
            }
        }
        printBoard(board)
    }
}

/**
* Initialize our board with 8x8 size and '.' for every cell
*/
fun init(board: ArrayList<ArrayList<Char>>) {
    setEmptyBoard(board, 20)
    setDefault(board)
}

/**
* Puts a default figure in our board
*/
fun setDefault(board: ArrayList<ArrayList<Char>>) {
    board[5][5] = '*'
    board[6][6] = '*'
    board[7][4] = '*'
    board[7][5] = '*'
    board[7][6] = '*'
    printBoard(board)
}

/**
* Applies the rules of the game which are:
* 1. Any live cell with two or three live neighbours survives.
* 2. Any dead cell with three live neighbours becomes a live cell.
* 3. All other live cells die in the next generation.
*/
private fun applyRules(board: ArrayList<ArrayList<Char>>, x: Int, y: Int) {
    var livingCells = 0

    if (checkCell(board, x-1, y-1)) livingCells++
    if (checkCell(board, x-1, y)) livingCells++
    if (checkCell(board, x-1, y+1)) livingCells++
    if (checkCell(board, x, y-1)) livingCells++
    if (checkCell(board, x-1, y+1)) livingCells++
    if (checkCell(board, x+1, y-1)) livingCells++
    if (checkCell(board, x+1, y)) livingCells++
    if (checkCell(board, x+1, y+1)) livingCells++

    board[x][y] = if (livingCells == 3 || (board[x][y] == '*' && livingCells == 2)) '*' else '.'
}

/**
* Checks whether a cell is alive or not
*/
private fun checkCell(board: ArrayList<ArrayList<Char>>, x: Int, y: Int): Boolean {
    return x >= 0 && x < board.size && y >= 0 && y < board[x].size && board[x][y] == '*'
}

/**
* Prints de board
*/
private fun printBoard(board: ArrayList<ArrayList<Char>>) {
    board.forEach { c ->
        c.forEach { print("$it  ") }
        println()
    }
    println()
}

/**
* Checks whether a given board is the same as the actual one
*/
fun checkBoard(board: ArrayList<ArrayList<Char>>, testBoard: ArrayList<ArrayList<Char>>) = board == testBoard
