package com.company.mobile.android.appname.data.bufferoo.source

class CardsDataStoreFactory(private val cardsRemoteDataStore: CardsRemoteDataStore) {

    fun retrieveRemoteDataStore(): CardsRemoteDataStore{
        return cardsRemoteDataStore
    }
}