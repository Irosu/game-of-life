package com.irosu.gameoflife

//TODO: ¿crear un segundo panel en el que ir guardando los cambios?
class Board {

    val panelA = ArrayList<ArrayList<Char>>()
    val panelB = ArrayList<ArrayList<Char>>()

    /**
     * Checks whether a cell is alive or not
     */
    fun checkCell(x: Int, y: Int): Boolean {
        return x >= 0 && x < panelA.size && y >= 0 && y < panelA[x].size && panelA[x][y] == '*'
    }

    fun getCell(x: Int, y: Int) = panelA[x][y]
    fun setCell(x: Int, y: Int, value: Char) {
        panelA[x][y] = value
    }

    /**
     * Initialize our board with 8x8 size and '.' for every cell
     */
    fun setEmptyBoard(side: Int) {
        repeat((1..side).count()) {
            val column = ArrayList<Char>()
            repeat((1..side).count()) { column.add('.') }
            panelA.add(column)
        }
    }

    /**
     * Draws a default figure in our board
     */
    fun setDefault() {
        panelA[5][5] = '*'
        panelA[6][6] = '*'
        panelA[7][4] = '*'
        panelA[7][5] = '*'
        panelA[7][6] = '*'
    }

    /**
     * Prints de board
     */
    fun print() {
        panelA.forEach { c ->
            c.forEach { print("$it  ") }
            println()
        }
        println()
    }
}
