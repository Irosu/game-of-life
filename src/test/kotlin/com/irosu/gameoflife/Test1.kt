package com.irosu.gameoflife

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Test1 {

    private val mainLoop = MainLoop(5, false)
    private val board = Board()
    private val expected = Board()

    @BeforeAll
    fun setUp() {
        setTestBoard()
        setBoard()
        mainLoop.run()
    }

    @Test
    fun testAfterFiveLoops() {
        assertTrue(board == expected)
    }

    /**
     * Creates a new board in its default state
     */
    private fun setBoard() {
        board.setEmptyBoard()
        board.setDefault()
    }

    /**
     * Sets the expected board state after 5 loops
     */
    private fun setTestBoard() {
        expected.setEmptyBoard()
        val panel = expected.panel
        panel[7][5].revive()
        panel[7][7].revive()
        panel[8][6].revive()
        panel[8][7].revive()
        panel[9][6].revive()
    }
}
