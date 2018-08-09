package app.publisher.injection

import dagger.Module
import dagger.Provides
import app.publisher.pushbullet.PushbulletPublisher
import usecases.ISpaceEventPublisher

@Module
class PublisherModule {
    @Provides
    fun providesPublisher() : ISpaceEventPublisher = PushbulletPublisher()
}