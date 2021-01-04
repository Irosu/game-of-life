package com.irosu.gameoflife

/**
 * Main loop of the game
 */
fun main() {
    val mainLoop = MainLoop()
    mainLoop.run()
}

class MainLoop(private val loops: Int = 20, private val print: Boolean = true): Runnable {

    private val board = Board()
    init { setUp(board) }

    /**
     * Applies the rules in a loop
     */
    override fun run() {
        if(print) {
            println("Initial state\n")
            board.print()
            Thread.sleep(3000)
        }

        repeat((1..loops).count()) {
            if(print) {
                println("Loop: ${it+1}\n")
            }

            for ((i, value) in board.panel.withIndex()) {
                for ((j) in value.withIndex()) {
                    prepareCell(board, i, j)
                }
            }

            updateBoard(board)
            if(print) {
                board.print()
                Thread.sleep(500)
            }
        }
    }
}
