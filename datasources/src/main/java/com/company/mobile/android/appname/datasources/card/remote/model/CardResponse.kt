package com.company.mobile.android.appname.datasources.card.remote.model

/**
 * Representation for a [BufferooResponse] fetched from the API
 */
data class CardResponse(
    val name: String,
    val cmc: Int,
    val text: String,
    val power: Int
)