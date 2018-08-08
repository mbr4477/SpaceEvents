package usecases

import entity.SpaceEvent

interface ISpaceEventPublisher {
    fun publish(event: SpaceEvent)
}