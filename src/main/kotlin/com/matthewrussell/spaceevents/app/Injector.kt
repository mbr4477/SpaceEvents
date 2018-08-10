package com.matthewrussell.spaceevents.app

import com.matthewrussell.spaceevents.app.persistence.injection.DaggerPersistenceComponent
import com.matthewrussell.spaceevents.app.publisher.injection.DaggerPublisherComponent

object Injector {
    val persistenceComponent = DaggerPersistenceComponent
            .builder()
            .build()

    val publisherComponent = DaggerPublisherComponent
            .builder()
            .build()
}