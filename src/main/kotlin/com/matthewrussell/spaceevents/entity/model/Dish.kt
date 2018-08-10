package com.matthewrussell.spaceevents.entity.model

data class Dish(
        var id: Int,
        var name: String,
        var location: String,
        var elevationAngle: Double,
        val azimuthAngle: Double
)