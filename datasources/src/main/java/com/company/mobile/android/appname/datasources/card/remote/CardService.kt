package com.company.mobile.android.appname.datasources.card.remote

import com.company.mobile.android.appname.datasources.card.remote.model.ObjectResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

/**
 * Defines the abstract methods used for interacting with the Bufferoo API
 */
interface CardService {

    companion object {
        const val BASE_URL = "https://api.magicthegathering.io/v1/"
    }


    @GET("cards")
    fun getCards(): Single<ObjectResponse>
}