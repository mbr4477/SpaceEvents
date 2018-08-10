package com.matthewrussell.spaceevents.app.dsn

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface DsnApiService {
    @GET("dsn.xml")
    fun getStatus(@Query("r") time: Long) : Observable<DsnApiStatus>
}