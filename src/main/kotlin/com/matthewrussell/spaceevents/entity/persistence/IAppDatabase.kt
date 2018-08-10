package com.matthewrussell.spaceevents.entity.persistence

import com.matthewrussell.spaceevents.entity.model.Dish
import com.matthewrussell.spaceevents.entity.model.Signal

interface IAppDatabase {
    val dishDao: Dao<Dish>
    val signalDao: Dao<Signal>
}