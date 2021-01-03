package com.irosu.gameoflife

/**
 * Main loop of the game
 */
fun main() {
    val board = Board()
    setUp(board)
    run(board, 8)
}

/**
 * Applies the rules in a loop
 */
fun run(board: Board, loops: Int, print: Boolean = true) {
    repeat((1..loops).count()) {
        if(print) println("Loop: ${it+1}")
        for ((i, value) in board.panel.withIndex()) {
            for ((j) in value.withIndex()) {
                prepareCells(board, i, j)
            }
        }
        updateBoard(board)
        if(print) board.print()
    }
}
