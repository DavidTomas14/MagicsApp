package com.company.mobile.android.appname.datasources.card.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.company.mobile.android.appname.datasources.card.cache.dao.constants.CardsConstants.GET_CARDS
import com.company.mobile.android.appname.datasources.card.cache.model.CardDbModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
abstract class CardDbModelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertCards(cardDbModel: List<CardDbModel>): Completable

    @Query(GET_CARDS)
    abstract fun getCards(): Single<List<CardDbModel>>
}