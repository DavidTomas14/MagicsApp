package com.company.mobile.android.appname.datasources.card.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.company.mobile.android.appname.datasources.card.cache.dao.constants.CardsConstants
import com.company.mobile.android.appname.datasources.card.cache.dao.constants.CardsConstants.CARDS_TABLE

@Entity(tableName = CARDS_TABLE)
data class Card(
    @PrimaryKey
    val id: Int,
    val name: String,
    val cmc: Int,
    val text: String,
    val power: String,
    val imageUrl: String
)