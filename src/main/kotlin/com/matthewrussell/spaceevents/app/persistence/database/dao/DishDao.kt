package com.matthewrussell.spaceevents.app.persistence.database.dao

import com.matthewrussell.spaceevents.app.persistence.database.IDishEntity
import com.matthewrussell.spaceevents.app.persistence.database.mapper.DishMapper
import com.matthewrussell.spaceevents.entity.model.Dish
import com.matthewrussell.spaceevents.entity.persistence.Dao
import io.reactivex.Completable
import io.reactivex.Observable
import io.requery.Persistable
import io.requery.kotlin.eq
import io.requery.sql.KotlinEntityDataStore

class DishDao(private val dataStore: KotlinEntityDataStore<Persistable>, private val mapper: DishMapper): Dao<Dish> {
    override fun insert(obj: Dish): Observable<Int> {
        return Observable.fromCallable {
            dataStore.insert(mapper.mapToEntity(obj)).id
        }
    }

    override fun getById(id: Int): Observable<Dish> {
        return Observable.fromCallable {
            val entity = dataStore
                                            .select(IDishEntity::class)
                                            .where(IDishEntity::id eq id)
                                            .get()
                                            .first()
            mapper.mapFromEntity(entity)
        }
    }

    override fun update(obj: Dish): Completable {
        return Completable.fromCallable {
            dataStore.update(mapper.mapToEntity(obj))
        }
    }

    override fun delete(obj: Dish): Completable {
        return Completable.fromCallable {
            dataStore.delete(mapper.mapToEntity(obj))
        }
    }

}