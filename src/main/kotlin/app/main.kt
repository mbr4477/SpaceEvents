package app

import app.dsn.DeepSpaceNetwork
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val dsn = DeepSpaceNetwork(
            Injector.publisherInjector.inject(),
            Injector.preferencesInjector.inject()
    )

    // set up polling
    val interval = Observable.interval(0, 30, TimeUnit.SECONDS)
    interval.blockingSubscribe {
        dsn
                .update()
                .blockingAwait()
    }
}