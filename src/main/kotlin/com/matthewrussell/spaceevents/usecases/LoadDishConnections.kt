package com.matthewrussell.spaceevents

import com.matthewrussell.spaceevents.entity.DishLink
import com.matthewrussell.spaceevents.entity.persistence.IPreferences

class LoadDishConnections(private val preferences: IPreferences) : IUseCase<Unit, List<DishLink>> {
    override fun execute(input: Unit): List<DishLink> {
    }
}
