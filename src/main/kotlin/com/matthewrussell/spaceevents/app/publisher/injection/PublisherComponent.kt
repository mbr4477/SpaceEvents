package com.matthewrussell.spaceevents.app.publisher.injection

import dagger.Component
import com.matthewrussell.spaceevents.usecases.ISpaceEventPublisher
import javax.inject.Singleton


@Component(modules = [PublisherModule::class])
@Singleton
interface PublisherComponent {
    fun inject(): ISpaceEventPublisher
}
