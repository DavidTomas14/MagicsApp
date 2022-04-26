package com.company.mobile.android.appname.datasources.card.remote

import com.company.mobile.android.appname.data.bufferoo.source.CardsRemoteDataStore
import com.company.mobile.android.appname.datasources.card.remote.mapper.CardResponseMapper
import com.company.mobile.android.appname.model.card.Card
import com.hiberus.mobile.android.atenea.datasources.remote.errorhandling.RemoteExceptionMapper
import io.reactivex.rxjava3.core.Single

/**
 * Remote implementation for retrieving Bufferoo instances. This class implements the
 * [BufferooRemote] from the Data layer as it is that layers responsibility for defining the
 * operations in which data store implementation layers can carry out.
 */
class CardsRemoteImpl constructor(
    private val cardService: CardService,
    private val cardResponseMapper: CardResponseMapper,
) : CardsRemoteDataStore {



    override fun getCards(): Single<List<Card>> {
        return cardService.getCards()
            .onErrorResumeNext { throwable ->
                // If remote request fails, use remote exception mapper to transform Retrofit exception to an app exception
                Single.error(RemoteExceptionMapper.getException(throwable))
            }
            .map { listResponse ->
                val entities = mutableListOf<Card>()
                listResponse.cards.forEach { card ->
                    entities.add(cardResponseMapper.mapFromRemote(card))
                }
                entities
            }
    }
    // endregion
}