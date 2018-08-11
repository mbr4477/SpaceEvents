package com.matthewrussell.spaceevents

import com.matthewrussell.spaceevents.entity.model.Dish
import com.matthewrussell.spaceevents.entity.persistence.IAppDatabase
import io.reactivex.Completable

class SaveDish(private val database: IAppDatabase) {
    fun execute(input: Dish): Completable {
        return Completable.fromCallable {
            try {
                database.dishDao.insert(input)
            } catch (e: Exception) {
                println(e)
                database.dishDao.update(input)
            }
        }
    }

    fun execute(input: List<Dish>): Completable {
        return Completable.fromCallable {
            input.forEach {
                execute(it)
            }
        }
    }
}
