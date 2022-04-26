package com.company.mobile.android.appname.datasources.card.remote.mapper

import com.company.mobile.android.appname.datasources.card.remote.model.CardResponse
import com.company.mobile.android.appname.model.card.Card
import com.company.mobile.android.appname.model.util.orDefault
import com.hiberus.mobile.android.atenea.datasources.remote.mapper.EntityMapper
import java.util.*

/**
 * Map a [BufferooResponse] to and from a [Bufferoo] instance when data is moving between
 * this later and the Data layer
 */
open class CardResponseMapper : EntityMapper<CardResponse, Card> {

    /**
     * Map an instance of a [BufferooResponse] to a [Bufferoo] model
     */
    override fun mapFromRemote(type: CardResponse): Card {
        return Card(
            (0..1000).random(),
            type.name.orEmpty(),
            type.cmc.orDefault(),
            type.text.orEmpty(),
            type.power.orEmpty(),
            type.imageUrl.orEmpty()
        )
    }
}