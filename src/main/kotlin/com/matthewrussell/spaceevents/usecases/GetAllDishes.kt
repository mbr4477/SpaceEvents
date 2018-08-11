package com.matthewrussell.spaceevents

import com.matthewrussell.spaceevents.entity.model.Dish
import com.matthewrussell.spaceevents.entity.persistence.IAppDatabase
import io.reactivex.Observable

class GetAllDishes(private val database: IAppDatabase) {
    fun execute(): Observable<List<Dish>> {
        return database.dishDao.getAll()
    }
}
