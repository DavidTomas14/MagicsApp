package com.company.mobile.android.appname.data.bufferoo.source

class CardsDataStoreFactory(
    private val cardsRemoteDataStore: CardsRemoteDataStore,
    private val cardsCacheDataStore: CardsCacheDataStore
    ) {

    fun retrieveRemoteDataStore(): CardsRemoteDataStore{
        return cardsRemoteDataStore
    }

    fun retrieveCacheDataStore(): CardsCacheDataStore{
        return cardsCacheDataStore
    }
}