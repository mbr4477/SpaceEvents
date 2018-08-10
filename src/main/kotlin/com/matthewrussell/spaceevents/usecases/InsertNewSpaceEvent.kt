package com.matthewrussell.spaceevents

import com.matthewrussell.spaceevents.entity.SpaceEvent
import io.reactivex.Completable

class InsertNewSpaceEvent(private val eventPublisher: ISpaceEventPublisher) : IUseCase<SpaceEvent, Completable> {
    override fun execute(input: SpaceEvent): Completable {
        return Completable.fromAction {
            eventPublisher.publish(input)
        }
    }
}