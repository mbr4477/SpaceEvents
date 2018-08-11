package com.matthewrussell.spaceevents.app.persistence.database.dao

import com.matthewrussell.spaceevents.app.persistence.database.IDishEntity
import com.matthewrussell.spaceevents.app.persistence.database.ISignalEntity
import com.matthewrussell.spaceevents.app.persistence.database.mapper.SignalMapper
import com.matthewrussell.spaceevents.entity.model.Dish
import com.matthewrussell.spaceevents.entity.model.Signal
import com.matthewrussell.spaceevents.entity.persistence.ISignalDao
import io.reactivex.Completable
import io.reactivex.Observable
import io.requery.Persistable
import io.requery.kotlin.eq
import io.requery.sql.KotlinEntityDataStore

class SignalDao(private val dataStore: KotlinEntityDataStore<Persistable>, private val mapper: SignalMapper) : ISignalDao {
    override fun insert(obj: Signal): Observable<Int> {
        return Observable.fromCallable {
            dataStore.insert(mapper.mapToEntity(obj)).id
        }
    }

    override fun getById(id: Int): Observable<Signal> {
        return Observable.fromCallable {
                dataStore
                        .select(ISignalEntity::class)
                        .where(ISignalEntity::id eq id)
                        .get()
                        .first()
            }.flatMap {
                mapper.mapFromEntity(it)
            }
    }

    override fun getAll(): Observable<List<Signal>> {
        return Observable.fromCallable {
            dataStore
                    .select(ISignalEntity::class)
                    .get()
                    .toList()

        }.flatMap {
            Observable.zip(it.map { mapper.mapFromEntity(it) }) {
                it.toList() as List<Signal>
            }
        }
    }

    override fun getByDishId(dishId: Int): Observable<List<Signal>> {
        return Observable.fromCallable {
            dataStore
                    .select(ISignalEntity::class)
                    .where(ISignalEntity::dishFk eq dishId)
                    .get()
                    .toList()
        }.flatMap {
            Observable.zip(it.map { mapper.mapFromEntity(it) }) {
                it.toList() as List<Signal>
            }
        }
    }

    override fun update(obj: Signal): Completable {
        return Completable.fromCallable {
            dataStore.update(mapper.mapToEntity((obj)))
        }
    }

    override fun delete(obj: Signal): Completable {
        return Completable.fromCallable {
            dataStore.delete(mapper.mapToEntity(obj))
        }
    }

}