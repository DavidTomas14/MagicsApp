package com.company.mobile.android.appname.datasources.card.remote.model

import com.google.gson.annotations.SerializedName

/**
 * Representation for a [BufferooResponse] fetched from the API
 */
data class CardResponse(
    @SerializedName("name")
    val name: String?,
    @SerializedName("cmc")
    val cmc: Int?,
    @SerializedName("text")
    val text: String?,
    @SerializedName("power")
    val power: String?,
    @SerializedName("imageUrl")
    val imageUrl: String?
)