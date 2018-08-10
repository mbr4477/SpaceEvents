package com.matthewrussell.spaceevents.app.persistence.database.mapper

import com.matthewrussell.spaceevents.app.persistence.database.IDishEntity
import com.matthewrussell.spaceevents.app.persistence.database.dao.DishEntity
import com.matthewrussell.spaceevents.entity.model.Dish

class DishMapper {
    fun mapToEntity(dish: Dish): DishEntity {
        val entity = DishEntity()
        entity.id = dish.id
        entity.name = dish.name
        entity.location = dish.location
        entity.azimuthAngle = dish.azimuthAngle
        entity.elevationAngle = dish.elevationAngle
        return entity
    }

    fun mapFromEntity(entity: IDishEntity): Dish {
        return Dish(
                entity.id,
                entity.name,
                entity.location,
                entity.elevationAngle,
                entity.azimuthAngle
        )
    }
}