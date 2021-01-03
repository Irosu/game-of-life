package com.irosu.gameoflife

/**
 * Represents a cell with its actual and future state
 */
class Cell {

    private var state: Boolean = false
    private var change: Boolean = false

    /**
     * Prepares the cell to change its state in the next tick
     */
    fun prepare() {
        change = true
    }

    /**
     * Changes the state of the cell when it is time
     */
    fun update() {
        if(change) {
            if (isAlive()) kill() else revive()
            change = false
        }
    }

    fun isAlive() = state

    private fun kill() {
        state = false
    }

    fun revive() {
        state = true
    }

    /**
     * Returns true if the given cell has the same state as this one
     */
    override fun equals(other: Any?) = other != null && other is Cell && (other.isAlive() == state)
    override fun hashCode() = state.hashCode()
    override fun toString() = if(state) "*" else "."
}