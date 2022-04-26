package com.company.mobile.android.appname.domain.card.repository

import com.company.mobile.android.appname.model.card.Card
import io.reactivex.rxjava3.core.Single

interface CardsRepository {
    fun getCards(): Single<List<Card>>
}