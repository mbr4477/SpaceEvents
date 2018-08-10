package com.matthewrussell.spaceevents.entity.model

data class Signal(
        var id: Int,
        var spacecraft: String,
        var type: String,
        var frequency: Double,
        var power: Double,
        var dataRate: Double,
        var rtlt: Double,
        var isDownlink: Boolean,
        var dish: Dish
)