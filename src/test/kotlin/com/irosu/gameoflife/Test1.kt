package com.irosu.gameoflife

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Test1 {

    private val board = ArrayList<ArrayList<Char>>()
    private val testBoard = ArrayList<ArrayList<Char>>()
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
        setEmptyBoard(testBoard, boardSide)
        setDefault(testBoard)
        testBoard[6][4] = '*'
        testBoard[6][6] = '*'
        testBoard[7][5] = '*'
        testBoard[7][6] = '*'
        testBoard[8][5] = '*'
    }

    private fun setBoard() {
        setEmptyBoard(board, boardSide)
        setDefault(board)
    }
}
