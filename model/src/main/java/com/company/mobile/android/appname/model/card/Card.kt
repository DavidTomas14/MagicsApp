package com.company.mobile.android.appname.model.card

import java.io.Serializable

data class Card(
    val id: Int,
    val name: String,
    val cmc: Int,
    val text: String,
    val power: String,
    val imageUrl: String
): Serializable
