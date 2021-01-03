package com.irosu.gameoflife

/**
 * Contains the logic needed to run the game
 */

/**
 * Initialize the default board
 */
fun setUp(board: Board) {
    board.setEmptyBoard()
    board.setDefault()
    board.print()
}

/**
 * Applies the rules of the game which are:
 * 1. Any alive cell with less than two or more than three alive neighbours dies.
 * 2. Any dead cell with three alive neighbours revives.
 */
fun prepareCells(board: Board, x: Int, y: Int) {
    val cell = board.panel[x][y]
    var aliveCells = 0

    if (board.checkCell(x-1,y-1)) aliveCells++
    if (board.checkCell(x-1,y)) aliveCells++
    if (board.checkCell(x-1,y+1)) aliveCells++
    if (board.checkCell(x,y-1)) aliveCells++
    if (board.checkCell(x,y+1)) aliveCells++
    if (board.checkCell(x+1,y-1)) aliveCells++
    if (board.checkCell(x+1,y)) aliveCells++
    if (board.checkCell(x+1,y+1)) aliveCells++

    if (cell.isAlive()) {
        //Rule 1
        if (aliveCells !in 2..3) cell.prepare()
    } else {
        //Rule 2
        if (aliveCells == 3) cell.prepare()
    }
}

/**
 * Updates the state of every cell of the board
 */
fun updateBoard(board: Board) {
    board.panel.forEach { it.forEach(Cell::update) }
}
