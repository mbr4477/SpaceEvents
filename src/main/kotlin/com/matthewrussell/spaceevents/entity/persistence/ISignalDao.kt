package com.matthewrussell.spaceevents.entity.persistence

import com.matthewrussell.spaceevents.entity.model.Signal
import io.reactivex.Observable

interface ISignalDao : Dao<Signal> {
    fun getByDishId(dishId: Int): Observable<List<Signal>>
}