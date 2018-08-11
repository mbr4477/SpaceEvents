package com.matthewrussell.spaceevents.app.dsn

import com.matthewrussell.spaceevents.GetDishesFromDatabase
import com.matthewrussell.spaceevents.InsertNewSpaceEvent
import com.matthewrussell.spaceevents.app.Injector
import com.matthewrussell.spaceevents.entity.SpaceEvent
import com.matthewrussell.spaceevents.entity.persistence.IPreferences
import io.reactivex.Completable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import com.matthewrussell.spaceevents.usecases.ISpaceEventPublisher
import com.matthewrussell.spaceevents.usecases.InsertNewSpaceEvent
import java.util.*

class DeepSpaceNetwork(private val publisher: ISpaceEventPublisher, private val preferences: IPreferences) {
    private val PREFERENCES_KEY = "dsn"
    private val NASA_DSN_API_ENDPOINT = "https://eyes.nasa.gov/dsn/data/"

    private val dsnApiService = Retrofit.Builder()
            .baseUrl(NASA_DSN_API_ENDPOINT)
            .addConverterFactory(SimpleXmlConverterFactory.createNonStrict())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(DsnApiService::class.java)

    private fun mapDishToLocation(dish: String): String {
        when (dish) {
            "DSS24", "DSS25", "DSS26", "DSS14" -> return "Goldstone"
            "DSS65", "DSS54", "DSS55", "DSS63" -> return "Madrid"
            "DSS36", "DSS34", "DSS43", "DSS35" -> return "Canberra"
            else -> return ""
        }
    }

    private fun mapSignalToMessage(dish: DsnApiDish, signal: DsnApiSignal, isDownlink: Boolean): String {
        var message = "${mapDishToLocation(dish.name)} (${dish.name}) is now connected to ${signal.spacecraft} "
        message += if (isDownlink) "(downlink)" else "(uplink)"
        return message
    }

    fun update(): Completable {
        // retrieve status and put it in the preferences
        val date = Date()
        return Completable.fromObservable(dsnApiService
                .getStatus(date.time / 5000)
                .map {
                    it.dishes.flatMap { dish ->
                        dish.downSignals
                                .filter { it.signalType == "data" && it.dataRate.isNotEmpty() }
                                .map {
                                    mapSignalToMessage(dish, it, true)
                                }.union(dish.upSignals
                                        .filter { it.signalType == "data" }
                                        .map {
                                            mapSignalToMessage(dish, it, false)
                                        })
                    }
                }.map {
                    val previousList = preferences.getStringList(PREFERENCES_KEY)
                    val newItems = it.minus(previousList)
                    preferences.putStringList(PREFERENCES_KEY, it)
                    newItems
                }.map {
                    SpaceEvent(0, 0, it.joinToString("\n"))
                }.doOnNext {
                    // push results out via a use cases
                    println(it)
                    if (it.message.isNotEmpty()) {
                        InsertNewSpaceEvent(publisher)
                                .execute(it)
                                .subscribe()
                    }
                }.doOnError {

                })
    }
}