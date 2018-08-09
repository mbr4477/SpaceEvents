package app.publisher.pushbullet

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface PushbulletApiService {
    @Headers("Content-Type: application/json")
    @POST("pushes")
    fun createPush(@Header("Access-Token") token: String, @Body data: PushData) : Observable<ResponseBody>
}

data class PushData (
    val title: String,
    val body: String,
    val type: String = "note"
)