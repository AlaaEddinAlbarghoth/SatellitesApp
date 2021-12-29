package com.alaaeddinalbarghoth.cache.model.positions

data class Position(
    val posX: Double,
    val posY: Double
) {
    override fun toString(): String = "($posX, $posY)"

}
