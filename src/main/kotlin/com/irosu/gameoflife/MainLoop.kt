package com.irosu.gameoflife

/**
 * Main loop of the game
 */
fun main() {
    val board = Board()
    init(board)
    live(board, 8)
}

/**
 * Applies the rules in a loop
 */
fun live(board: Board, loops: Int) {
    repeat((1..loops).count()) {
        for ((i, value) in board.panelA.withIndex()) {
            for ((j) in value.withIndex()) {
                applyRules(board, i, j)
            }
        }
        board.print()
    }
}

/**
 * Initialize our board with 8x8 size and '.' for every cell
 */
fun init(board: Board) {
    board.setEmptyBoard(20)
    board.setDefault()
}

/**
 * Applies the rules of the game which are:
 * 1. Any live cell with two or three live neighbours survives.
 * 2. Any dead cell with three live neighbours becomes a live cell.
 * 3. All other live cells die in the next generation.
 */
private fun applyRules(board: Board, x: Int, y: Int) {
    var livingCells = 0

    if (board.checkCell(x-1, y-1)) livingCells++
    if (board.checkCell(x-1, y)) livingCells++
    if (board.checkCell(x-1, y+1)) livingCells++
    if (board.checkCell(x, y-1)) livingCells++
    if (board.checkCell(x-1, y+1)) livingCells++
    if (board.checkCell(x+1, y-1)) livingCells++
    if (board.checkCell(x+1, y)) livingCells++
    if (board.checkCell(x+1, y+1)) livingCells++

    board.setCell(x,y, if (livingCells == 3 || (board.getCell(x,y) == '*' && livingCells == 2)) '*' else '.')
}

/**
 * Checks whether a given board is the same as the actual one
 */
fun checkBoard(board: Board, testBoard: Board) = board.panelA == testBoard.panelA
