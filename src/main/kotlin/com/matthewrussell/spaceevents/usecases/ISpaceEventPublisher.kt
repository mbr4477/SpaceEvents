package com.matthewrussell.spaceevents

import com.matthewrussell.spaceevents.entity.SpaceEvent

interface ISpaceEventPublisher {
    fun publish(event: SpaceEvent)
}