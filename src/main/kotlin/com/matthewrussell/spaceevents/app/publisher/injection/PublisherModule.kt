package com.matthewrussell.spaceevents.app.publisher.injection

import dagger.Module
import dagger.Provides
import com.matthewrussell.spaceevents.usecases.app.publisher.pushbullet.PushbulletPublisher
import com.matthewrussell.spaceevents.usecases.ISpaceEventPublisher

@Module
class PublisherModule {
    @Provides
    fun providesPublisher() : ISpaceEventPublisher = PushbulletPublisher()
}