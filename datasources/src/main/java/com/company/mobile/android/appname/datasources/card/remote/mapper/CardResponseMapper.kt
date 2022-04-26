package com.company.mobile.android.appname.datasources.card.remote.mapper

import com.company.mobile.android.appname.datasources.card.remote.model.CardResponse
import com.company.mobile.android.appname.model.card.Card
import com.hiberus.mobile.android.atenea.datasources.remote.mapper.EntityMapper

/**
 * Map a [BufferooResponse] to and from a [Bufferoo] instance when data is moving between
 * this later and the Data layer
 */
open class CardResponseMapper : EntityMapper<CardResponse, Card> {

    /**
     * Map an instance of a [BufferooResponse] to a [Bufferoo] model
     */
    override fun mapFromRemote(type: CardResponse): Card {
        return Card(type.name, type.cmc, type.text, type.power)
    }
}