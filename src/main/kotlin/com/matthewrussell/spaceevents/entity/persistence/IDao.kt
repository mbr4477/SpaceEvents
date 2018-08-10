package com.matthewrussell.spaceevents.entity.persistence

import io.reactivex.Completable
import io.reactivex.Observable

interface Dao<T> {
    fun insert(obj: T): Observable<Int>
    fun getById(id: Int): Observable<T>
    fun update(obj: T): Completable
    fun delete(obj: T): Completable
}