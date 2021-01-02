package com.irosu.gameoflife

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Test1 {

    private val board = Board()
    private val testBoard = Board()
    private val boardSide = 20

    @BeforeAll
    fun setUp() {
        setTestBoard()
        setBoard()
        live(board, 5)
    }

    @Test
    fun testAfterFiveLoops() {
        assertTrue(checkBoard(board, testBoard))
    }

    private fun setTestBoard() {
        testBoard.setEmptyBoard(boardSide)
        testBoard.setDefault()
        testBoard.setCell(6,4,'*')
        testBoard.setCell(6,6,'*')
        testBoard.setCell(7,5,'*')
        testBoard.setCell(7,6,'*')
        testBoard.setCell(8,5,'*')
    }

    private fun setBoard() {
        board.setEmptyBoard(boardSide)
        board.setDefault()
    }
}
