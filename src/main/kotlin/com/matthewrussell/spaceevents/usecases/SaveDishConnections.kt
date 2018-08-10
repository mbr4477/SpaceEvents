package com.matthewrussell.spaceevents

import com.matthewrussell.spaceevents.entity.DishLink
import com.matthewrussell.spaceevents.entity.persistence.IPreferences

class SaveDishConnections(private val preferences: IPreferences) : IUseCase<List<DishLink>, Unit> {
    override fun execute(input: List<DishLink>) {
    }
}
