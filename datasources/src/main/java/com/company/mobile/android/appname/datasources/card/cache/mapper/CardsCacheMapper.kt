package com.company.mobile.android.appname.datasources.card.cache.mapper

import com.company.mobile.android.appname.datasources.card.cache.model.CardDbModel
import com.company.mobile.android.appname.model.card.Card

class CardsCacheMapper: EntityMapper<CardDbModel, Card> {

    override fun mapToCached(type: Card): CardDbModel {
        return CardDbModel(
            type.id,
            type.name,
            type.cmc,
            type.text,
            type.power,
            type.imageUrl
        )
    }

    override fun mapFromCached(type: CardDbModel): Card {
        return Card(
            type.id,
            type.name,
            type.cmc,
            type.text,
            type.power,
            type.imageUrl
        )
    }
}