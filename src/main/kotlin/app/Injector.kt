package app

import app.persistence.injection.DaggerPreferencesComponent
import app.publisher.injection.DaggerPublisherComponent

object Injector {
    val preferencesInjector = DaggerPreferencesComponent
            .builder()
            .build()

    val publisherInjector = DaggerPublisherComponent
            .builder()
            .build()
}