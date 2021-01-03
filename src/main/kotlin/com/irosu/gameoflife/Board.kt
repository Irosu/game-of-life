package com.irosu.gameoflife

class Board {

    val panel = ArrayList<ArrayList<Cell>>()
    private val defaultSide = 20

    /**
     * Checks whether a cell is alive or not
     */
    fun checkCell(x: Int, y: Int) = x>=0 && x<panel.size && y>=0 && y<panel.size && panel[x][y].isAlive()

    /**
     * Initialize the board with the given (or default) size and full of dead cells
     */
    fun setEmptyBoard(side: Int = defaultSide) {
        repeat((1..side).count()) {
            val column = ArrayList<Cell>()
            repeat((1..side).count()) { column.add(Cell()) }
            panel.add(column)
        }
    }

    /**
     * Draws a default figure in the board
     */
    fun setDefault() {
        panel[5][5].revive()
        panel[6][6].revive()
        panel[7][4].revive()
        panel[7][5].revive()
        panel[7][6].revive()
    }

    /**
     * Prints the board
     */
    fun print() {
        panel.forEach { c ->
            c.forEach { print("$it  ") }
            println()
        }
        println()
    }

    override fun equals(other: Any?): Boolean {
        if(other == null || other !is Board) return false
        val panel2 = other.panel
        if(panel2.size != panel.size) return false

        for((r) in panel2.withIndex()) {
            for((c) in panel2.withIndex()) {
                if(panel2[r][c] != panel[r][c]) return false
            }
        }

        return true
    }

    override fun hashCode(): Int {
        var result = panel.hashCode()
        result = 31 * result + defaultSide
        return result
    }
}
