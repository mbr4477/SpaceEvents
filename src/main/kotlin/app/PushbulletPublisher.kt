package app

import entity.SpaceEvent
import app.network.pushbullet.PushData
import app.network.pushbullet.PushbulletApiService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import usecases.ISpaceEventPublisher
import java.util.*

class PushbulletPublisher: ISpaceEventPublisher {
    val apiKey = ResourceBundle.getBundle("pushbullet").getString("API_KEY")

    val pushbulletApiService = Retrofit.Builder()
            .baseUrl("https://api.pushbullet.com/v2/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(PushbulletApiService::class.java)

    override fun publish(event: SpaceEvent) {
        pushbulletApiService.createPush(apiKey,PushData("Space Events", event.message)).subscribe()
    }
}