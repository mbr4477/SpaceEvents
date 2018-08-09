package app.publisher.injection

import dagger.Component
import usecases.ISpaceEventPublisher
import javax.inject.Singleton


@Component(modules = [PublisherModule::class])
@Singleton
interface PublisherComponent {
    fun inject(): ISpaceEventPublisher
}
