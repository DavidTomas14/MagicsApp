package com.company.mobile.android.appname.data.bufferoo.source

import com.company.mobile.android.appname.model.card.Card
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface CardsCacheDataStore {
    fun getCards(): Single<List<Card>>

    fun insertCards(cards: List<Card>): Completable
}