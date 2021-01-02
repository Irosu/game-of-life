package com.irosu.gameoflife

fun main() {
    val board = ArrayList<ArrayList<Char>>()
    init(board)
    live(board, 8)
}
