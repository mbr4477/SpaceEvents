package app

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val dsn = DeepSpaceNetwork()
    val interval = Observable.interval(0, 30, TimeUnit.SECONDS)
    interval.blockingSubscribe {
        dsn.update().blockingAwait()
    }
}