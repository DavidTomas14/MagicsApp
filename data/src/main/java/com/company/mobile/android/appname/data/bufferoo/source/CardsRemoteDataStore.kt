package com.company.mobile.android.appname.data.bufferoo.source

import com.company.mobile.android.appname.model.card.Card
import io.reactivex.rxjava3.core.Single

interface CardsRemoteDataStore {
    fun fetchCards(): Single<List<Card>>
}