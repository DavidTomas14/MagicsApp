package com.company.mobile.android.appname.data.bufferoo.repository

import com.company.mobile.android.appname.data.bufferoo.source.CardsDataStoreFactory
import com.company.mobile.android.appname.domain.card.repository.CardsRepository
import com.company.mobile.android.appname.model.card.Card
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class CardsRepositoryImpl(
    private val cardsDataStoreFactory: CardsDataStoreFactory
): CardsRepository {

    override fun getCards(): Single<List<Card>> {
        return cardsDataStoreFactory.retrieveCacheDataStore().getCards()
    }

    override fun saveCards(): Completable {
       return cardsDataStoreFactory.retrieveRemoteDataStore().fetchCards().flatMapCompletable {
            cardsDataStoreFactory.retrieveCacheDataStore().insertCards(it)
        }
    }
}