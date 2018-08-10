package com.matthewrussell.spaceevents.app.persistence.database.mapper

import com.matthewrussell.spaceevents.app.persistence.database.ISignalEntity
import com.matthewrussell.spaceevents.app.persistence.database.dao.SignalEntity
import com.matthewrussell.spaceevents.entity.model.Dish
import com.matthewrussell.spaceevents.entity.model.Signal
import com.matthewrussell.spaceevents.entity.persistence.Dao
import io.reactivex.Observable

class SignalMapper(val dishDao: Dao<Dish>) {
    fun mapToEntity(signal: Signal): SignalEntity {
        val entity = SignalEntity()
        entity.id = signal.id
        entity.dishFk = signal.dish.id
        entity.dataRate = signal.dataRate
        entity.frequency = signal.frequency
        entity.isDownlink = signal.isDownlink
        entity.power = signal.power
        entity.signalType = signal.type
        entity.rtlt = signal.rtlt
        entity.spacecraft = signal.spacecraft
        return entity
    }

    fun mapFromEntity(entity: ISignalEntity): Observable<Signal> {
        return dishDao
                .getById(entity.dishFk)
                .map {
                    Signal(
                            entity.id,
                            entity.spacecraft,
                            entity.signalType,
                            entity.frequency,
                            entity.power,
                            entity.dataRate,
                            entity.rtlt,
                            entity.isDownlink,
                            it
                    )
                }
    }
}