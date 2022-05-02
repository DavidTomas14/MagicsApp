package com.company.mobile.android.appname.datasources.card.cache

import com.company.mobile.android.appname.data.bufferoo.source.CardsCacheDataStore
import com.company.mobile.android.appname.datasources.card.cache.db.CardsDatabase
import com.company.mobile.android.appname.datasources.card.cache.mapper.CardsCacheMapper
import com.company.mobile.android.appname.datasources.card.cache.model.CardDbModel
import com.company.mobile.android.appname.model.card.Card
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class CardsCacheImpl(
    val cardsDatabase: CardsDatabase,
    private val cardsEntityMapper: CardsCacheMapper,
) : CardsCacheDataStore {

    override fun getCards(): Single<List<Card>> {
       return cardsDatabase.cardDbModelDao().getCards().map {
            it.map{
                cardsEntityMapper.mapFromCached(it)
            }
        }
    }

    override fun insertCards(cards: List<Card>): Completable {
        val cardsDbModelList = arrayListOf<CardDbModel>()
        cards.forEach {
            cardsDbModelList.add(cardsEntityMapper.mapToCached(it))
        }
        return cardsDatabase.cardDbModelDao().insertCards(cardsDbModelList)
    }
}